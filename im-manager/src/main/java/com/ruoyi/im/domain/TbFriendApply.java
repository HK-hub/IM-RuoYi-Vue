package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 好友申请对象 tb_friend_apply
 * 
 * @author HK
 * @date 2023-05-28
 */
public class TbFriendApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id编号 */
    private Long id;

    /** 申请发起人 */
    @Excel(name = "申请发起人")
    private Long senderId;

    /** 申请接收人,如果是加群则为群号 */
    @Excel(name = "申请接收人,如果是加群则为群号")
    private Long acceptorId;

    /** 申请类型：1.好友申请，2.加群申请 */
    @Excel(name = "申请类型：1.好友申请，2.加群申请")
    private Long applyType;

    /** 好友申请说明信息,验证信息 */
    @Excel(name = "好友申请说明信息,验证信息")
    private String applyInfo;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 签收状态 */
    @Excel(name = "签收状态")
    private Long sign;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSenderId(Long senderId) 
    {
        this.senderId = senderId;
    }

    public Long getSenderId() 
    {
        return senderId;
    }
    public void setAcceptorId(Long acceptorId) 
    {
        this.acceptorId = acceptorId;
    }

    public Long getAcceptorId() 
    {
        return acceptorId;
    }
    public void setApplyType(Long applyType) 
    {
        this.applyType = applyType;
    }

    public Long getApplyType() 
    {
        return applyType;
    }
    public void setApplyInfo(String applyInfo) 
    {
        this.applyInfo = applyInfo;
    }

    public String getApplyInfo() 
    {
        return applyInfo;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setSign(Long sign) 
    {
        this.sign = sign;
    }

    public Long getSign() 
    {
        return sign;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("senderId", getSenderId())
            .append("acceptorId", getAcceptorId())
            .append("applyType", getApplyType())
            .append("applyInfo", getApplyInfo())
            .append("status", getStatus())
            .append("sign", getSign())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
