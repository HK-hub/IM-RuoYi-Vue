package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 笔记附件对象 tb_note_annex
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class NoteAnnex extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 附件id */
    private Long id;

    /** 笔记id */
    @Excel(name = "笔记id")
    private Long noteId;

    /** 文件后缀 */
    @Excel(name = "文件后缀")
    private String suffix;

    /** 附件大小：字节 */
    @Excel(name = "附件大小：字节")
    private Long size;

    /** 附件名称 */
    @Excel(name = "附件名称")
    private String originalName;

    /** 附件url地址 */
    @Excel(name = "附件url地址")
    private String url;

    /** 是否删除：用于回收站处理 */
    @Excel(name = "是否删除：用于回收站处理")
    private Integer deleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setNoteId(Long noteId) 
    {
        this.noteId = noteId;
    }

    public Long getNoteId() 
    {
        return noteId;
    }
    public void setSuffix(String suffix) 
    {
        this.suffix = suffix;
    }

    public String getSuffix() 
    {
        return suffix;
    }
    public void setSize(Long size) 
    {
        this.size = size;
    }

    public Long getSize() 
    {
        return size;
    }
    public void setOriginalName(String originalName) 
    {
        this.originalName = originalName;
    }

    public String getOriginalName() 
    {
        return originalName;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setDeleted(Integer deleted) 
    {
        this.deleted = deleted;
    }

    public Integer getDeleted() 
    {
        return deleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("noteId", getNoteId())
            .append("suffix", getSuffix())
            .append("size", getSize())
            .append("originalName", getOriginalName())
            .append("url", getUrl())
            .append("deleted", getDeleted())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
