package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 tb_user
 * 
 * @author HK意境
 * @date 2023-05-26
 */
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Long id;

    /** 用户名，昵称 */
    @Excel(name = "用户名，昵称")
    private String username;

    /** 账号，类比QQ号,唯一性 */
    @Excel(name = "账号，类比QQ号,唯一性")
    private String account;

    /** 加密后的密码,盐值为原密码 */
    @Excel(name = "加密后的密码,盐值为原密码")
    private String password;

    /** 大陆手机号,唯一性，一个手机只能绑定一个账号 */
    @Excel(name = "大陆手机号,唯一性，一个手机只能绑定一个账号")
    private String phone;

    /** 邮箱,唯一性,一个邮箱只能绑定一个账号 */
    @Excel(name = "邮箱,唯一性,一个邮箱只能绑定一个账号")
    private String email;

    /** 用户大头像 */
    @Excel(name = "用户大头像")
    private String bigAvatar;

    /** 用户头像缩略图 */
    @Excel(name = "用户头像缩略图")
    private String miniAvatar;

    /** 用户二维码 */
    @Excel(name = "用户二维码")
    private String qrcode;

    /** 会话唯一标识 */
    @Excel(name = "会话唯一标识")
    private String cid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setAccount(String account) 
    {
        this.account = account;
    }

    public String getAccount() 
    {
        return account;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setBigAvatar(String bigAvatar) 
    {
        this.bigAvatar = bigAvatar;
    }

    public String getBigAvatar() 
    {
        return bigAvatar;
    }
    public void setMiniAvatar(String miniAvatar) 
    {
        this.miniAvatar = miniAvatar;
    }

    public String getMiniAvatar() 
    {
        return miniAvatar;
    }
    public void setQrcode(String qrcode) 
    {
        this.qrcode = qrcode;
    }

    public String getQrcode() 
    {
        return qrcode;
    }
    public void setCid(String cid) 
    {
        this.cid = cid;
    }

    public String getCid() 
    {
        return cid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("account", getAccount())
            .append("password", getPassword())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("bigAvatar", getBigAvatar())
            .append("miniAvatar", getMiniAvatar())
            .append("qrcode", getQrcode())
            .append("cid", getCid())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
