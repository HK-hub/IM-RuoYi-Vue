<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="主键" prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入主键"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="名片背景" prop="cardBackground">
        <el-input
          v-model="queryParams.cardBackground"
          placeholder="请输入名片背景"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="聊天背景" prop="talkBackground">
        <el-input
          v-model="queryParams.talkBackground"
          placeholder="请输入聊天背景"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="主题模式" prop="theme">
        <el-input
          v-model="queryParams.theme"
          placeholder="请输入主题模式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="新消息提示" prop="newMessageRemind">
        <el-input
          v-model="queryParams.newMessageRemind"
          placeholder="请输入新消息提示"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="系统消息通知" prop="messageNotify">
        <el-input
          v-model="queryParams.messageNotify"
          placeholder="请输入系统消息通知"
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
          v-hasPermi="['im:setting:add']"
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
          v-hasPermi="['im:setting:edit']"
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
          v-hasPermi="['im:setting:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['im:setting:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="settingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="名片背景" align="center" prop="cardBackground" />
      <el-table-column label="聊天背景" align="center" prop="talkBackground" />
      <el-table-column label="主题模式" align="center" prop="theme" />
      <el-table-column label="新消息提示" align="center" prop="newMessageRemind" />
      <el-table-column label="系统消息通知" align="center" prop="messageNotify" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['im:setting:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['im:setting:remove']"
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

    <!-- 添加或修改用户个性化设置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="名片背景" prop="cardBackground">
          <el-input v-model="form.cardBackground" placeholder="请输入名片背景" />
        </el-form-item>
        <el-form-item label="聊天背景" prop="talkBackground">
          <el-input v-model="form.talkBackground" placeholder="请输入聊天背景" />
        </el-form-item>
        <el-form-item label="主题模式" prop="theme">
          <el-input v-model="form.theme" placeholder="请输入主题模式" />
        </el-form-item>
        <el-form-item label="新消息提示" prop="newMessageRemind">
          <el-input v-model="form.newMessageRemind" placeholder="请输入新消息提示" />
        </el-form-item>
        <el-form-item label="系统消息通知" prop="messageNotify">
          <el-input v-model="form.messageNotify" placeholder="请输入系统消息通知" />
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
import { listSetting, getSetting, delSetting, addSetting, updateSetting } from "@/api/im/setting";

export default {
  name: "Setting",
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
      // 用户个性化设置表格数据
      settingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: null,
        userId: null,
        cardBackground: null,
        talkBackground: null,
        theme: null,
        newMessageRemind: null,
        messageNotify: null,
      },
      // 表单参数
      form: {
        id: null,
        userId: null,
        cardBackground: null,
        talkBackground: null,
        theme: null,
        newMessageRemind: null,
        messageNotify: null,
        createTime: null,
        updateTime: null
      },
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询用户个性化设置列表 */
    getList() {
      this.loading = true;
      listSetting(this.queryParams).then(response => {
        this.settingList = response.rows;
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
        userId: null,
        cardBackground: null,
        talkBackground: null,
        theme: null,
        newMessageRemind: null,
        messageNotify: null,
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
      this.title = "添加用户个性化设置";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSetting(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户个性化设置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSetting(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSetting(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除用户个性化设置编号为"' + ids + '"的数据项？').then(function() {
        return delSetting(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('im/setting/export', {
        ...this.queryParams
      }, `setting_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
