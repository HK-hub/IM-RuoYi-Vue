package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 群聊申请对象 tb_group_apply
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class GroupApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id编号 */
    private Long id;

    /** 申请发起人 */
    @Excel(name = "申请发起人")
    private Long senderId;

    /** 申请群号 */
    @Excel(name = "申请群号")
    private Long groupId;

    /** 处理人id */
    @Excel(name = "处理人id")
    private Long handlerId;

    /** 申请类型 */
    @Excel(name = "申请类型")
    private Long applyType;

    /** 申请说明信息 */
    @Excel(name = "申请说明信息")
    private String applyInfo;

    /** 状态: */
    @Excel(name = "状态:")
    private Long status;

    /** 处理回执信息 */
    @Excel(name = "处理回执信息")
    private String handleInfo;

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
    public void setGroupId(Long groupId) 
    {
        this.groupId = groupId;
    }

    public Long getGroupId() 
    {
        return groupId;
    }
    public void setHandlerId(Long handlerId) 
    {
        this.handlerId = handlerId;
    }

    public Long getHandlerId() 
    {
        return handlerId;
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
    public void setHandleInfo(String handleInfo) 
    {
        this.handleInfo = handleInfo;
    }

    public String getHandleInfo() 
    {
        return handleInfo;
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
            .append("groupId", getGroupId())
            .append("handlerId", getHandlerId())
            .append("applyType", getApplyType())
            .append("applyInfo", getApplyInfo())
            .append("status", getStatus())
            .append("handleInfo", getHandleInfo())
            .append("sign", getSign())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
