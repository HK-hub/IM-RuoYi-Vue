package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 笔记标签对象 tb_note_tag
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class NoteTag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标签id */
    @Excel(name = "标签id")
    private Long tagId;

    /** 笔记id */
    @Excel(name = "笔记id")
    private Long noteId;

    /** $column.columnComment */
    private Long id;

    public void setTagId(Long tagId) 
    {
        this.tagId = tagId;
    }

    public Long getTagId() 
    {
        return tagId;
    }
    public void setNoteId(Long noteId) 
    {
        this.noteId = noteId;
    }

    public Long getNoteId() 
    {
        return noteId;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tagId", getTagId())
            .append("noteId", getNoteId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("id", getId())
            .toString();
    }
}
