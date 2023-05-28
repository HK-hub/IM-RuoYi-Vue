package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消息流水对象 tb_message_flow
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class MessageFlow extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 流水id */
    private Long id;

    /** 群id */
    @Excel(name = "群id")
    private Long groupId;

    /** 发送者id */
    @Excel(name = "发送者id")
    private Long senderId;

    /** 接收者id(用户id或群id) */
    @Excel(name = "接收者id(用户id或群id)")
    private Long receiverId;

    /** 会话类型 */
    @Excel(name = "会话类型")
    private Long chatType;

    /** 消息类型 */
    @Excel(name = "消息类型")
    private Long messageType;

    /** 消息id */
    @Excel(name = "消息id")
    private Long messageId;

    /** 序列号 */
    @Excel(name = "序列号")
    private Long sequence;

    /** 发送状态 */
    @Excel(name = "发送状态")
    private Long sendStatus;

    /** 签收状态 */
    @Excel(name = "签收状态")
    private Long signFlag;

    /** 是否撤回 */
    @Excel(name = "是否撤回")
    private Integer revoke;

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
    public void setGroupId(Long groupId) 
    {
        this.groupId = groupId;
    }

    public Long getGroupId() 
    {
        return groupId;
    }
    public void setSenderId(Long senderId) 
    {
        this.senderId = senderId;
    }

    public Long getSenderId() 
    {
        return senderId;
    }
    public void setReceiverId(Long receiverId) 
    {
        this.receiverId = receiverId;
    }

    public Long getReceiverId() 
    {
        return receiverId;
    }
    public void setChatType(Long chatType) 
    {
        this.chatType = chatType;
    }

    public Long getChatType() 
    {
        return chatType;
    }
    public void setMessageType(Long messageType) 
    {
        this.messageType = messageType;
    }

    public Long getMessageType() 
    {
        return messageType;
    }
    public void setMessageId(Long messageId) 
    {
        this.messageId = messageId;
    }

    public Long getMessageId() 
    {
        return messageId;
    }
    public void setSequence(Long sequence) 
    {
        this.sequence = sequence;
    }

    public Long getSequence() 
    {
        return sequence;
    }
    public void setSendStatus(Long sendStatus) 
    {
        this.sendStatus = sendStatus;
    }

    public Long getSendStatus() 
    {
        return sendStatus;
    }
    public void setSignFlag(Long signFlag) 
    {
        this.signFlag = signFlag;
    }

    public Long getSignFlag() 
    {
        return signFlag;
    }
    public void setRevoke(Integer revoke) 
    {
        this.revoke = revoke;
    }

    public Integer getRevoke() 
    {
        return revoke;
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
            .append("senderId", getSenderId())
            .append("receiverId", getReceiverId())
            .append("chatType", getChatType())
            .append("messageType", getMessageType())
            .append("messageId", getMessageId())
            .append("sequence", getSequence())
            .append("sendStatus", getSendStatus())
            .append("signFlag", getSignFlag())
            .append("revoke", getRevoke())
            .append("deleted", getDeleted())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
