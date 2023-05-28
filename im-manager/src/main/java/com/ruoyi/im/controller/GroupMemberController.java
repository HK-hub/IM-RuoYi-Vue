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
import com.ruoyi.im.domain.GroupMember;
import com.ruoyi.im.service.IGroupMemberService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 群员管理Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/member")
public class GroupMemberController extends BaseController
{
    @Autowired
    private IGroupMemberService groupMemberService;

    /**
     * 查询群员管理列表
     */
    @PreAuthorize("@ss.hasPermi('im:member:list')")
    @GetMapping("/list")
    public TableDataInfo list(GroupMember groupMember)
    {
        startPage();
        List<GroupMember> list = groupMemberService.selectGroupMemberList(groupMember);
        return getDataTable(list);
    }

    /**
     * 导出群员管理列表
     */
    @PreAuthorize("@ss.hasPermi('im:member:export')")
    @Log(title = "群员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GroupMember groupMember)
    {
        List<GroupMember> list = groupMemberService.selectGroupMemberList(groupMember);
        ExcelUtil<GroupMember> util = new ExcelUtil<GroupMember>(GroupMember.class);
        util.exportExcel(response, list, "群员管理数据");
    }

    /**
     * 获取群员管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:member:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(groupMemberService.selectGroupMemberById(id));
    }

    /**
     * 新增群员管理
     */
    @PreAuthorize("@ss.hasPermi('im:member:add')")
    @Log(title = "群员管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GroupMember groupMember)
    {
        return toAjax(groupMemberService.insertGroupMember(groupMember));
    }

    /**
     * 修改群员管理
     */
    @PreAuthorize("@ss.hasPermi('im:member:edit')")
    @Log(title = "群员管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GroupMember groupMember)
    {
        return toAjax(groupMemberService.updateGroupMember(groupMember));
    }

    /**
     * 删除群员管理
     */
    @PreAuthorize("@ss.hasPermi('im:member:remove')")
    @Log(title = "群员管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(groupMemberService.deleteGroupMemberByIds(ids));
    }
}
