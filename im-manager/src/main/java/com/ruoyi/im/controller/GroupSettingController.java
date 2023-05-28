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
import com.ruoyi.im.domain.GroupSetting;
import com.ruoyi.im.service.IGroupSettingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 群设置Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/group/setting")
public class GroupSettingController extends BaseController
{
    @Autowired
    private IGroupSettingService groupSettingService;

    /**
     * 查询群设置列表
     */
    @PreAuthorize("@ss.hasPermi('im:setting:list')")
    @GetMapping("/list")
    public TableDataInfo list(GroupSetting groupSetting)
    {
        startPage();
        List<GroupSetting> list = groupSettingService.selectGroupSettingList(groupSetting);
        return getDataTable(list);
    }

    /**
     * 导出群设置列表
     */
    @PreAuthorize("@ss.hasPermi('im:setting:export')")
    @Log(title = "群设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GroupSetting groupSetting)
    {
        List<GroupSetting> list = groupSettingService.selectGroupSettingList(groupSetting);
        ExcelUtil<GroupSetting> util = new ExcelUtil<GroupSetting>(GroupSetting.class);
        util.exportExcel(response, list, "群设置数据");
    }

    /**
     * 获取群设置详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:setting:query')")
    @GetMapping(value = "/{groupId}")
    public AjaxResult getInfo(@PathVariable("groupId") Long groupId)
    {
        return success(groupSettingService.selectGroupSettingByGroupId(groupId));
    }

    /**
     * 新增群设置
     */
    @PreAuthorize("@ss.hasPermi('im:setting:add')")
    @Log(title = "群设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GroupSetting groupSetting)
    {
        return toAjax(groupSettingService.insertGroupSetting(groupSetting));
    }

    /**
     * 修改群设置
     */
    @PreAuthorize("@ss.hasPermi('im:setting:edit')")
    @Log(title = "群设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GroupSetting groupSetting)
    {
        return toAjax(groupSettingService.updateGroupSetting(groupSetting));
    }

    /**
     * 删除群设置
     */
    @PreAuthorize("@ss.hasPermi('im:setting:remove')")
    @Log(title = "群设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{groupIds}")
    public AjaxResult remove(@PathVariable Long[] groupIds)
    {
        return toAjax(groupSettingService.deleteGroupSettingByGroupIds(groupIds));
    }
}
