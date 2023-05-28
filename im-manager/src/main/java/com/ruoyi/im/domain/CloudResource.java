package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 云资源管理对象 tb_cloud_resource
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class CloudResource extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 云盘id */
    private Long id;

    /** 文件资源属主id */
    @Excel(name = "文件资源属主id")
    private Long belongId;

    /** 是否是文件夹路径 */
    @Excel(name = "是否是文件夹路径")
    private Integer directory;

    /** 资源类型 */
    @Excel(name = "资源类型")
    private Long resourceType;

    /** 资源名称 */
    @Excel(name = "资源名称")
    private String name;

    /** 资源描述 */
    @Excel(name = "资源描述")
    private String description;

    /** 资源扩展名(文件扩展名) */
    @Excel(name = "资源扩展名(文件扩展名)")
    private String extendType;

    /** 文件url链接 */
    @Excel(name = "文件url链接")
    private String url;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Long size;

    /** 文件hash值 */
    @Excel(name = "文件hash值")
    private String hash;

    /** 资源文件md5 */
    @Excel(name = "资源文件md5")
    private String md5;

    /** 文件资源计数器 */
    @Excel(name = "文件资源计数器")
    private Long count;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer deleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBelongId(Long belongId) 
    {
        this.belongId = belongId;
    }

    public Long getBelongId() 
    {
        return belongId;
    }
    public void setDirectory(Integer directory) 
    {
        this.directory = directory;
    }

    public Integer getDirectory() 
    {
        return directory;
    }
    public void setResourceType(Long resourceType) 
    {
        this.resourceType = resourceType;
    }

    public Long getResourceType() 
    {
        return resourceType;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setExtendType(String extendType) 
    {
        this.extendType = extendType;
    }

    public String getExtendType() 
    {
        return extendType;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setSize(Long size) 
    {
        this.size = size;
    }

    public Long getSize() 
    {
        return size;
    }
    public void setHash(String hash) 
    {
        this.hash = hash;
    }

    public String getHash() 
    {
        return hash;
    }
    public void setMd5(String md5) 
    {
        this.md5 = md5;
    }

    public String getMd5() 
    {
        return md5;
    }
    public void setCount(Long count) 
    {
        this.count = count;
    }

    public Long getCount() 
    {
        return count;
    }
    public void setDeleted(Integer deleted) 
    {
        this.deleted = deleted;
    }

    public Integer getDeleted() 
    {
        return deleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("belongId", getBelongId())
            .append("directory", getDirectory())
            .append("resourceType", getResourceType())
            .append("name", getName())
            .append("description", getDescription())
            .append("extendType", getExtendType())
            .append("url", getUrl())
            .append("size", getSize())
            .append("hash", getHash())
            .append("md5", getMd5())
            .append("count", getCount())
            .append("deleted", getDeleted())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
