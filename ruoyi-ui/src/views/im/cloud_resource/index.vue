<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="文件资源属主id" prop="belongId">
        <el-input
          v-model="queryParams.belongId"
          placeholder="请输入文件资源属主id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否是文件夹路径" prop="directory">
        <el-input
          v-model="queryParams.directory"
          placeholder="请输入是否是文件夹路径"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资源名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入资源名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资源描述" prop="description">
        <el-input
          v-model="queryParams.description"
          placeholder="请输入资源描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文件url链接" prop="url">
        <el-input
          v-model="queryParams.url"
          placeholder="请输入文件url链接"
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
      <el-form-item label="文件hash值" prop="hash">
        <el-input
          v-model="queryParams.hash"
          placeholder="请输入文件hash值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资源文件md5" prop="md5">
        <el-input
          v-model="queryParams.md5"
          placeholder="请输入资源文件md5"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文件资源计数器" prop="count">
        <el-input
          v-model="queryParams.count"
          placeholder="请输入文件资源计数器"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否删除" prop="deleted">
        <el-input
          v-model="queryParams.deleted"
          placeholder="请输入是否删除"
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
          v-hasPermi="['im:cloud_resource:add']"
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
          v-hasPermi="['im:cloud_resource:edit']"
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
          v-hasPermi="['im:cloud_resource:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['im:cloud_resource:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cloud_resourceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="云盘id" align="center" prop="id" />
      <el-table-column label="文件资源属主id" align="center" prop="belongId" />
      <el-table-column label="是否是文件夹路径" align="center" prop="directory" />
      <el-table-column label="资源类型" align="center" prop="resourceType" />
      <el-table-column label="资源名称" align="center" prop="name" />
      <el-table-column label="资源描述" align="center" prop="description" />
      <el-table-column label="资源扩展名(文件扩展名)" align="center" prop="extendType" />
      <el-table-column label="文件url链接" align="center" prop="url" />
      <el-table-column label="文件大小" align="center" prop="size" />
      <el-table-column label="文件hash值" align="center" prop="hash" />
      <el-table-column label="资源文件md5" align="center" prop="md5" />
      <el-table-column label="文件资源计数器" align="center" prop="count" />
      <el-table-column label="是否删除" align="center" prop="deleted" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['im:cloud_resource:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['im:cloud_resource:remove']"
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

    <!-- 添加或修改云资源管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="文件资源属主id" prop="belongId">
          <el-input v-model="form.belongId" placeholder="请输入文件资源属主id" />
        </el-form-item>
        <el-form-item label="是否是文件夹路径" prop="directory">
          <el-input v-model="form.directory" placeholder="请输入是否是文件夹路径" />
        </el-form-item>
        <el-form-item label="资源名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入资源名称" />
        </el-form-item>
        <el-form-item label="资源描述" prop="description">
          <el-input v-model="form.description" placeholder="请输入资源描述" />
        </el-form-item>
        <el-form-item label="文件url链接" prop="url">
          <el-input v-model="form.url" placeholder="请输入文件url链接" />
        </el-form-item>
        <el-form-item label="文件大小" prop="size">
          <el-input v-model="form.size" placeholder="请输入文件大小" />
        </el-form-item>
        <el-form-item label="文件hash值" prop="hash">
          <el-input v-model="form.hash" placeholder="请输入文件hash值" />
        </el-form-item>
        <el-form-item label="资源文件md5" prop="md5">
          <el-input v-model="form.md5" placeholder="请输入资源文件md5" />
        </el-form-item>
        <el-form-item label="文件资源计数器" prop="count">
          <el-input v-model="form.count" placeholder="请输入文件资源计数器" />
        </el-form-item>
        <el-form-item label="是否删除" prop="deleted">
          <el-input v-model="form.deleted" placeholder="请输入是否删除" />
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
import { listCloud_resource, getCloud_resource, delCloud_resource, addCloud_resource, updateCloud_resource } from "@/api/im/cloud_resource";

export default {
  name: "Cloud_resource",
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
      // 云资源管理表格数据
      cloud_resourceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        belongId: null,
        directory: null,
        resourceType: null,
        name: null,
        description: null,
        extendType: null,
        url: null,
        size: null,
        hash: null,
        md5: null,
        count: null,
        deleted: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询云资源管理列表 */
    getList() {
      this.loading = true;
      listCloud_resource(this.queryParams).then(response => {
        this.cloud_resourceList = response.rows;
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
        belongId: null,
        directory: null,
        resourceType: null,
        name: null,
        description: null,
        extendType: null,
        url: null,
        size: null,
        hash: null,
        md5: null,
        count: null,
        deleted: null,
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
      this.title = "添加云资源管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCloud_resource(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改云资源管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCloud_resource(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCloud_resource(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除云资源管理编号为"' + ids + '"的数据项？').then(function() {
        return delCloud_resource(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('im/cloud_resource/export', {
        ...this.queryParams
      }, `cloud_resource_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
