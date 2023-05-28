package com.ruoyi.im.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.im.service.service.ITbFriendGroupService;
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
import com.ruoyi.im.domain.TbFriendGroup;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 好友分组Controller
 * 
 * @author HK
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/friend_group")
public class TbFriendGroupController extends BaseController
{
    @Autowired
    private ITbFriendGroupService tbFriendGroupService;

    /**
     * 查询好友分组列表
     */
    @PreAuthorize("@ss.hasPermi('im:friend_group:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbFriendGroup tbFriendGroup)
    {
        startPage();
        List<TbFriendGroup> list = tbFriendGroupService.selectTbFriendGroupList(tbFriendGroup);
        return getDataTable(list);
    }

    /**
     * 导出好友分组列表
     */
    @PreAuthorize("@ss.hasPermi('im:friend_group:export')")
    @Log(title = "好友分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbFriendGroup tbFriendGroup)
    {
        List<TbFriendGroup> list = tbFriendGroupService.selectTbFriendGroupList(tbFriendGroup);
        ExcelUtil<TbFriendGroup> util = new ExcelUtil<TbFriendGroup>(TbFriendGroup.class);
        util.exportExcel(response, list, "好友分组数据");
    }

    /**
     * 获取好友分组详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:friend_group:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbFriendGroupService.selectTbFriendGroupById(id));
    }

    /**
     * 新增好友分组
     */
    @PreAuthorize("@ss.hasPermi('im:friend_group:add')")
    @Log(title = "好友分组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbFriendGroup tbFriendGroup)
    {
        return toAjax(tbFriendGroupService.insertTbFriendGroup(tbFriendGroup));
    }

    /**
     * 修改好友分组
     */
    @PreAuthorize("@ss.hasPermi('im:friend_group:edit')")
    @Log(title = "好友分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbFriendGroup tbFriendGroup)
    {
        return toAjax(tbFriendGroupService.updateTbFriendGroup(tbFriendGroup));
    }

    /**
     * 删除好友分组
     */
    @PreAuthorize("@ss.hasPermi('im:friend_group:remove')")
    @Log(title = "好友分组", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbFriendGroupService.deleteTbFriendGroupByIds(ids));
    }
}
