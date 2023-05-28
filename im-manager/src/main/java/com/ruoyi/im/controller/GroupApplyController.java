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
import com.ruoyi.im.domain.GroupApply;
import com.ruoyi.im.service.IGroupApplyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 群聊申请Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/group/apply")
public class GroupApplyController extends BaseController
{
    @Autowired
    private IGroupApplyService groupApplyService;

    /**
     * 查询群聊申请列表
     */
    @PreAuthorize("@ss.hasPermi('im:apply:list')")
    @GetMapping("/list")
    public TableDataInfo list(GroupApply groupApply)
    {
        startPage();
        List<GroupApply> list = groupApplyService.selectGroupApplyList(groupApply);
        return getDataTable(list);
    }

    /**
     * 导出群聊申请列表
     */
    @PreAuthorize("@ss.hasPermi('im:apply:export')")
    @Log(title = "群聊申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GroupApply groupApply)
    {
        List<GroupApply> list = groupApplyService.selectGroupApplyList(groupApply);
        ExcelUtil<GroupApply> util = new ExcelUtil<GroupApply>(GroupApply.class);
        util.exportExcel(response, list, "群聊申请数据");
    }

    /**
     * 获取群聊申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:apply:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(groupApplyService.selectGroupApplyById(id));
    }

    /**
     * 新增群聊申请
     */
    @PreAuthorize("@ss.hasPermi('im:apply:add')")
    @Log(title = "群聊申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GroupApply groupApply)
    {
        return toAjax(groupApplyService.insertGroupApply(groupApply));
    }

    /**
     * 修改群聊申请
     */
    @PreAuthorize("@ss.hasPermi('im:apply:edit')")
    @Log(title = "群聊申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GroupApply groupApply)
    {
        return toAjax(groupApplyService.updateGroupApply(groupApply));
    }

    /**
     * 删除群聊申请
     */
    @PreAuthorize("@ss.hasPermi('im:apply:remove')")
    @Log(title = "群聊申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(groupApplyService.deleteGroupApplyByIds(ids));
    }
}
