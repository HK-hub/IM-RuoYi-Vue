<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="群号" prop="groupAccount">
        <el-input
          v-model="queryParams.groupAccount"
          placeholder="请输入群号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群定位" prop="position">
        <el-input
          v-model="queryParams.position"
          placeholder="请输入群定位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群人数限制" prop="memberCapacity">
        <el-input
          v-model="queryParams.memberCapacity"
          placeholder="请输入群人数限制"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="加群问题" prop="problem">
        <el-input
          v-model="queryParams.problem"
          placeholder="请输入加群问题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="加群问题答案" prop="answer">
        <el-input
          v-model="queryParams.answer"
          placeholder="请输入加群问题答案"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="全员禁言" prop="forbidSend">
        <el-input
          v-model="queryParams.forbidSend"
          placeholder="请输入全员禁言"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否允许群聊临时会话" prop="enableTemporary">
        <el-input
          v-model="queryParams.enableTemporary"
          placeholder="请输入是否允许群聊临时会话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群最新公告" prop="announcement">
        <el-input
          v-model="queryParams.announcement"
          placeholder="请输入群最新公告"
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
      <el-table-column label="群id" align="center" prop="groupId" />
      <el-table-column label="群号" align="center" prop="groupAccount" />
      <el-table-column label="群定位" align="center" prop="position" />
      <el-table-column label="群人数限制" align="center" prop="memberCapacity" />
      <el-table-column label="发现群方式" align="center" prop="findType" />
      <el-table-column label="加群方式：1.允许任" align="center" prop="joinType" />
      <el-table-column label="加群问题" align="center" prop="problem" />
      <el-table-column label="加群问题答案" align="center" prop="answer" />
      <el-table-column label="全员禁言" align="center" prop="forbidSend" />
      <el-table-column label="是否允许群聊临时会话" align="center" prop="enableTemporary" />
      <el-table-column label="群最新公告" align="center" prop="announcement" />
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

    <!-- 添加或修改群设置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="群号" prop="groupAccount">
          <el-input v-model="form.groupAccount" placeholder="请输入群号" />
        </el-form-item>
        <el-form-item label="群定位" prop="position">
          <el-input v-model="form.position" placeholder="请输入群定位" />
        </el-form-item>
        <el-form-item label="群人数限制" prop="memberCapacity">
          <el-input v-model="form.memberCapacity" placeholder="请输入群人数限制" />
        </el-form-item>
        <el-form-item label="加群问题" prop="problem">
          <el-input v-model="form.problem" placeholder="请输入加群问题" />
        </el-form-item>
        <el-form-item label="加群问题答案" prop="answer">
          <el-input v-model="form.answer" placeholder="请输入加群问题答案" />
        </el-form-item>
        <el-form-item label="全员禁言" prop="forbidSend">
          <el-input v-model="form.forbidSend" placeholder="请输入全员禁言" />
        </el-form-item>
        <el-form-item label="是否允许群聊临时会话" prop="enableTemporary">
          <el-input v-model="form.enableTemporary" placeholder="请输入是否允许群聊临时会话" />
        </el-form-item>
        <el-form-item label="群最新公告" prop="announcement">
          <el-input v-model="form.announcement" placeholder="请输入群最新公告" />
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
import { listSetting, getSetting, delSetting, addSetting, updateSetting } from "@/api/im/group_setting";

export default {
  name: "GroupSetting",
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
      // 群设置表格数据
      settingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        groupAccount: null,
        position: null,
        memberCapacity: null,
        findType: null,
        joinType: null,
        problem: null,
        answer: null,
        forbidSend: null,
        enableTemporary: null,
        announcement: null,
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
    /** 查询群设置列表 */
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
        groupId: null,
        groupAccount: null,
        position: null,
        memberCapacity: null,
        findType: null,
        joinType: null,
        problem: null,
        answer: null,
        forbidSend: null,
        enableTemporary: null,
        announcement: null,
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
      this.ids = selection.map(item => item.groupId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加群设置";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const groupId = row.groupId || this.ids
      getSetting(groupId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改群设置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.groupId != null) {
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
      const groupIds = row.groupId || this.ids;
      this.$modal.confirm('是否确认删除群设置编号为"' + groupIds + '"的数据项？').then(function() {
        return delSetting(groupIds);
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
