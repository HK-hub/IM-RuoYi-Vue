package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 好友管理对象 tb_friend
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class Friend extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 好友id */
    @Excel(name = "好友id")
    private Long friendId;

    /** 状态 */
    @Excel(name = "状态")
    private Long relation;

    /** 分组 */
    @Excel(name = "分组")
    private String group;

    /** 分组id */
    @Excel(name = "分组id")
    private Long groupId;

    /** 好友昵称 */
    @Excel(name = "好友昵称")
    private String nickname;

    /** 备注姓名 */
    @Excel(name = "备注姓名")
    private String remarkName;

    /** 备注信息 */
    @Excel(name = "备注信息")
    private String remarkInfo;

    /** 机器人 */
    @Excel(name = "机器人")
    private Integer robot;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** 消息免打扰 */
    @Excel(name = "消息免打扰")
    private Integer disturb;

    /** 置顶 */
    @Excel(name = "置顶")
    private Integer top;

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
    public void setFriendId(Long friendId) 
    {
        this.friendId = friendId;
    }

    public Long getFriendId() 
    {
        return friendId;
    }
    public void setRelation(Long relation) 
    {
        this.relation = relation;
    }

    public Long getRelation() 
    {
        return relation;
    }
    public void setGroup(String group) 
    {
        this.group = group;
    }

    public String getGroup() 
    {
        return group;
    }
    public void setGroupId(Long groupId) 
    {
        this.groupId = groupId;
    }

    public Long getGroupId() 
    {
        return groupId;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setRemarkName(String remarkName) 
    {
        this.remarkName = remarkName;
    }

    public String getRemarkName() 
    {
        return remarkName;
    }
    public void setRemarkInfo(String remarkInfo) 
    {
        this.remarkInfo = remarkInfo;
    }

    public String getRemarkInfo() 
    {
        return remarkInfo;
    }
    public void setRobot(Integer robot) 
    {
        this.robot = robot;
    }

    public Integer getRobot() 
    {
        return robot;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setDisturb(Integer disturb) 
    {
        this.disturb = disturb;
    }

    public Integer getDisturb() 
    {
        return disturb;
    }
    public void setTop(Integer top) 
    {
        this.top = top;
    }

    public Integer getTop() 
    {
        return top;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("friendId", getFriendId())
            .append("relation", getRelation())
            .append("group", getGroup())
            .append("groupId", getGroupId())
            .append("nickname", getNickname())
            .append("remarkName", getRemarkName())
            .append("remarkInfo", getRemarkInfo())
            .append("robot", getRobot())
            .append("avatar", getAvatar())
            .append("disturb", getDisturb())
            .append("top", getTop())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
