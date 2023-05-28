package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文件消息对象 tb_message_file
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class MessageFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文件ID */
    private String id;

    /** 资源id */
    @Excel(name = "资源id")
    private Long resourceId;

    /** 消息记录ID */
    @Excel(name = "消息记录ID")
    private String messageId;

    /** 上传文件的用户ID */
    @Excel(name = "上传文件的用户ID")
    private String userId;

    /** 文件来源[1:用户上传;2:表情包;] */
    @Excel(name = "文件来源[1:用户上传;2:表情包;]")
    private String source;

    /** 文件类型[1:图片;2:音频文件;3:视频文件;4:其它文件;] */
    @Excel(name = "文件类型[1:图片;2:音频文件;3:视频文件;4:其它文件;]")
    private String type;

    /** 驱动类型[1:local;2:cos;] */
    @Excel(name = "驱动类型[1:local;2:cos;]")
    private String drive;

    /** 原文件名 */
    @Excel(name = "原文件名")
    private String originalName;

    /** 文件后缀 */
    @Excel(name = "文件后缀")
    private String suffix;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private String size;

    /** 文件地址(相对地址) */
    @Excel(name = "文件地址(相对地址)")
    private String path;

    /** 网络地址(公开文件地址) */
    @Excel(name = "网络地址(公开文件地址)")
    private String url;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setResourceId(Long resourceId) 
    {
        this.resourceId = resourceId;
    }

    public Long getResourceId() 
    {
        return resourceId;
    }
    public void setMessageId(String messageId) 
    {
        this.messageId = messageId;
    }

    public String getMessageId() 
    {
        return messageId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setDrive(String drive) 
    {
        this.drive = drive;
    }

    public String getDrive() 
    {
        return drive;
    }
    public void setOriginalName(String originalName) 
    {
        this.originalName = originalName;
    }

    public String getOriginalName() 
    {
        return originalName;
    }
    public void setSuffix(String suffix) 
    {
        this.suffix = suffix;
    }

    public String getSuffix() 
    {
        return suffix;
    }
    public void setSize(String size) 
    {
        this.size = size;
    }

    public String getSize() 
    {
        return size;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("resourceId", getResourceId())
            .append("messageId", getMessageId())
            .append("userId", getUserId())
            .append("source", getSource())
            .append("type", getType())
            .append("drive", getDrive())
            .append("originalName", getOriginalName())
            .append("suffix", getSuffix())
            .append("size", getSize())
            .append("path", getPath())
            .append("url", getUrl())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
