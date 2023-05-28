package com.ruoyi.im.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文件分片数据对象 tb_split_upload
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public class SplitUpload extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 临时文件ID */
    private String id;

    /** 文件属性 */
    @Excel(name = "文件属性")
    private String type;

    /** 驱动类型 */
    @Excel(name = "驱动类型")
    private String drive;

    /** 临时文件hash名，md5 */
    @Excel(name = "临时文件hash名，md5")
    private String uploadId;

    /** 上传的用户ID */
    @Excel(name = "上传的用户ID")
    private String userId;

    /** 原文件名 */
    @Excel(name = "原文件名")
    private String originalName;

    /** 当前索引块 */
    @Excel(name = "当前索引块")
    private String splitIndex;

    /** 总上传索引块 */
    @Excel(name = "总上传索引块")
    private String splitNum;

    /** 临时保存路径 */
    @Excel(name = "临时保存路径")
    private String path;

    /** 文件后缀名 */
    @Excel(name = "文件后缀名")
    private String fileExt;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private String fileSize;

    /** 文件是否删除 */
    @Excel(name = "文件是否删除")
    private String isDelete;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
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
    public void setUploadId(String uploadId) 
    {
        this.uploadId = uploadId;
    }

    public String getUploadId() 
    {
        return uploadId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setOriginalName(String originalName) 
    {
        this.originalName = originalName;
    }

    public String getOriginalName() 
    {
        return originalName;
    }
    public void setSplitIndex(String splitIndex) 
    {
        this.splitIndex = splitIndex;
    }

    public String getSplitIndex() 
    {
        return splitIndex;
    }
    public void setSplitNum(String splitNum) 
    {
        this.splitNum = splitNum;
    }

    public String getSplitNum() 
    {
        return splitNum;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }
    public void setFileExt(String fileExt) 
    {
        this.fileExt = fileExt;
    }

    public String getFileExt() 
    {
        return fileExt;
    }
    public void setFileSize(String fileSize) 
    {
        this.fileSize = fileSize;
    }

    public String getFileSize() 
    {
        return fileSize;
    }
    public void setIsDelete(String isDelete) 
    {
        this.isDelete = isDelete;
    }

    public String getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("drive", getDrive())
            .append("uploadId", getUploadId())
            .append("userId", getUserId())
            .append("originalName", getOriginalName())
            .append("splitIndex", getSplitIndex())
            .append("splitNum", getSplitNum())
            .append("path", getPath())
            .append("fileExt", getFileExt())
            .append("fileSize", getFileSize())
            .append("isDelete", getIsDelete())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
