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
import com.ruoyi.im.domain.GroupAnnouncement;
import com.ruoyi.im.service.IGroupAnnouncementService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 群公告Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/announcement")
public class GroupAnnouncementController extends BaseController
{
    @Autowired
    private IGroupAnnouncementService groupAnnouncementService;

    /**
     * 查询群公告列表
     */
    @PreAuthorize("@ss.hasPermi('im:announcement:list')")
    @GetMapping("/list")
    public TableDataInfo list(GroupAnnouncement groupAnnouncement)
    {
        startPage();
        List<GroupAnnouncement> list = groupAnnouncementService.selectGroupAnnouncementList(groupAnnouncement);
        return getDataTable(list);
    }

    /**
     * 导出群公告列表
     */
    @PreAuthorize("@ss.hasPermi('im:announcement:export')")
    @Log(title = "群公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GroupAnnouncement groupAnnouncement)
    {
        List<GroupAnnouncement> list = groupAnnouncementService.selectGroupAnnouncementList(groupAnnouncement);
        ExcelUtil<GroupAnnouncement> util = new ExcelUtil<GroupAnnouncement>(GroupAnnouncement.class);
        util.exportExcel(response, list, "群公告数据");
    }

    /**
     * 获取群公告详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:announcement:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(groupAnnouncementService.selectGroupAnnouncementById(id));
    }

    /**
     * 新增群公告
     */
    @PreAuthorize("@ss.hasPermi('im:announcement:add')")
    @Log(title = "群公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GroupAnnouncement groupAnnouncement)
    {
        return toAjax(groupAnnouncementService.insertGroupAnnouncement(groupAnnouncement));
    }

    /**
     * 修改群公告
     */
    @PreAuthorize("@ss.hasPermi('im:announcement:edit')")
    @Log(title = "群公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GroupAnnouncement groupAnnouncement)
    {
        return toAjax(groupAnnouncementService.updateGroupAnnouncement(groupAnnouncement));
    }

    /**
     * 删除群公告
     */
    @PreAuthorize("@ss.hasPermi('im:announcement:remove')")
    @Log(title = "群公告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(groupAnnouncementService.deleteGroupAnnouncementByIds(ids));
    }
}
