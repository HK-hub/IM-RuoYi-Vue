package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 笔记管理对象 tb_note
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class Note extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 笔记id */
    private Long id;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String title;

    /** 摘要 */
    @Excel(name = "摘要")
    private String summary;

    /** markdown 格式笔记内容 */
    @Excel(name = "markdown 格式笔记内容")
    private String mdContent;

    /** HTML 格式的笔记内容 */
    @Excel(name = "HTML 格式的笔记内容")
    private String content;

    /** 封面 */
    @Excel(name = "封面")
    private String cover;

    /** 作者id */
    @Excel(name = "作者id")
    private Long authorId;

    /** 笔记分类id */
    @Excel(name = "笔记分类id")
    private Long categoryId;

    /** 笔记状态 */
    @Excel(name = "笔记状态")
    private Long status;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer deleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setSummary(String summary) 
    {
        this.summary = summary;
    }

    public String getSummary() 
    {
        return summary;
    }
    public void setMdContent(String mdContent) 
    {
        this.mdContent = mdContent;
    }

    public String getMdContent() 
    {
        return mdContent;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setCover(String cover) 
    {
        this.cover = cover;
    }

    public String getCover() 
    {
        return cover;
    }
    public void setAuthorId(Long authorId) 
    {
        this.authorId = authorId;
    }

    public Long getAuthorId() 
    {
        return authorId;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
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
            .append("title", getTitle())
            .append("summary", getSummary())
            .append("mdContent", getMdContent())
            .append("content", getContent())
            .append("cover", getCover())
            .append("authorId", getAuthorId())
            .append("categoryId", getCategoryId())
            .append("status", getStatus())
            .append("deleted", getDeleted())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
