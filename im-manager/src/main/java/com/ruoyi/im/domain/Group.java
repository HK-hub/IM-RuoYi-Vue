package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 群聊管理对象 tb_group
 * 
 * @author HK
 * @date 2023-05-28
 */
public class Group extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 群id */
    private Long id;

    /** 群账号 */
    @Excel(name = "群账号")
    private Long groupAccount;

    /** 群聊名称 */
    @Excel(name = "群聊名称")
    private String groupName;

    /** 群聊头像 */
    @Excel(name = "群聊头像")
    private String groupAvatar;

    /** 群描述 */
    @Excel(name = "群描述")
    private String description;

    /** 群类型: */
    @Excel(name = "群类型:")
    private Long groupType;

    /** 群二维码 */
    @Excel(name = "群二维码")
    private String qrcode;

    /** 群人数 */
    @Excel(name = "群人数")
    private Long memberCount;

    /** 群主 */
    @Excel(name = "群主")
    private Long groupMaster;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGroupAccount(Long groupAccount) 
    {
        this.groupAccount = groupAccount;
    }

    public Long getGroupAccount() 
    {
        return groupAccount;
    }
    public void setGroupName(String groupName) 
    {
        this.groupName = groupName;
    }

    public String getGroupName() 
    {
        return groupName;
    }
    public void setGroupAvatar(String groupAvatar) 
    {
        this.groupAvatar = groupAvatar;
    }

    public String getGroupAvatar() 
    {
        return groupAvatar;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setGroupType(Long groupType) 
    {
        this.groupType = groupType;
    }

    public Long getGroupType() 
    {
        return groupType;
    }
    public void setQrcode(String qrcode) 
    {
        this.qrcode = qrcode;
    }

    public String getQrcode() 
    {
        return qrcode;
    }
    public void setMemberCount(Long memberCount) 
    {
        this.memberCount = memberCount;
    }

    public Long getMemberCount() 
    {
        return memberCount;
    }
    public void setGroupMaster(Long groupMaster) 
    {
        this.groupMaster = groupMaster;
    }

    public Long getGroupMaster() 
    {
        return groupMaster;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("groupAccount", getGroupAccount())
            .append("groupName", getGroupName())
            .append("groupAvatar", getGroupAvatar())
            .append("description", getDescription())
            .append("groupType", getGroupType())
            .append("qrcode", getQrcode())
            .append("memberCount", getMemberCount())
            .append("groupMaster", getGroupMaster())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
