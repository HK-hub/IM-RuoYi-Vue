package com.ruoyi.im.service;

import java.util.List;
import com.ruoyi.im.domain.CloudFile;

/**
 * 云文件管理Service接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface ICloudFileService 
{
    /**
     * 查询云文件管理
     * 
     * @param id 云文件管理主键
     * @return 云文件管理
     */
    public CloudFile selectCloudFileById(Long id);

    /**
     * 查询云文件管理列表
     * 
     * @param cloudFile 云文件管理
     * @return 云文件管理集合
     */
    public List<CloudFile> selectCloudFileList(CloudFile cloudFile);

    /**
     * 新增云文件管理
     * 
     * @param cloudFile 云文件管理
     * @return 结果
     */
    public int insertCloudFile(CloudFile cloudFile);

    /**
     * 修改云文件管理
     * 
     * @param cloudFile 云文件管理
     * @return 结果
     */
    public int updateCloudFile(CloudFile cloudFile);

    /**
     * 批量删除云文件管理
     * 
     * @param ids 需要删除的云文件管理主键集合
     * @return 结果
     */
    public int deleteCloudFileByIds(Long[] ids);

    /**
     * 删除云文件管理信息
     * 
     * @param id 云文件管理主键
     * @return 结果
     */
    public int deleteCloudFileById(Long id);
}
