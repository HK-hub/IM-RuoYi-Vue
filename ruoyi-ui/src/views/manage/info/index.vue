<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="昵称" prop="nickname">
        <el-input
          v-model="queryParams.nickname"
          placeholder="请输入昵称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="QQ号" prop="qq">
        <el-input
          v-model="queryParams.qq"
          placeholder="请输入QQ号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="微信号" prop="wechat">
        <el-input
          v-model="queryParams.wechat"
          placeholder="请输入微信号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="github 账号" prop="github">
        <el-input
          v-model="queryParams.github"
          placeholder="请输入github 账号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="钉钉账号" prop="dingtalk">
        <el-input
          v-model="queryParams.dingtalk"
          placeholder="请输入钉钉账号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="openid" prop="openid">
        <el-input
          v-model="queryParams.openid"
          placeholder="请输入openid"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户钱包剩余余额" prop="wallet">
        <el-input
          v-model="queryParams.wallet"
          placeholder="请输入用户钱包剩余余额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最后交互间" prop="lastTime">
        <el-date-picker clearable
          v-model="queryParams.lastTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择最后交互间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-input
          v-model="queryParams.gender"
          placeholder="请输入性别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input
          v-model="queryParams.age"
          placeholder="请输入年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="生日" prop="birthday">
        <el-date-picker clearable
          v-model="queryParams.birthday"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择生日">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="星座" prop="constellation">
        <el-input
          v-model="queryParams.constellation"
          placeholder="请输入星座"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学校" prop="campus">
        <el-input
          v-model="queryParams.campus"
          placeholder="请输入学校"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专业" prop="major">
        <el-input
          v-model="queryParams.major"
          placeholder="请输入专业"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="职业" prop="job">
        <el-input
          v-model="queryParams.job"
          placeholder="请输入职业"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="城市" prop="city">
        <el-input
          v-model="queryParams.city"
          placeholder="请输入城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="兴趣爱好" prop="interest">
        <el-input
          v-model="queryParams.interest"
          placeholder="请输入兴趣爱好"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="个人标签" prop="tag">
        <el-input
          v-model="queryParams.tag"
          placeholder="请输入个人标签"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="个性签名" prop="signature">
        <el-input
          v-model="queryParams.signature"
          placeholder="请输入个性签名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="加好友策" prop="addFriendPolicy">
        <el-input
          v-model="queryParams.addFriendPolicy"
          placeholder="请输入加好友策"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="加好友问题" prop="addFriendQuestion">
        <el-input
          v-model="queryParams.addFriendQuestion"
          placeholder="请输入加好友问题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="加好友答案" prop="addFriendAnswer">
        <el-input
          v-model="queryParams.addFriendAnswer"
          placeholder="请输入加好友答案"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="存储空间" prop="storage">
        <el-input
          v-model="queryParams.storage"
          placeholder="请输入存储空间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="名片背景" prop="background">
        <el-input
          v-model="queryParams.background"
          placeholder="请输入名片背景"
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
          v-hasPermi="['manage:info:add']"
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
          v-hasPermi="['manage:info:edit']"
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
          v-hasPermi="['manage:info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['manage:info:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="昵称" align="center" prop="nickname" />
      <el-table-column label="QQ号" align="center" prop="qq" />
      <el-table-column label="微信号" align="center" prop="wechat" />
      <el-table-column label="github 账号" align="center" prop="github" />
      <el-table-column label="钉钉账号" align="center" prop="dingtalk" />
      <el-table-column label="openid" align="center" prop="openid" />
      <el-table-column label="用户钱包剩余余额" align="center" prop="wallet" />
      <el-table-column label="最后交互间" align="center" prop="lastTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="用户状态" align="center" prop="status" />
      <el-table-column label="性别" align="center" prop="gender" />
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="生日" align="center" prop="birthday" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="星座" align="center" prop="constellation" />
      <el-table-column label="学校" align="center" prop="campus" />
      <el-table-column label="专业" align="center" prop="major" />
      <el-table-column label="职业" align="center" prop="job" />
      <el-table-column label="城市" align="center" prop="city" />
      <el-table-column label="兴趣爱好" align="center" prop="interest" />
      <el-table-column label="个人标签" align="center" prop="tag" />
      <el-table-column label="个性签名" align="center" prop="signature" />
      <el-table-column label="加好友策" align="center" prop="addFriendPolicy" />
      <el-table-column label="加好友问题" align="center" prop="addFriendQuestion" />
      <el-table-column label="加好友答案" align="center" prop="addFriendAnswer" />
      <el-table-column label="存储空间" align="center" prop="storage" />
      <el-table-column label="名片背景" align="center" prop="background" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['manage:info:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['manage:info:remove']"
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

    <!-- 添加或修改个人信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="昵称" prop="nickname">
          <el-input v-model="form.nickname" placeholder="请输入昵称" />
        </el-form-item>
        <el-form-item label="QQ号" prop="qq">
          <el-input v-model="form.qq" placeholder="请输入QQ号" />
        </el-form-item>
        <el-form-item label="微信号" prop="wechat">
          <el-input v-model="form.wechat" placeholder="请输入微信号" />
        </el-form-item>
        <el-form-item label="github 账号" prop="github">
          <el-input v-model="form.github" placeholder="请输入github 账号" />
        </el-form-item>
        <el-form-item label="钉钉账号" prop="dingtalk">
          <el-input v-model="form.dingtalk" placeholder="请输入钉钉账号" />
        </el-form-item>
        <el-form-item label="openid" prop="openid">
          <el-input v-model="form.openid" placeholder="请输入openid" />
        </el-form-item>
        <el-form-item label="用户钱包剩余余额" prop="wallet">
          <el-input v-model="form.wallet" placeholder="请输入用户钱包剩余余额" />
        </el-form-item>
        <el-form-item label="最后交互间" prop="lastTime">
          <el-date-picker clearable
            v-model="form.lastTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最后交互间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-input v-model="form.gender" placeholder="请输入性别" />
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="生日" prop="birthday">
          <el-date-picker clearable
            v-model="form.birthday"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择生日">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="星座" prop="constellation">
          <el-input v-model="form.constellation" placeholder="请输入星座" />
        </el-form-item>
        <el-form-item label="学校" prop="campus">
          <el-input v-model="form.campus" placeholder="请输入学校" />
        </el-form-item>
        <el-form-item label="专业" prop="major">
          <el-input v-model="form.major" placeholder="请输入专业" />
        </el-form-item>
        <el-form-item label="职业" prop="job">
          <el-input v-model="form.job" placeholder="请输入职业" />
        </el-form-item>
        <el-form-item label="城市" prop="city">
          <el-input v-model="form.city" placeholder="请输入城市" />
        </el-form-item>
        <el-form-item label="兴趣爱好" prop="interest">
          <el-input v-model="form.interest" placeholder="请输入兴趣爱好" />
        </el-form-item>
        <el-form-item label="个人标签" prop="tag">
          <el-input v-model="form.tag" placeholder="请输入个人标签" />
        </el-form-item>
        <el-form-item label="个性签名" prop="signature">
          <el-input v-model="form.signature" placeholder="请输入个性签名" />
        </el-form-item>
        <el-form-item label="加好友策" prop="addFriendPolicy">
          <el-input v-model="form.addFriendPolicy" placeholder="请输入加好友策" />
        </el-form-item>
        <el-form-item label="加好友问题" prop="addFriendQuestion">
          <el-input v-model="form.addFriendQuestion" placeholder="请输入加好友问题" />
        </el-form-item>
        <el-form-item label="加好友答案" prop="addFriendAnswer">
          <el-input v-model="form.addFriendAnswer" placeholder="请输入加好友答案" />
        </el-form-item>
        <el-form-item label="存储空间" prop="storage">
          <el-input v-model="form.storage" placeholder="请输入存储空间" />
        </el-form-item>
        <el-form-item label="名片背景" prop="background">
          <el-input v-model="form.background" placeholder="请输入名片背景" />
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
import { listInfo, getInfo, delInfo, addInfo, updateInfo } from "@/api/manage/info";

export default {
  name: "Info",
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
      // 个人信息表格数据
      infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        nickname: null,
        qq: null,
        wechat: null,
        github: null,
        dingtalk: null,
        openid: null,
        wallet: null,
        lastTime: null,
        status: null,
        gender: null,
        age: null,
        birthday: null,
        constellation: null,
        campus: null,
        major: null,
        job: null,
        city: null,
        interest: null,
        tag: null,
        signature: null,
        addFriendPolicy: null,
        addFriendQuestion: null,
        addFriendAnswer: null,
        storage: null,
        background: null,
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
    /** 查询个人信息列表 */
    getList() {
      this.loading = true;
      listInfo(this.queryParams).then(response => {
        this.infoList = response.rows;
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
        userId: null,
        nickname: null,
        qq: null,
        wechat: null,
        github: null,
        dingtalk: null,
        openid: null,
        wallet: null,
        lastTime: null,
        status: null,
        gender: null,
        age: null,
        birthday: null,
        constellation: null,
        campus: null,
        major: null,
        job: null,
        city: null,
        interest: null,
        tag: null,
        signature: null,
        addFriendPolicy: null,
        addFriendQuestion: null,
        addFriendAnswer: null,
        storage: null,
        background: null,
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
      this.ids = selection.map(item => item.userId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加个人信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const userId = row.userId || this.ids
      getInfo(userId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改个人信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.userId != null) {
            updateInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInfo(this.form).then(response => {
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
      const userIds = row.userId || this.ids;
      this.$modal.confirm('是否确认删除个人信息编号为"' + userIds + '"的数据项？').then(function() {
        return delInfo(userIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('manage/info/export', {
        ...this.queryParams
      }, `info_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
