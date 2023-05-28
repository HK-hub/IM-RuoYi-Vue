package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 云文件管理对象 tb_cloud_file
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class CloudFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 地址 */
    @Excel(name = "地址")
    private String url;

    /** 客户ID */
    @Excel(name = "客户ID")
    private Long userId;

    /** 文件名字 */
    @Excel(name = "文件名字")
    private String name;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String type;

    /** 是否收藏 */
    @Excel(name = "是否收藏")
    private Long collection;

    /** 文件夹 */
    @Excel(name = "文件夹")
    private String fDir;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String filetype;

    /** 视频 */
    @Excel(name = "视频")
    private String videoId;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Long size;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
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
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setCollection(Long collection) 
    {
        this.collection = collection;
    }

    public Long getCollection() 
    {
        return collection;
    }
    public void setfDir(String fDir) 
    {
        this.fDir = fDir;
    }

    public String getfDir() 
    {
        return fDir;
    }
    public void setFiletype(String filetype) 
    {
        this.filetype = filetype;
    }

    public String getFiletype() 
    {
        return filetype;
    }
    public void setVideoId(String videoId) 
    {
        this.videoId = videoId;
    }

    public String getVideoId() 
    {
        return videoId;
    }
    public void setSize(Long size) 
    {
        this.size = size;
    }

    public Long getSize() 
    {
        return size;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("url", getUrl())
            .append("userId", getUserId())
            .append("name", getName())
            .append("type", getType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("collection", getCollection())
            .append("fDir", getfDir())
            .append("filetype", getFiletype())
            .append("videoId", getVideoId())
            .append("size", getSize())
            .toString();
    }
}
