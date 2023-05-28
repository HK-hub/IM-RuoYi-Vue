package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 群设置对象 tb_group_setting
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class GroupSetting extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 群id */
    private Long groupId;

    /** 群号 */
    @Excel(name = "群号")
    private Long groupAccount;

    /** 群定位 */
    @Excel(name = "群定位")
    private String position;

    /** 群人数限制 */
    @Excel(name = "群人数限制")
    private Long memberCapacity;

    /** 发现群方式 */
    @Excel(name = "发现群方式")
    private Long findType;

    /** 加群方式：1.允许任 */
    @Excel(name = "加群方式：1.允许任")
    private Long joinType;

    /** 加群问题 */
    @Excel(name = "加群问题")
    private String problem;

    /** 加群问题答案 */
    @Excel(name = "加群问题答案")
    private String answer;

    /** 全员禁言 */
    @Excel(name = "全员禁言")
    private Long forbidSend;

    /** 是否允许群聊临时会话 */
    @Excel(name = "是否允许群聊临时会话")
    private Integer enableTemporary;

    /** 群最新公告 */
    @Excel(name = "群最新公告")
    private String announcement;

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
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setMemberCapacity(Long memberCapacity) 
    {
        this.memberCapacity = memberCapacity;
    }

    public Long getMemberCapacity() 
    {
        return memberCapacity;
    }
    public void setFindType(Long findType) 
    {
        this.findType = findType;
    }

    public Long getFindType() 
    {
        return findType;
    }
    public void setJoinType(Long joinType) 
    {
        this.joinType = joinType;
    }

    public Long getJoinType() 
    {
        return joinType;
    }
    public void setProblem(String problem) 
    {
        this.problem = problem;
    }

    public String getProblem() 
    {
        return problem;
    }
    public void setAnswer(String answer) 
    {
        this.answer = answer;
    }

    public String getAnswer() 
    {
        return answer;
    }
    public void setForbidSend(Long forbidSend) 
    {
        this.forbidSend = forbidSend;
    }

    public Long getForbidSend() 
    {
        return forbidSend;
    }
    public void setEnableTemporary(Integer enableTemporary) 
    {
        this.enableTemporary = enableTemporary;
    }

    public Integer getEnableTemporary() 
    {
        return enableTemporary;
    }
    public void setAnnouncement(String announcement) 
    {
        this.announcement = announcement;
    }

    public String getAnnouncement() 
    {
        return announcement;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("groupId", getGroupId())
            .append("groupAccount", getGroupAccount())
            .append("position", getPosition())
            .append("memberCapacity", getMemberCapacity())
            .append("findType", getFindType())
            .append("joinType", getJoinType())
            .append("problem", getProblem())
            .append("answer", getAnswer())
            .append("forbidSend", getForbidSend())
            .append("enableTemporary", getEnableTemporary())
            .append("announcement", getAnnouncement())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
