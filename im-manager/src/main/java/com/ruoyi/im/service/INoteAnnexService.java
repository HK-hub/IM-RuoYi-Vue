package com.ruoyi.im.service;

import java.util.List;
import com.ruoyi.im.domain.NoteAnnex;

/**
 * 笔记附件Service接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface INoteAnnexService 
{
    /**
     * 查询笔记附件
     * 
     * @param id 笔记附件主键
     * @return 笔记附件
     */
    public NoteAnnex selectNoteAnnexById(Long id);

    /**
     * 查询笔记附件列表
     * 
     * @param noteAnnex 笔记附件
     * @return 笔记附件集合
     */
    public List<NoteAnnex> selectNoteAnnexList(NoteAnnex noteAnnex);

    /**
     * 新增笔记附件
     * 
     * @param noteAnnex 笔记附件
     * @return 结果
     */
    public int insertNoteAnnex(NoteAnnex noteAnnex);

    /**
     * 修改笔记附件
     * 
     * @param noteAnnex 笔记附件
     * @return 结果
     */
    public int updateNoteAnnex(NoteAnnex noteAnnex);

    /**
     * 批量删除笔记附件
     * 
     * @param ids 需要删除的笔记附件主键集合
     * @return 结果
     */
    public int deleteNoteAnnexByIds(Long[] ids);

    /**
     * 删除笔记附件信息
     * 
     * @param id 笔记附件主键
     * @return 结果
     */
    public int deleteNoteAnnexById(Long id);
}
