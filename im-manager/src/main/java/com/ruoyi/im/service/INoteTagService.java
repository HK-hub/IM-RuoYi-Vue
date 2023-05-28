package com.ruoyi.im.service;

import java.util.List;
import com.ruoyi.im.domain.NoteTag;

/**
 * 笔记标签Service接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface INoteTagService 
{
    /**
     * 查询笔记标签
     * 
     * @param id 笔记标签主键
     * @return 笔记标签
     */
    public NoteTag selectNoteTagById(Long id);

    /**
     * 查询笔记标签列表
     * 
     * @param noteTag 笔记标签
     * @return 笔记标签集合
     */
    public List<NoteTag> selectNoteTagList(NoteTag noteTag);

    /**
     * 新增笔记标签
     * 
     * @param noteTag 笔记标签
     * @return 结果
     */
    public int insertNoteTag(NoteTag noteTag);

    /**
     * 修改笔记标签
     * 
     * @param noteTag 笔记标签
     * @return 结果
     */
    public int updateNoteTag(NoteTag noteTag);

    /**
     * 批量删除笔记标签
     * 
     * @param ids 需要删除的笔记标签主键集合
     * @return 结果
     */
    public int deleteNoteTagByIds(Long[] ids);

    /**
     * 删除笔记标签信息
     * 
     * @param id 笔记标签主键
     * @return 结果
     */
    public int deleteNoteTagById(Long id);
}
