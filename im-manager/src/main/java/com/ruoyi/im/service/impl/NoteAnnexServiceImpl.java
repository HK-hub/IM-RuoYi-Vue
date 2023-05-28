package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.NoteAnnexMapper;
import com.ruoyi.im.domain.NoteAnnex;
import com.ruoyi.im.service.INoteAnnexService;

/**
 * 笔记附件Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class NoteAnnexServiceImpl implements INoteAnnexService 
{
    @Autowired
    private NoteAnnexMapper noteAnnexMapper;

    /**
     * 查询笔记附件
     * 
     * @param id 笔记附件主键
     * @return 笔记附件
     */
    @Override
    public NoteAnnex selectNoteAnnexById(Long id)
    {
        return noteAnnexMapper.selectNoteAnnexById(id);
    }

    /**
     * 查询笔记附件列表
     * 
     * @param noteAnnex 笔记附件
     * @return 笔记附件
     */
    @Override
    public List<NoteAnnex> selectNoteAnnexList(NoteAnnex noteAnnex)
    {
        return noteAnnexMapper.selectNoteAnnexList(noteAnnex);
    }

    /**
     * 新增笔记附件
     * 
     * @param noteAnnex 笔记附件
     * @return 结果
     */
    @Override
    public int insertNoteAnnex(NoteAnnex noteAnnex)
    {
        noteAnnex.setCreateTime(DateUtils.getNowDate());
        return noteAnnexMapper.insertNoteAnnex(noteAnnex);
    }

    /**
     * 修改笔记附件
     * 
     * @param noteAnnex 笔记附件
     * @return 结果
     */
    @Override
    public int updateNoteAnnex(NoteAnnex noteAnnex)
    {
        noteAnnex.setUpdateTime(DateUtils.getNowDate());
        return noteAnnexMapper.updateNoteAnnex(noteAnnex);
    }

    /**
     * 批量删除笔记附件
     * 
     * @param ids 需要删除的笔记附件主键
     * @return 结果
     */
    @Override
    public int deleteNoteAnnexByIds(Long[] ids)
    {
        return noteAnnexMapper.deleteNoteAnnexByIds(ids);
    }

    /**
     * 删除笔记附件信息
     * 
     * @param id 笔记附件主键
     * @return 结果
     */
    @Override
    public int deleteNoteAnnexById(Long id)
    {
        return noteAnnexMapper.deleteNoteAnnexById(id);
    }
}
