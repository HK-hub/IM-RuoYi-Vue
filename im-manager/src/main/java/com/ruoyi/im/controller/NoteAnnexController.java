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
import com.ruoyi.im.domain.NoteAnnex;
import com.ruoyi.im.service.INoteAnnexService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 笔记附件Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/annex")
public class NoteAnnexController extends BaseController
{
    @Autowired
    private INoteAnnexService noteAnnexService;

    /**
     * 查询笔记附件列表
     */
    @PreAuthorize("@ss.hasPermi('im:annex:list')")
    @GetMapping("/list")
    public TableDataInfo list(NoteAnnex noteAnnex)
    {
        startPage();
        List<NoteAnnex> list = noteAnnexService.selectNoteAnnexList(noteAnnex);
        return getDataTable(list);
    }

    /**
     * 导出笔记附件列表
     */
    @PreAuthorize("@ss.hasPermi('im:annex:export')")
    @Log(title = "笔记附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NoteAnnex noteAnnex)
    {
        List<NoteAnnex> list = noteAnnexService.selectNoteAnnexList(noteAnnex);
        ExcelUtil<NoteAnnex> util = new ExcelUtil<NoteAnnex>(NoteAnnex.class);
        util.exportExcel(response, list, "笔记附件数据");
    }

    /**
     * 获取笔记附件详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:annex:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(noteAnnexService.selectNoteAnnexById(id));
    }

    /**
     * 新增笔记附件
     */
    @PreAuthorize("@ss.hasPermi('im:annex:add')")
    @Log(title = "笔记附件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NoteAnnex noteAnnex)
    {
        return toAjax(noteAnnexService.insertNoteAnnex(noteAnnex));
    }

    /**
     * 修改笔记附件
     */
    @PreAuthorize("@ss.hasPermi('im:annex:edit')")
    @Log(title = "笔记附件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NoteAnnex noteAnnex)
    {
        return toAjax(noteAnnexService.updateNoteAnnex(noteAnnex));
    }

    /**
     * 删除笔记附件
     */
    @PreAuthorize("@ss.hasPermi('im:annex:remove')")
    @Log(title = "笔记附件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(noteAnnexService.deleteNoteAnnexByIds(ids));
    }
}
