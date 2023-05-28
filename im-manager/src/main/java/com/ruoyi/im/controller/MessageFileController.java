package com.ruoyi.im.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.im.domain.MessageFile;
import com.ruoyi.im.service.IMessageFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文件消息Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/message_file")
public class MessageFileController extends BaseController
{
    @Autowired
    private IMessageFileService messageFileService;

    /**
     * 查询文件消息列表
     */
    @PreAuthorize("@ss.hasPermi('im:message_file:list')")
    @GetMapping("/list")
    public TableDataInfo list(MessageFile messageFile)
    {
        startPage();
        List<MessageFile> list = messageFileService.selectMessageFileList(messageFile);
        return getDataTable(list);
    }

    /**
     * 导出文件消息列表
     */
    @PreAuthorize("@ss.hasPermi('im:message_file:export')")
    @Log(title = "文件消息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MessageFile messageFile)
    {
        List<MessageFile> list = messageFileService.selectMessageFileList(messageFile);
        ExcelUtil<MessageFile> util = new ExcelUtil<MessageFile>(MessageFile.class);
        util.exportExcel(response, list, "文件消息数据");
    }

    /**
     * 获取文件消息详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:message_file:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(messageFileService.selectMessageFileById(id));
    }

    /**
     * 新增文件消息
     */
    @PreAuthorize("@ss.hasPermi('im:message_file:add')")
    @Log(title = "文件消息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MessageFile messageFile)
    {
        return toAjax(messageFileService.insertMessageFile(messageFile));
    }

    /**
     * 修改文件消息
     */
    @PreAuthorize("@ss.hasPermi('im:message_file:edit')")
    @Log(title = "文件消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MessageFile messageFile)
    {
        return toAjax(messageFileService.updateMessageFile(messageFile));
    }

    /**
     * 删除文件消息
     */
    @PreAuthorize("@ss.hasPermi('im:message_file:remove')")
    @Log(title = "文件消息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(messageFileService.deleteMessageFileByIds(ids));
    }
}
