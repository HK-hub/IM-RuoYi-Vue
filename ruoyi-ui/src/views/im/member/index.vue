<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="群id" prop="groupId">
        <el-input
          v-model="queryParams.groupId"
          placeholder="请输入群id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群号" prop="groupAccount">
        <el-input
          v-model="queryParams.groupAccount"
          placeholder="请输入群号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群成员id" prop="memberId">
        <el-input
          v-model="queryParams.memberId"
          placeholder="请输入群成员id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群外昵称" prop="memberUsername">
        <el-input
          v-model="queryParams.memberUsername"
          placeholder="请输入群外昵称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群内昵称" prop="memberRemarkName">
        <el-input
          v-model="queryParams.memberRemarkName"
          placeholder="请输入群内昵称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="头像" prop="memberAvatar">
        <el-input
          v-model="queryParams.memberAvatar"
          placeholder="请输入头像"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群员角色" prop="memberRole">
        <el-input
          v-model="queryParams.memberRole"
          placeholder="请输入群员角色"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群分组" prop="groupCategory">
        <el-input
          v-model="queryParams.groupCategory"
          placeholder="请输入群分组"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="禁言时间：表示禁止发言的结束时间" prop="gagTime">
        <el-date-picker clearable
          v-model="queryParams.gagTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择禁言时间：表示禁止发言的结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="最后确认的消息id" prop="lastAckMessage">
        <el-input
          v-model="queryParams.lastAckMessage"
          placeholder="请输入最后确认的消息id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="禁言" prop="muted">
        <el-input
          v-model="queryParams.muted"
          placeholder="请输入禁言"
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
          v-hasPermi="['im:member:add']"
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
          v-hasPermi="['im:member:edit']"
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
          v-hasPermi="['im:member:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['im:member:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="memberList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="群id" align="center" prop="groupId" />
      <el-table-column label="群号" align="center" prop="groupAccount" />
      <el-table-column label="群成员id" align="center" prop="memberId" />
      <el-table-column label="群外昵称" align="center" prop="memberUsername" />
      <el-table-column label="群内昵称" align="center" prop="memberRemarkName" />
      <el-table-column label="头像" align="center" prop="memberAvatar" />
      <el-table-column label="群员角色" align="center" prop="memberRole" />
      <el-table-column label="群分组" align="center" prop="groupCategory" />
      <el-table-column label="禁言时间：表示禁止发言的结束时间" align="center" prop="gagTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.gagTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="最后确认的消息id" align="center" prop="lastAckMessage" />
      <el-table-column label="群状态" align="center" prop="status" />
      <el-table-column label="禁言" align="center" prop="muted" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['im:member:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['im:member:remove']"
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

    <!-- 添加或修改群员管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="群id" prop="groupId">
          <el-input v-model="form.groupId" placeholder="请输入群id" />
        </el-form-item>
        <el-form-item label="群号" prop="groupAccount">
          <el-input v-model="form.groupAccount" placeholder="请输入群号" />
        </el-form-item>
        <el-form-item label="群成员id" prop="memberId">
          <el-input v-model="form.memberId" placeholder="请输入群成员id" />
        </el-form-item>
        <el-form-item label="群外昵称" prop="memberUsername">
          <el-input v-model="form.memberUsername" placeholder="请输入群外昵称" />
        </el-form-item>
        <el-form-item label="群内昵称" prop="memberRemarkName">
          <el-input v-model="form.memberRemarkName" placeholder="请输入群内昵称" />
        </el-form-item>
        <el-form-item label="头像" prop="memberAvatar">
          <el-input v-model="form.memberAvatar" placeholder="请输入头像" />
        </el-form-item>
        <el-form-item label="群员角色" prop="memberRole">
          <el-input v-model="form.memberRole" placeholder="请输入群员角色" />
        </el-form-item>
        <el-form-item label="群分组" prop="groupCategory">
          <el-input v-model="form.groupCategory" placeholder="请输入群分组" />
        </el-form-item>
        <el-form-item label="禁言时间：表示禁止发言的结束时间" prop="gagTime">
          <el-date-picker clearable
            v-model="form.gagTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择禁言时间：表示禁止发言的结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="最后确认的消息id" prop="lastAckMessage">
          <el-input v-model="form.lastAckMessage" placeholder="请输入最后确认的消息id" />
        </el-form-item>
        <el-form-item label="禁言" prop="muted">
          <el-input v-model="form.muted" placeholder="请输入禁言" />
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
import { listMember, getMember, delMember, addMember, updateMember } from "@/api/im/member";

export default {
  name: "Member",
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
      // 群员管理表格数据
      memberList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        groupId: null,
        groupAccount: null,
        memberId: null,
        memberUsername: null,
        memberRemarkName: null,
        memberAvatar: null,
        memberRole: null,
        groupCategory: null,
        gagTime: null,
        lastAckMessage: null,
        status: null,
        muted: null,
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
    /** 查询群员管理列表 */
    getList() {
      this.loading = true;
      listMember(this.queryParams).then(response => {
        this.memberList = response.rows;
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
        groupId: null,
        groupAccount: null,
        memberId: null,
        memberUsername: null,
        memberRemarkName: null,
        memberAvatar: null,
        memberRole: null,
        groupCategory: null,
        gagTime: null,
        lastAckMessage: null,
        status: null,
        muted: null,
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
      this.title = "添加群员管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMember(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改群员管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMember(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMember(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除群员管理编号为"' + ids + '"的数据项？').then(function() {
        return delMember(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('im/member/export', {
        ...this.queryParams
      }, `member_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
