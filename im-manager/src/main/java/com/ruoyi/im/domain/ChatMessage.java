package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消息内容对象 tb_chat_message
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class ChatMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 消息id */
    private Long id;

    /** 消息序列号 */
    @Excel(name = "消息序列号")
    private Long sequence;

    /** 消息属性 */
    @Excel(name = "消息属性")
    private Long messageFeature;

    /** 消息类型 */
    @Excel(name = "消息类型")
    private Long messageType;

    /** 消息内容 */
    @Excel(name = "消息内容")
    private String content;

    /** url链接 */
    @Excel(name = "url链接")
    private String url;

    /** 扩展 */
    @Excel(name = "扩展")
    private String extra;

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
    public void setSequence(Long sequence) 
    {
        this.sequence = sequence;
    }

    public Long getSequence() 
    {
        return sequence;
    }
    public void setMessageFeature(Long messageFeature) 
    {
        this.messageFeature = messageFeature;
    }

    public Long getMessageFeature() 
    {
        return messageFeature;
    }
    public void setMessageType(Long messageType) 
    {
        this.messageType = messageType;
    }

    public Long getMessageType() 
    {
        return messageType;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setExtra(String extra) 
    {
        this.extra = extra;
    }

    public String getExtra() 
    {
        return extra;
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
            .append("sequence", getSequence())
            .append("messageFeature", getMessageFeature())
            .append("messageType", getMessageType())
            .append("content", getContent())
            .append("url", getUrl())
            .append("extra", getExtra())
            .append("deleted", getDeleted())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
