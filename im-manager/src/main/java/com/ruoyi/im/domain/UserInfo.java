package com.ruoyi.im.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 个人信息对象 tb_user_info
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class UserInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Long userId;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** QQ号 */
    @Excel(name = "QQ号")
    private String qq;

    /** 微信号 */
    @Excel(name = "微信号")
    private String wechat;

    /** github 账号 */
    @Excel(name = "github 账号")
    private String github;

    /** 钉钉账号 */
    @Excel(name = "钉钉账号")
    private String dingtalk;

    /** openid */
    @Excel(name = "openid")
    private String openid;

    /** 用户钱包剩余余额 */
    @Excel(name = "用户钱包剩余余额")
    private Long wallet;

    /** 最后交互间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后交互间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastTime;

    /** 用户状态 */
    @Excel(name = "用户状态")
    private Long status;

    /** 性别 */
    @Excel(name = "性别")
    private Integer gender;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 星座 */
    @Excel(name = "星座")
    private String constellation;

    /** 学校 */
    @Excel(name = "学校")
    private String campus;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 职业 */
    @Excel(name = "职业")
    private String job;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 兴趣爱好 */
    @Excel(name = "兴趣爱好")
    private String interest;

    /** 个人标签 */
    @Excel(name = "个人标签")
    private String tag;

    /** 个性签名 */
    @Excel(name = "个性签名")
    private String signature;

    /** 加好友策 */
    @Excel(name = "加好友策")
    private Long addFriendPolicy;

    /** 加好友问题 */
    @Excel(name = "加好友问题")
    private String addFriendQuestion;

    /** 加好友答案 */
    @Excel(name = "加好友答案")
    private String addFriendAnswer;

    /** 存储空间 */
    @Excel(name = "存储空间")
    private Long storage;

    /** 名片背景 */
    @Excel(name = "名片背景")
    private String background;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setQq(String qq) 
    {
        this.qq = qq;
    }

    public String getQq() 
    {
        return qq;
    }
    public void setWechat(String wechat) 
    {
        this.wechat = wechat;
    }

    public String getWechat() 
    {
        return wechat;
    }
    public void setGithub(String github) 
    {
        this.github = github;
    }

    public String getGithub() 
    {
        return github;
    }
    public void setDingtalk(String dingtalk) 
    {
        this.dingtalk = dingtalk;
    }

    public String getDingtalk() 
    {
        return dingtalk;
    }
    public void setOpenid(String openid) 
    {
        this.openid = openid;
    }

    public String getOpenid() 
    {
        return openid;
    }
    public void setWallet(Long wallet) 
    {
        this.wallet = wallet;
    }

    public Long getWallet() 
    {
        return wallet;
    }
    public void setLastTime(Date lastTime) 
    {
        this.lastTime = lastTime;
    }

    public Date getLastTime() 
    {
        return lastTime;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setGender(Integer gender) 
    {
        this.gender = gender;
    }

    public Integer getGender() 
    {
        return gender;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setConstellation(String constellation) 
    {
        this.constellation = constellation;
    }

    public String getConstellation() 
    {
        return constellation;
    }
    public void setCampus(String campus) 
    {
        this.campus = campus;
    }

    public String getCampus() 
    {
        return campus;
    }
    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }
    public void setJob(String job) 
    {
        this.job = job;
    }

    public String getJob() 
    {
        return job;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setInterest(String interest) 
    {
        this.interest = interest;
    }

    public String getInterest() 
    {
        return interest;
    }
    public void setTag(String tag) 
    {
        this.tag = tag;
    }

    public String getTag() 
    {
        return tag;
    }
    public void setSignature(String signature) 
    {
        this.signature = signature;
    }

    public String getSignature() 
    {
        return signature;
    }
    public void setAddFriendPolicy(Long addFriendPolicy) 
    {
        this.addFriendPolicy = addFriendPolicy;
    }

    public Long getAddFriendPolicy() 
    {
        return addFriendPolicy;
    }
    public void setAddFriendQuestion(String addFriendQuestion) 
    {
        this.addFriendQuestion = addFriendQuestion;
    }

    public String getAddFriendQuestion() 
    {
        return addFriendQuestion;
    }
    public void setAddFriendAnswer(String addFriendAnswer) 
    {
        this.addFriendAnswer = addFriendAnswer;
    }

    public String getAddFriendAnswer() 
    {
        return addFriendAnswer;
    }
    public void setStorage(Long storage) 
    {
        this.storage = storage;
    }

    public Long getStorage() 
    {
        return storage;
    }
    public void setBackground(String background) 
    {
        this.background = background;
    }

    public String getBackground() 
    {
        return background;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("nickname", getNickname())
            .append("qq", getQq())
            .append("wechat", getWechat())
            .append("github", getGithub())
            .append("dingtalk", getDingtalk())
            .append("openid", getOpenid())
            .append("wallet", getWallet())
            .append("lastTime", getLastTime())
            .append("status", getStatus())
            .append("gender", getGender())
            .append("age", getAge())
            .append("birthday", getBirthday())
            .append("constellation", getConstellation())
            .append("campus", getCampus())
            .append("major", getMajor())
            .append("job", getJob())
            .append("city", getCity())
            .append("interest", getInterest())
            .append("tag", getTag())
            .append("signature", getSignature())
            .append("addFriendPolicy", getAddFriendPolicy())
            .append("addFriendQuestion", getAddFriendQuestion())
            .append("addFriendAnswer", getAddFriendAnswer())
            .append("storage", getStorage())
            .append("background", getBackground())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
