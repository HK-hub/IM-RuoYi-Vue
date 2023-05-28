<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="临时文件hash名，md5" prop="uploadId">
        <el-input
          v-model="queryParams.uploadId"
          placeholder="请输入临时文件hash名，md5"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="原文件名" prop="originalName">
        <el-input
          v-model="queryParams.originalName"
          placeholder="请输入原文件名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="临时保存路径" prop="path">
        <el-input
          v-model="queryParams.path"
          placeholder="请输入临时保存路径"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文件后缀名" prop="fileExt">
        <el-input
          v-model="queryParams.fileExt"
          placeholder="请输入文件后缀名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['im:upload:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['im:upload:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['im:upload:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['im:upload:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="uploadList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="临时文件ID" align="center" prop="id" />
      <el-table-column label="文件属性" align="center" prop="type" />
      <el-table-column label="驱动类型" align="center" prop="drive" />
      <el-table-column label="临时文件hash名，md5" align="center" prop="uploadId" />
      <el-table-column label="上传的用户ID" align="center" prop="userId" />
      <el-table-column label="原文件名" align="center" prop="originalName" />
      <el-table-column label="当前索引块" align="center" prop="splitIndex" />
      <el-table-column label="总上传索引块" align="center" prop="splitNum" />
      <el-table-column label="临时保存路径" align="center" prop="path" />
      <el-table-column label="文件后缀名" align="center" prop="fileExt" />
      <el-table-column label="文件大小" align="center" prop="fileSize" />
      <el-table-column label="文件是否删除" align="center" prop="isDelete" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['im:upload:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['im:upload:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改文件分片数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="临时文件hash名，md5" prop="uploadId">
          <el-input v-model="form.uploadId" placeholder="请输入临时文件hash名，md5" />
        </el-form-item>
        <el-form-item label="原文件名" prop="originalName">
          <el-input v-model="form.originalName" placeholder="请输入原文件名" />
        </el-form-item>
        <el-form-item label="临时保存路径" prop="path">
          <el-input v-model="form.path" placeholder="请输入临时保存路径" />
        </el-form-item>
        <el-form-item label="文件后缀名" prop="fileExt">
          <el-input v-model="form.fileExt" placeholder="请输入文件后缀名" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listUpload, getUpload, delUpload, addUpload, updateUpload } from "@/api/im/upload";

export default {
  name: "Upload",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 文件分片数据表格数据
      uploadList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        type: null,
        drive: null,
        uploadId: null,
        userId: null,
        originalName: null,
        splitIndex: null,
        splitNum: null,
        path: null,
        fileExt: null,
        fileSize: null,
        isDelete: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        type: [
          { required: true, message: "文件属性不能为空", trigger: "change" }
        ],
        drive: [
          { required: true, message: "驱动类型不能为空", trigger: "blur" }
        ],
        uploadId: [
          { required: true, message: "临时文件hash名，md5不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "上传的用户ID不能为空", trigger: "blur" }
        ],
        originalName: [
          { required: true, message: "原文件名不能为空", trigger: "blur" }
        ],
        splitIndex: [
          { required: true, message: "当前索引块不能为空", trigger: "blur" }
        ],
        splitNum: [
          { required: true, message: "总上传索引块不能为空", trigger: "blur" }
        ],
        path: [
          { required: true, message: "临时保存路径不能为空", trigger: "blur" }
        ],
        fileExt: [
          { required: true, message: "文件后缀名不能为空", trigger: "blur" }
        ],
        fileSize: [
          { required: true, message: "文件大小不能为空", trigger: "blur" }
        ],
        isDelete: [
          { required: true, message: "文件是否删除不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "更新时间不能为空", trigger: "blur" }
        ],
        updateTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询文件分片数据列表 */
    getList() {
      this.loading = true;
      listUpload(this.queryParams).then(response => {
        this.uploadList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        type: null,
        drive: null,
        uploadId: null,
        userId: null,
        originalName: null,
        splitIndex: null,
        splitNum: null,
        path: null,
        fileExt: null,
        fileSize: null,
        isDelete: null,
        createTime: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加文件分片数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getUpload(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改文件分片数据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateUpload(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addUpload(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除文件分片数据编号为"' + ids + '"的数据项？').then(function() {
        return delUpload(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('im/upload/export', {
        ...this.queryParams
      }, `upload_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
