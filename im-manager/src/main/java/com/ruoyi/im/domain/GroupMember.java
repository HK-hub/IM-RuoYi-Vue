package com.ruoyi.im.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 群员管理对象 tb_group_member
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class GroupMember extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 群id */
    @Excel(name = "群id")
    private Long groupId;

    /** 群号 */
    @Excel(name = "群号")
    private Long groupAccount;

    /** 群成员id */
    @Excel(name = "群成员id")
    private Long memberId;

    /** 群外昵称 */
    @Excel(name = "群外昵称")
    private String memberUsername;

    /** 群内昵称 */
    @Excel(name = "群内昵称")
    private String memberRemarkName;

    /** 头像 */
    @Excel(name = "头像")
    private String memberAvatar;

    /** 群员角色 */
    @Excel(name = "群员角色")
    private Long memberRole;

    /** 群分组 */
    @Excel(name = "群分组")
    private String groupCategory;

    /** 禁言时间：表示禁止发言的结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "禁言时间：表示禁止发言的结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gagTime;

    /** 最后确认的消息id */
    @Excel(name = "最后确认的消息id")
    private Long lastAckMessage;

    /** 群状态 */
    @Excel(name = "群状态")
    private Long status;

    /** 禁言 */
    @Excel(name = "禁言")
    private Integer muted;

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
    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }
    public void setMemberUsername(String memberUsername) 
    {
        this.memberUsername = memberUsername;
    }

    public String getMemberUsername() 
    {
        return memberUsername;
    }
    public void setMemberRemarkName(String memberRemarkName) 
    {
        this.memberRemarkName = memberRemarkName;
    }

    public String getMemberRemarkName() 
    {
        return memberRemarkName;
    }
    public void setMemberAvatar(String memberAvatar) 
    {
        this.memberAvatar = memberAvatar;
    }

    public String getMemberAvatar() 
    {
        return memberAvatar;
    }
    public void setMemberRole(Long memberRole) 
    {
        this.memberRole = memberRole;
    }

    public Long getMemberRole() 
    {
        return memberRole;
    }
    public void setGroupCategory(String groupCategory) 
    {
        this.groupCategory = groupCategory;
    }

    public String getGroupCategory() 
    {
        return groupCategory;
    }
    public void setGagTime(Date gagTime) 
    {
        this.gagTime = gagTime;
    }

    public Date getGagTime() 
    {
        return gagTime;
    }
    public void setLastAckMessage(Long lastAckMessage) 
    {
        this.lastAckMessage = lastAckMessage;
    }

    public Long getLastAckMessage() 
    {
        return lastAckMessage;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setMuted(Integer muted) 
    {
        this.muted = muted;
    }

    public Integer getMuted() 
    {
        return muted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("groupId", getGroupId())
            .append("groupAccount", getGroupAccount())
            .append("memberId", getMemberId())
            .append("memberUsername", getMemberUsername())
            .append("memberRemarkName", getMemberRemarkName())
            .append("memberAvatar", getMemberAvatar())
            .append("memberRole", getMemberRole())
            .append("groupCategory", getGroupCategory())
            .append("gagTime", getGagTime())
            .append("lastAckMessage", getLastAckMessage())
            .append("status", getStatus())
            .append("muted", getMuted())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
