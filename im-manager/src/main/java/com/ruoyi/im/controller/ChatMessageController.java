package com.ruoyi.im.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.im.domain.MessageFlow;
import com.ruoyi.im.service.IMessageFlowService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.im.domain.ChatMessage;
import com.ruoyi.im.service.IChatMessageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消息内容Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/message")
public class ChatMessageController extends BaseController
{
    @Autowired
    private IChatMessageService chatMessageService;

    /**
     * 查询消息内容列表
     */
    @PreAuthorize("@ss.hasPermi('im:message:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChatMessage chatMessage)
    {
        startPage();
        List<ChatMessage> list = chatMessageService.selectChatMessageList(chatMessage);
        return getDataTable(list);
    }

    /**
     * 导出消息内容列表
     */
    @PreAuthorize("@ss.hasPermi('im:message:export')")
    @Log(title = "消息内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatMessage chatMessage)
    {
        List<ChatMessage> list = chatMessageService.selectChatMessageList(chatMessage);
        ExcelUtil<ChatMessage> util = new ExcelUtil<ChatMessage>(ChatMessage.class);
        util.exportExcel(response, list, "消息内容数据");
    }

    /**
     * 获取消息内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:message:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chatMessageService.selectChatMessageById(id));
    }

    /**
     * 新增消息内容
     */
    @PreAuthorize("@ss.hasPermi('im:message:add')")
    @Log(title = "消息内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatMessage chatMessage)
    {
        return toAjax(chatMessageService.insertChatMessage(chatMessage));
    }

    /**
     * 修改消息内容
     */
    @PreAuthorize("@ss.hasPermi('im:message:edit')")
    @Log(title = "消息内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatMessage chatMessage)
    {
        return toAjax(chatMessageService.updateChatMessage(chatMessage));
    }

    /**
     * 删除消息内容
     */
    @PreAuthorize("@ss.hasPermi('im:message:remove')")
    @Log(title = "消息内容", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chatMessageService.deleteChatMessageByIds(ids));
    }

    /**
     * 消息流水Controller
     *
     * @author HK意境
     * @date 2023-05-28
     */
    @RestController
    @RequestMapping("/im/flow")
    public static class MessageFlowController extends BaseController
    {
        @Autowired
        private IMessageFlowService messageFlowService;

        /**
         * 查询消息流水列表
         */
        @PreAuthorize("@ss.hasPermi('im:flow:list')")
        @GetMapping("/list")
        public TableDataInfo list(MessageFlow messageFlow)
        {
            startPage();
            List<MessageFlow> list = messageFlowService.selectMessageFlowList(messageFlow);
            return getDataTable(list);
        }

        /**
         * 导出消息流水列表
         */
        @PreAuthorize("@ss.hasPermi('im:flow:export')")
        @Log(title = "消息流水", businessType = BusinessType.EXPORT)
        @PostMapping("/export")
        public void export(HttpServletResponse response, MessageFlow messageFlow)
        {
            List<MessageFlow> list = messageFlowService.selectMessageFlowList(messageFlow);
            ExcelUtil<MessageFlow> util = new ExcelUtil<MessageFlow>(MessageFlow.class);
            util.exportExcel(response, list, "消息流水数据");
        }

        /**
         * 获取消息流水详细信息
         */
        @PreAuthorize("@ss.hasPermi('im:flow:query')")
        @GetMapping(value = "/{id}")
        public AjaxResult getInfo(@PathVariable("id") Long id)
        {
            return success(messageFlowService.selectMessageFlowById(id));
        }

        /**
         * 新增消息流水
         */
        @PreAuthorize("@ss.hasPermi('im:flow:add')")
        @Log(title = "消息流水", businessType = BusinessType.INSERT)
        @PostMapping
        public AjaxResult add(@RequestBody MessageFlow messageFlow)
        {
            return toAjax(messageFlowService.insertMessageFlow(messageFlow));
        }

        /**
         * 修改消息流水
         */
        @PreAuthorize("@ss.hasPermi('im:flow:edit')")
        @Log(title = "消息流水", businessType = BusinessType.UPDATE)
        @PutMapping
        public AjaxResult edit(@RequestBody MessageFlow messageFlow)
        {
            return toAjax(messageFlowService.updateMessageFlow(messageFlow));
        }

        /**
         * 删除消息流水
         */
        @PreAuthorize("@ss.hasPermi('im:flow:remove')")
        @Log(title = "消息流水", businessType = BusinessType.DELETE)
        @DeleteMapping("/{ids}")
        public AjaxResult remove(@PathVariable Long[] ids)
        {
            return toAjax(messageFlowService.deleteMessageFlowByIds(ids));
        }
    }
}
