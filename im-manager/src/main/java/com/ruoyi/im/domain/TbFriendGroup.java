package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 好友分组对象 tb_friend_group
 * 
 * @author HK
 * @date 2023-05-28
 */
public class TbFriendGroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分组id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 分组名称 */
    @Excel(name = "分组名称")
    private String name;

    /** 分组好友数量 */
    @Excel(name = "分组好友数量")
    private Long count;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCount(Long count) 
    {
        this.count = count;
    }

    public Long getCount() 
    {
        return count;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("name", getName())
            .append("count", getCount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
