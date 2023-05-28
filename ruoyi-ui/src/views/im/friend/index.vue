<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="好友id" prop="friendId">
        <el-input
          v-model="queryParams.friendId"
          placeholder="请输入好友id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="relation">
        <el-input
          v-model="queryParams.relation"
          placeholder="请输入状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分组" prop="group">
        <el-input
          v-model="queryParams.group"
          placeholder="请输入分组"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分组id" prop="groupId">
        <el-input
          v-model="queryParams.groupId"
          placeholder="请输入分组id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="好友昵称" prop="nickname">
        <el-input
          v-model="queryParams.nickname"
          placeholder="请输入好友昵称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注姓名" prop="remarkName">
        <el-input
          v-model="queryParams.remarkName"
          placeholder="请输入备注姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注信息" prop="remarkInfo">
        <el-input
          v-model="queryParams.remarkInfo"
          placeholder="请输入备注信息"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="机器人" prop="robot">
        <el-input
          v-model="queryParams.robot"
          placeholder="请输入机器人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="头像" prop="avatar">
        <el-input
          v-model="queryParams.avatar"
          placeholder="请输入头像"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="消息免打扰" prop="disturb">
        <el-input
          v-model="queryParams.disturb"
          placeholder="请输入消息免打扰"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="置顶" prop="top">
        <el-input
          v-model="queryParams.top"
          placeholder="请输入置顶"
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
          v-hasPermi="['im:friend:add']"
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
          v-hasPermi="['im:friend:edit']"
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
          v-hasPermi="['im:friend:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['im:friend:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="friendList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="好友id" align="center" prop="friendId" />
      <el-table-column label="状态" align="center" prop="relation" />
      <el-table-column label="分组" align="center" prop="group" />
      <el-table-column label="分组id" align="center" prop="groupId" />
      <el-table-column label="好友昵称" align="center" prop="nickname" />
      <el-table-column label="备注姓名" align="center" prop="remarkName" />
      <el-table-column label="备注信息" align="center" prop="remarkInfo" />
      <el-table-column label="机器人" align="center" prop="robot" />
      <el-table-column label="头像" align="center" prop="avatar" />
      <el-table-column label="消息免打扰" align="center" prop="disturb" />
      <el-table-column label="置顶" align="center" prop="top" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['im:friend:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['im:friend:remove']"
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

    <!-- 添加或修改好友管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="好友id" prop="friendId">
          <el-input v-model="form.friendId" placeholder="请输入好友id" />
        </el-form-item>
        <el-form-item label="状态" prop="relation">
          <el-input v-model="form.relation" placeholder="请输入状态" />
        </el-form-item>
        <el-form-item label="分组" prop="group">
          <el-input v-model="form.group" placeholder="请输入分组" />
        </el-form-item>
        <el-form-item label="分组id" prop="groupId">
          <el-input v-model="form.groupId" placeholder="请输入分组id" />
        </el-form-item>
        <el-form-item label="好友昵称" prop="nickname">
          <el-input v-model="form.nickname" placeholder="请输入好友昵称" />
        </el-form-item>
        <el-form-item label="备注姓名" prop="remarkName">
          <el-input v-model="form.remarkName" placeholder="请输入备注姓名" />
        </el-form-item>
        <el-form-item label="备注信息" prop="remarkInfo">
          <el-input v-model="form.remarkInfo" placeholder="请输入备注信息" />
        </el-form-item>
        <el-form-item label="机器人" prop="robot">
          <el-input v-model="form.robot" placeholder="请输入机器人" />
        </el-form-item>
        <el-form-item label="头像" prop="avatar">
          <el-input v-model="form.avatar" placeholder="请输入头像" />
        </el-form-item>
        <el-form-item label="消息免打扰" prop="disturb">
          <el-input v-model="form.disturb" placeholder="请输入消息免打扰" />
        </el-form-item>
        <el-form-item label="置顶" prop="top">
          <el-input v-model="form.top" placeholder="请输入置顶" />
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
import { listFriend, getFriend, delFriend, addFriend, updateFriend } from "@/api/im/friend";

export default {
  name: "Friend",
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
      // 好友管理表格数据
      friendList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        friendId: null,
        relation: null,
        group: null,
        groupId: null,
        nickname: null,
        remarkName: null,
        remarkInfo: null,
        robot: null,
        avatar: null,
        disturb: null,
        top: null,
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
    /** 查询好友管理列表 */
    getList() {
      this.loading = true;
      listFriend(this.queryParams).then(response => {
        this.friendList = response.rows;
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
        friendId: null,
        relation: null,
        group: null,
        groupId: null,
        nickname: null,
        remarkName: null,
        remarkInfo: null,
        robot: null,
        avatar: null,
        disturb: null,
        top: null,
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
      this.title = "添加好友管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getFriend(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改好友管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateFriend(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFriend(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除好友管理编号为"' + ids + '"的数据项？').then(function() {
        return delFriend(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('im/friend/export', {
        ...this.queryParams
      }, `friend_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
