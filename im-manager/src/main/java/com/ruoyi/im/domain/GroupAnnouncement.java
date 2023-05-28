package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 群公告对象 tb_group_announcement
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class GroupAnnouncement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公告id */
    private Long id;

    /** 群id */
    @Excel(name = "群id")
    private Long groupId;

    /** 群号 */
    @Excel(name = "群号")
    private Long groupAccount;

    /** 群公告类型 */
    @Excel(name = "群公告类型")
    private Long type;

    /** 撰写者 */
    @Excel(name = "撰写者")
    private Long author;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 置顶 */
    @Excel(name = "置顶")
    private Integer top;

    /** 删除 */
    @Excel(name = "删除")
    private Integer deleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGroupId(Long groupId) 
    {
        this.groupId = groupId;
    }

    public Long getGroupId() 
    {
        return groupId;
    }
    public void setGroupAccount(Long groupAccount) 
    {
        this.groupAccount = groupAccount;
    }

    public Long getGroupAccount() 
    {
        return groupAccount;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setAuthor(Long author) 
    {
        this.author = author;
    }

    public Long getAuthor() 
    {
        return author;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setTop(Integer top) 
    {
        this.top = top;
    }

    public Integer getTop() 
    {
        return top;
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
            .append("groupId", getGroupId())
            .append("groupAccount", getGroupAccount())
            .append("type", getType())
            .append("author", getAuthor())
            .append("title", getTitle())
            .append("content", getContent())
            .append("top", getTop())
            .append("deleted", getDeleted())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
