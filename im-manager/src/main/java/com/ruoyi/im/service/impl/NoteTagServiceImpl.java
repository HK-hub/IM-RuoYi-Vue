package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.NoteTagMapper;
import com.ruoyi.im.domain.NoteTag;
import com.ruoyi.im.service.INoteTagService;

/**
 * 笔记标签Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class NoteTagServiceImpl implements INoteTagService 
{
    @Autowired
    private NoteTagMapper noteTagMapper;

    /**
     * 查询笔记标签
     * 
     * @param id 笔记标签主键
     * @return 笔记标签
     */
    @Override
    public NoteTag selectNoteTagById(Long id)
    {
        return noteTagMapper.selectNoteTagById(id);
    }

    /**
     * 查询笔记标签列表
     * 
     * @param noteTag 笔记标签
     * @return 笔记标签
     */
    @Override
    public List<NoteTag> selectNoteTagList(NoteTag noteTag)
    {
        return noteTagMapper.selectNoteTagList(noteTag);
    }

    /**
     * 新增笔记标签
     * 
     * @param noteTag 笔记标签
     * @return 结果
     */
    @Override
    public int insertNoteTag(NoteTag noteTag)
    {
        noteTag.setCreateTime(DateUtils.getNowDate());
        return noteTagMapper.insertNoteTag(noteTag);
    }

    /**
     * 修改笔记标签
     * 
     * @param noteTag 笔记标签
     * @return 结果
     */
    @Override
    public int updateNoteTag(NoteTag noteTag)
    {
        noteTag.setUpdateTime(DateUtils.getNowDate());
        return noteTagMapper.updateNoteTag(noteTag);
    }

    /**
     * 批量删除笔记标签
     * 
     * @param ids 需要删除的笔记标签主键
     * @return 结果
     */
    @Override
    public int deleteNoteTagByIds(Long[] ids)
    {
        return noteTagMapper.deleteNoteTagByIds(ids);
    }

    /**
     * 删除笔记标签信息
     * 
     * @param id 笔记标签主键
     * @return 结果
     */
    @Override
    public int deleteNoteTagById(Long id)
    {
        return noteTagMapper.deleteNoteTagById(id);
    }
}
