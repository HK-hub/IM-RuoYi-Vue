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
import com.ruoyi.im.domain.Group;
import com.ruoyi.im.service.IGroupService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 群聊管理Controller
 * 
 * @author HK
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/group")
public class GroupController extends BaseController
{
    @Autowired
    private IGroupService groupService;

    /**
     * 查询群聊管理列表
     */
    @PreAuthorize("@ss.hasPermi('im:group:list')")
    @GetMapping("/list")
    public TableDataInfo list(Group group)
    {
        startPage();
        List<Group> list = groupService.selectGroupList(group);
        return getDataTable(list);
    }

    /**
     * 导出群聊管理列表
     */
    @PreAuthorize("@ss.hasPermi('im:group:export')")
    @Log(title = "群聊管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Group group)
    {
        List<Group> list = groupService.selectGroupList(group);
        ExcelUtil<Group> util = new ExcelUtil<Group>(Group.class);
        util.exportExcel(response, list, "群聊管理数据");
    }

    /**
     * 获取群聊管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:group:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(groupService.selectGroupById(id));
    }

    /**
     * 新增群聊管理
     */
    @PreAuthorize("@ss.hasPermi('im:group:add')")
    @Log(title = "群聊管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Group group)
    {
        return toAjax(groupService.insertGroup(group));
    }

    /**
     * 修改群聊管理
     */
    @PreAuthorize("@ss.hasPermi('im:group:edit')")
    @Log(title = "群聊管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Group group)
    {
        return toAjax(groupService.updateGroup(group));
    }

    /**
     * 删除群聊管理
     */
    @PreAuthorize("@ss.hasPermi('im:group:remove')")
    @Log(title = "群聊管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(groupService.deleteGroupByIds(ids));
    }
}
