<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="群账号" prop="groupAccount">
        <el-input
          v-model="queryParams.groupAccount"
          placeholder="请输入群账号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群聊名称" prop="groupName">
        <el-input
          v-model="queryParams.groupName"
          placeholder="请输入群聊名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群聊头像" prop="groupAvatar">
        <el-input
          v-model="queryParams.groupAvatar"
          placeholder="请输入群聊头像"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群描述" prop="description">
        <el-input
          v-model="queryParams.description"
          placeholder="请输入群描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群二维码" prop="qrcode">
        <el-input
          v-model="queryParams.qrcode"
          placeholder="请输入群二维码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群人数" prop="memberCount">
        <el-input
          v-model="queryParams.memberCount"
          placeholder="请输入群人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="群主" prop="groupMaster">
        <el-input
          v-model="queryParams.groupMaster"
          placeholder="请输入群主"
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
          v-hasPermi="['im:group:add']"
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
          v-hasPermi="['im:group:edit']"
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
          v-hasPermi="['im:group:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['im:group:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="groupList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="群id" align="center" prop="id" />
      <el-table-column label="群账号" align="center" prop="groupAccount" />
      <el-table-column label="群聊名称" align="center" prop="groupName" />
      <el-table-column label="群聊头像" align="center" prop="groupAvatar" />
      <el-table-column label="群描述" align="center" prop="description" />
      <el-table-column label="群类型:" align="center" prop="groupType" />
      <el-table-column label="群二维码" align="center" prop="qrcode" />
      <el-table-column label="群人数" align="center" prop="memberCount" />
      <el-table-column label="群主" align="center" prop="groupMaster" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['im:group:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['im:group:remove']"
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

    <!-- 添加或修改群聊管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="群账号" prop="groupAccount">
          <el-input v-model="form.groupAccount" placeholder="请输入群账号" />
        </el-form-item>
        <el-form-item label="群聊名称" prop="groupName">
          <el-input v-model="form.groupName" placeholder="请输入群聊名称" />
        </el-form-item>
        <el-form-item label="群聊头像" prop="groupAvatar">
          <el-input v-model="form.groupAvatar" placeholder="请输入群聊头像" />
        </el-form-item>
        <el-form-item label="群描述" prop="description">
          <el-input v-model="form.description" placeholder="请输入群描述" />
        </el-form-item>
        <el-form-item label="群二维码" prop="qrcode">
          <el-input v-model="form.qrcode" placeholder="请输入群二维码" />
        </el-form-item>
        <el-form-item label="群人数" prop="memberCount">
          <el-input v-model="form.memberCount" placeholder="请输入群人数" />
        </el-form-item>
        <el-form-item label="群主" prop="groupMaster">
          <el-input v-model="form.groupMaster" placeholder="请输入群主" />
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
import { listGroup, getGroup, delGroup, addGroup, updateGroup } from "@/api/im/group";

export default {
  name: "Group",
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
      // 群聊管理表格数据
      groupList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        groupAccount: null,
        groupName: null,
        groupAvatar: null,
        description: null,
        groupType: null,
        qrcode: null,
        memberCount: null,
        groupMaster: null,
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
    /** 查询群聊管理列表 */
    getList() {
      this.loading = true;
      listGroup(this.queryParams).then(response => {
        this.groupList = response.rows;
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
        groupAccount: null,
        groupName: null,
        groupAvatar: null,
        description: null,
        groupType: null,
        qrcode: null,
        memberCount: null,
        groupMaster: null,
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
      this.title = "添加群聊管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getGroup(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改群聊管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateGroup(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addGroup(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除群聊管理编号为"' + ids + '"的数据项？').then(function() {
        return delGroup(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('im/group/export', {
        ...this.queryParams
      }, `group_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
