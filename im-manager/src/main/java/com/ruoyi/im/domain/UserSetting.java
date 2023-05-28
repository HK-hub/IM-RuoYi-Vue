package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户个性化设置对象 tb_user_setting
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class UserSetting extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 名片背景 */
    @Excel(name = "名片背景")
    private String cardBackground;

    /** 聊天背景 */
    @Excel(name = "聊天背景")
    private String talkBackground;

    /** 主题模式 */
    @Excel(name = "主题模式")
    private Long theme;

    /** 新消息提示 */
    @Excel(name = "新消息提示")
    private Integer newMessageRemind;

    /** 系统消息通知 */
    @Excel(name = "系统消息通知")
    private Integer messageNotify;

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
    public void setCardBackground(String cardBackground) 
    {
        this.cardBackground = cardBackground;
    }

    public String getCardBackground() 
    {
        return cardBackground;
    }
    public void setTalkBackground(String talkBackground) 
    {
        this.talkBackground = talkBackground;
    }

    public String getTalkBackground() 
    {
        return talkBackground;
    }
    public void setTheme(Long theme) 
    {
        this.theme = theme;
    }

    public Long getTheme() 
    {
        return theme;
    }
    public void setNewMessageRemind(Integer newMessageRemind) 
    {
        this.newMessageRemind = newMessageRemind;
    }

    public Integer getNewMessageRemind() 
    {
        return newMessageRemind;
    }
    public void setMessageNotify(Integer messageNotify) 
    {
        this.messageNotify = messageNotify;
    }

    public Integer getMessageNotify() 
    {
        return messageNotify;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("cardBackground", getCardBackground())
            .append("talkBackground", getTalkBackground())
            .append("theme", getTheme())
            .append("newMessageRemind", getNewMessageRemind())
            .append("messageNotify", getMessageNotify())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
