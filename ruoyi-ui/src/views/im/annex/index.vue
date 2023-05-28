<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="笔记id" prop="noteId">
        <el-input
          v-model="queryParams.noteId"
          placeholder="请输入笔记id"
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
      <el-form-item label="附件大小：字节" prop="size">
        <el-input
          v-model="queryParams.size"
          placeholder="请输入附件大小：字节"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="附件名称" prop="originalName">
        <el-input
          v-model="queryParams.originalName"
          placeholder="请输入附件名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="附件url地址" prop="url">
        <el-input
          v-model="queryParams.url"
          placeholder="请输入附件url地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否删除：用于回收站处理" prop="deleted">
        <el-input
          v-model="queryParams.deleted"
          placeholder="请输入是否删除：用于回收站处理"
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
          v-hasPermi="['im:annex:add']"
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
          v-hasPermi="['im:annex:edit']"
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
          v-hasPermi="['im:annex:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['im:annex:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="annexList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="附件id" align="center" prop="id" />
      <el-table-column label="笔记id" align="center" prop="noteId" />
      <el-table-column label="文件后缀" align="center" prop="suffix" />
      <el-table-column label="附件大小：字节" align="center" prop="size" />
      <el-table-column label="附件名称" align="center" prop="originalName" />
      <el-table-column label="附件url地址" align="center" prop="url" />
      <el-table-column label="是否删除：用于回收站处理" align="center" prop="deleted" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['im:annex:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['im:annex:remove']"
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

    <!-- 添加或修改笔记附件对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="笔记id" prop="noteId">
          <el-input v-model="form.noteId" placeholder="请输入笔记id" />
        </el-form-item>
        <el-form-item label="文件后缀" prop="suffix">
          <el-input v-model="form.suffix" placeholder="请输入文件后缀" />
        </el-form-item>
        <el-form-item label="附件大小：字节" prop="size">
          <el-input v-model="form.size" placeholder="请输入附件大小：字节" />
        </el-form-item>
        <el-form-item label="附件名称" prop="originalName">
          <el-input v-model="form.originalName" placeholder="请输入附件名称" />
        </el-form-item>
        <el-form-item label="附件url地址" prop="url">
          <el-input v-model="form.url" placeholder="请输入附件url地址" />
        </el-form-item>
        <el-form-item label="是否删除：用于回收站处理" prop="deleted">
          <el-input v-model="form.deleted" placeholder="请输入是否删除：用于回收站处理" />
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
import { listAnnex, getAnnex, delAnnex, addAnnex, updateAnnex } from "@/api/im/annex";

export default {
  name: "Annex",
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
      // 笔记附件表格数据
      annexList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        noteId: null,
        suffix: null,
        size: null,
        originalName: null,
        url: null,
        deleted: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        noteId: [
          { required: true, message: "笔记id不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询笔记附件列表 */
    getList() {
      this.loading = true;
      listAnnex(this.queryParams).then(response => {
        this.annexList = response.rows;
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
        noteId: null,
        suffix: null,
        size: null,
        originalName: null,
        url: null,
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
      this.title = "添加笔记附件";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAnnex(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改笔记附件";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAnnex(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAnnex(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除笔记附件编号为"' + ids + '"的数据项？').then(function() {
        return delAnnex(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('im/annex/export', {
        ...this.queryParams
      }, `annex_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
