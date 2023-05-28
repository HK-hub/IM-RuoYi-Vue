package com.ruoyi.im.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.im.service.service.ITbFriendApplyService;
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
import com.ruoyi.im.domain.TbFriendApply;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 好友申请Controller
 * 
 * @author HK
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/apply")
public class TbFriendApplyController extends BaseController
{
    @Autowired
    private ITbFriendApplyService tbFriendApplyService;

    /**
     * 查询好友申请列表
     */
    @PreAuthorize("@ss.hasPermi('im:apply:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbFriendApply tbFriendApply)
    {
        startPage();
        List<TbFriendApply> list = tbFriendApplyService.selectTbFriendApplyList(tbFriendApply);
        return getDataTable(list);
    }

    /**
     * 导出好友申请列表
     */
    @PreAuthorize("@ss.hasPermi('im:apply:export')")
    @Log(title = "好友申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbFriendApply tbFriendApply)
    {
        List<TbFriendApply> list = tbFriendApplyService.selectTbFriendApplyList(tbFriendApply);
        ExcelUtil<TbFriendApply> util = new ExcelUtil<TbFriendApply>(TbFriendApply.class);
        util.exportExcel(response, list, "好友申请数据");
    }

    /**
     * 获取好友申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:apply:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbFriendApplyService.selectTbFriendApplyById(id));
    }

    /**
     * 新增好友申请
     */
    @PreAuthorize("@ss.hasPermi('im:apply:add')")
    @Log(title = "好友申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbFriendApply tbFriendApply)
    {
        return toAjax(tbFriendApplyService.insertTbFriendApply(tbFriendApply));
    }

    /**
     * 修改好友申请
     */
    @PreAuthorize("@ss.hasPermi('im:apply:edit')")
    @Log(title = "好友申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbFriendApply tbFriendApply)
    {
        return toAjax(tbFriendApplyService.updateTbFriendApply(tbFriendApply));
    }

    /**
     * 删除好友申请
     */
    @PreAuthorize("@ss.hasPermi('im:apply:remove')")
    @Log(title = "好友申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbFriendApplyService.deleteTbFriendApplyByIds(ids));
    }
}
