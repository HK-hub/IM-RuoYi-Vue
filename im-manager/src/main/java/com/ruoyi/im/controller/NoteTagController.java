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
import com.ruoyi.im.domain.NoteTag;
import com.ruoyi.im.service.INoteTagService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 笔记标签Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/note_tag")
public class NoteTagController extends BaseController
{
    @Autowired
    private INoteTagService noteTagService;

    /**
     * 查询笔记标签列表
     */
    @PreAuthorize("@ss.hasPermi('im:note_tag:list')")
    @GetMapping("/list")
    public TableDataInfo list(NoteTag noteTag)
    {
        startPage();
        List<NoteTag> list = noteTagService.selectNoteTagList(noteTag);
        return getDataTable(list);
    }

    /**
     * 导出笔记标签列表
     */
    @PreAuthorize("@ss.hasPermi('im:note_tag:export')")
    @Log(title = "笔记标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NoteTag noteTag)
    {
        List<NoteTag> list = noteTagService.selectNoteTagList(noteTag);
        ExcelUtil<NoteTag> util = new ExcelUtil<NoteTag>(NoteTag.class);
        util.exportExcel(response, list, "笔记标签数据");
    }

    /**
     * 获取笔记标签详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:note_tag:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(noteTagService.selectNoteTagById(id));
    }

    /**
     * 新增笔记标签
     */
    @PreAuthorize("@ss.hasPermi('im:note_tag:add')")
    @Log(title = "笔记标签", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NoteTag noteTag)
    {
        return toAjax(noteTagService.insertNoteTag(noteTag));
    }

    /**
     * 修改笔记标签
     */
    @PreAuthorize("@ss.hasPermi('im:note_tag:edit')")
    @Log(title = "笔记标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NoteTag noteTag)
    {
        return toAjax(noteTagService.updateNoteTag(noteTag));
    }

    /**
     * 删除笔记标签
     */
    @PreAuthorize("@ss.hasPermi('im:note_tag:remove')")
    @Log(title = "笔记标签", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(noteTagService.deleteNoteTagByIds(ids));
    }
}
