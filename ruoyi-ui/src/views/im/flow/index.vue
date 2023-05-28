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
      <el-form-item label="发送者id" prop="senderId">
        <el-input
          v-model="queryParams.senderId"
          placeholder="请输入发送者id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="接收者id(用户id或群id)" prop="receiverId">
        <el-input
          v-model="queryParams.receiverId"
          placeholder="请输入接收者id(用户id或群id)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="消息id" prop="messageId">
        <el-input
          v-model="queryParams.messageId"
          placeholder="请输入消息id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="序列号" prop="sequence">
        <el-input
          v-model="queryParams.sequence"
          placeholder="请输入序列号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="签收状态" prop="signFlag">
        <el-input
          v-model="queryParams.signFlag"
          placeholder="请输入签收状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否撤回" prop="revoke">
        <el-input
          v-model="queryParams.revoke"
          placeholder="请输入是否撤回"
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
          v-hasPermi="['im:flow:add']"
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
          v-hasPermi="['im:flow:edit']"
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
          v-hasPermi="['im:flow:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['im:flow:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="flowList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="流水id" align="center" prop="id" />
      <el-table-column label="群id" align="center" prop="groupId" />
      <el-table-column label="发送者id" align="center" prop="senderId" />
      <el-table-column label="接收者id(用户id或群id)" align="center" prop="receiverId" />
      <el-table-column label="会话类型" align="center" prop="chatType" />
      <el-table-column label="消息类型" align="center" prop="messageType" />
      <el-table-column label="消息id" align="center" prop="messageId" />
      <el-table-column label="序列号" align="center" prop="sequence" />
      <el-table-column label="发送状态" align="center" prop="sendStatus" />
      <el-table-column label="签收状态" align="center" prop="signFlag" />
      <el-table-column label="是否撤回" align="center" prop="revoke" />
      <el-table-column label="是否删除" align="center" prop="deleted" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['im:flow:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['im:flow:remove']"
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

    <!-- 添加或修改消息流水对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="群id" prop="groupId">
          <el-input v-model="form.groupId" placeholder="请输入群id" />
        </el-form-item>
        <el-form-item label="发送者id" prop="senderId">
          <el-input v-model="form.senderId" placeholder="请输入发送者id" />
        </el-form-item>
        <el-form-item label="接收者id(用户id或群id)" prop="receiverId">
          <el-input v-model="form.receiverId" placeholder="请输入接收者id(用户id或群id)" />
        </el-form-item>
        <el-form-item label="消息id" prop="messageId">
          <el-input v-model="form.messageId" placeholder="请输入消息id" />
        </el-form-item>
        <el-form-item label="序列号" prop="sequence">
          <el-input v-model="form.sequence" placeholder="请输入序列号" />
        </el-form-item>
        <el-form-item label="签收状态" prop="signFlag">
          <el-input v-model="form.signFlag" placeholder="请输入签收状态" />
        </el-form-item>
        <el-form-item label="是否撤回" prop="revoke">
          <el-input v-model="form.revoke" placeholder="请输入是否撤回" />
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
import { listFlow, getFlow, delFlow, addFlow, updateFlow } from "@/api/im/flow";

export default {
  name: "Flow",
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
      // 消息流水表格数据
      flowList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        groupId: null,
        senderId: null,
        receiverId: null,
        chatType: null,
        messageType: null,
        messageId: null,
        sequence: null,
        sendStatus: null,
        signFlag: null,
        revoke: null,
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
    /** 查询消息流水列表 */
    getList() {
      this.loading = true;
      listFlow(this.queryParams).then(response => {
        this.flowList = response.rows;
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
        senderId: null,
        receiverId: null,
        chatType: null,
        messageType: null,
        messageId: null,
        sequence: null,
        sendStatus: null,
        signFlag: null,
        revoke: null,
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
      this.title = "添加消息流水";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getFlow(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改消息流水";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateFlow(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFlow(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除消息流水编号为"' + ids + '"的数据项？').then(function() {
        return delFlow(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('im/flow/export', {
        ...this.queryParams
      }, `flow_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
