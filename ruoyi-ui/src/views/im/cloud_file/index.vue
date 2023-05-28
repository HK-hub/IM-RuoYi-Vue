<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="客户ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入客户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文件名字" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入文件名字"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否收藏" prop="collection">
        <el-input
          v-model="queryParams.collection"
          placeholder="请输入是否收藏"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文件夹" prop="fDir">
        <el-input
          v-model="queryParams.fDir"
          placeholder="请输入文件夹"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="视频" prop="videoId">
        <el-input
          v-model="queryParams.videoId"
          placeholder="请输入视频"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文件大小" prop="size">
        <el-input
          v-model="queryParams.size"
          placeholder="请输入文件大小"
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
          v-hasPermi="['im:cloud_file:add']"
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
          v-hasPermi="['im:cloud_file:edit']"
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
          v-hasPermi="['im:cloud_file:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['im:cloud_file:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cloud_fileList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="地址" align="center" prop="url" />
      <el-table-column label="客户ID" align="center" prop="userId" />
      <el-table-column label="文件名字" align="center" prop="name" />
      <el-table-column label="文件类型" align="center" prop="type" />
      <el-table-column label="是否收藏" align="center" prop="collection" />
      <el-table-column label="文件夹" align="center" prop="fDir" />
      <el-table-column label="文件类型" align="center" prop="filetype" />
      <el-table-column label="视频" align="center" prop="videoId" />
      <el-table-column label="文件大小" align="center" prop="size" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['im:cloud_file:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['im:cloud_file:remove']"
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

    <!-- 添加或修改云文件管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="地址" prop="url">
          <el-input v-model="form.url" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="客户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入客户ID" />
        </el-form-item>
        <el-form-item label="文件名字" prop="name">
          <el-input v-model="form.name" placeholder="请输入文件名字" />
        </el-form-item>
        <el-form-item label="是否收藏" prop="collection">
          <el-input v-model="form.collection" placeholder="请输入是否收藏" />
        </el-form-item>
        <el-form-item label="文件夹" prop="fDir">
          <el-input v-model="form.fDir" placeholder="请输入文件夹" />
        </el-form-item>
        <el-form-item label="视频" prop="videoId">
          <el-input v-model="form.videoId" placeholder="请输入视频" />
        </el-form-item>
        <el-form-item label="文件大小" prop="size">
          <el-input v-model="form.size" placeholder="请输入文件大小" />
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
import { listCloud_file, getCloud_file, delCloud_file, addCloud_file, updateCloud_file } from "@/api/im/cloud_file";

export default {
  name: "Cloud_file",
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
      // 云文件管理表格数据
      cloud_fileList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        url: null,
        userId: null,
        name: null,
        type: null,
        collection: null,
        fDir: null,
        filetype: null,
        videoId: null,
        size: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        updateTime: [
          { required: true, message: "更新时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询云文件管理列表 */
    getList() {
      this.loading = true;
      listCloud_file(this.queryParams).then(response => {
        this.cloud_fileList = response.rows;
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
        url: null,
        userId: null,
        name: null,
        type: null,
        createTime: null,
        updateTime: null,
        collection: null,
        fDir: null,
        filetype: null,
        videoId: null,
        size: null
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
      this.title = "添加云文件管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCloud_file(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改云文件管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCloud_file(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCloud_file(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除云文件管理编号为"' + ids + '"的数据项？').then(function() {
        return delCloud_file(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('im/cloud_file/export', {
        ...this.queryParams
      }, `cloud_file_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
