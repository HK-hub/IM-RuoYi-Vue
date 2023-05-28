<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="资源id" prop="resourceId">
        <el-input
          v-model="queryParams.resourceId"
          placeholder="请输入资源id"
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
      <el-form-item label="文件后缀" prop="suffix">
        <el-input
          v-model="queryParams.suffix"
          placeholder="请输入文件后缀"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文件地址(相对地址)" prop="path">
        <el-input
          v-model="queryParams.path"
          placeholder="请输入文件地址(相对地址)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="网络地址(公开文件地址)" prop="url">
        <el-input
          v-model="queryParams.url"
          placeholder="请输入网络地址(公开文件地址)"
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
          v-hasPermi="['im:message_file:add']"
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
          v-hasPermi="['im:message_file:edit']"
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
          v-hasPermi="['im:message_file:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['im:message_file:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="message_fileList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="文件ID" align="center" prop="id" />
      <el-table-column label="资源id" align="center" prop="resourceId" />
      <el-table-column label="消息记录ID" align="center" prop="messageId" />
      <el-table-column label="上传文件的用户ID" align="center" prop="userId" />
      <el-table-column label="文件来源[1:用户上传;2:表情包;]" align="center" prop="source" />
      <el-table-column label="文件类型[1:图片;2:音频文件;3:视频文件;4:其它文件;]" align="center" prop="type" />
      <el-table-column label="驱动类型[1:local;2:cos;]" align="center" prop="drive" />
      <el-table-column label="原文件名" align="center" prop="originalName" />
      <el-table-column label="文件后缀" align="center" prop="suffix" />
      <el-table-column label="文件大小" align="center" prop="size" />
      <el-table-column label="文件地址(相对地址)" align="center" prop="path" />
      <el-table-column label="网络地址(公开文件地址)" align="center" prop="url" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['im:message_file:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['im:message_file:remove']"
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

    <!-- 添加或修改文件消息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="资源id" prop="resourceId">
          <el-input v-model="form.resourceId" placeholder="请输入资源id" />
        </el-form-item>
        <el-form-item label="原文件名" prop="originalName">
          <el-input v-model="form.originalName" placeholder="请输入原文件名" />
        </el-form-item>
        <el-form-item label="文件后缀" prop="suffix">
          <el-input v-model="form.suffix" placeholder="请输入文件后缀" />
        </el-form-item>
        <el-form-item label="文件地址(相对地址)" prop="path">
          <el-input v-model="form.path" placeholder="请输入文件地址(相对地址)" />
        </el-form-item>
        <el-form-item label="网络地址(公开文件地址)" prop="url">
          <el-input v-model="form.url" placeholder="请输入网络地址(公开文件地址)" />
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
import { listMessage_file, getMessage_file, delMessage_file, addMessage_file, updateMessage_file } from "@/api/im/message_file";

export default {
  name: "Message_file",
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
      // 文件消息表格数据
      message_fileList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        resourceId: null,
        messageId: null,
        userId: null,
        source: null,
        type: null,
        drive: null,
        originalName: null,
        suffix: null,
        size: null,
        path: null,
        url: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        messageId: [
          { required: true, message: "消息记录ID不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "上传文件的用户ID不能为空", trigger: "blur" }
        ],
        source: [
          { required: true, message: "文件来源[1:用户上传;2:表情包;]不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "文件类型[1:图片;2:音频文件;3:视频文件;4:其它文件;]不能为空", trigger: "change" }
        ],
        drive: [
          { required: true, message: "驱动类型[1:local;2:cos;]不能为空", trigger: "blur" }
        ],
        originalName: [
          { required: true, message: "原文件名不能为空", trigger: "blur" }
        ],
        suffix: [
          { required: true, message: "文件后缀不能为空", trigger: "blur" }
        ],
        size: [
          { required: true, message: "文件大小不能为空", trigger: "blur" }
        ],
        path: [
          { required: true, message: "文件地址(相对地址)不能为空", trigger: "blur" }
        ],
        url: [
          { required: true, message: "网络地址(公开文件地址)不能为空", trigger: "blur" }
        ],
        updateTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询文件消息列表 */
    getList() {
      this.loading = true;
      listMessage_file(this.queryParams).then(response => {
        this.message_fileList = response.rows;
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
        resourceId: null,
        messageId: null,
        userId: null,
        source: null,
        type: null,
        drive: null,
        originalName: null,
        suffix: null,
        size: null,
        path: null,
        url: null,
        updateTime: null,
        createTime: null
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
      this.title = "添加文件消息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMessage_file(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改文件消息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMessage_file(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMessage_file(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除文件消息编号为"' + ids + '"的数据项？').then(function() {
        return delMessage_file(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('im/message_file/export', {
        ...this.queryParams
      }, `message_file_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
