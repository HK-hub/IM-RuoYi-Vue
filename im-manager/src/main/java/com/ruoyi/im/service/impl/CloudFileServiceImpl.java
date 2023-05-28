package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.CloudFileMapper;
import com.ruoyi.im.domain.CloudFile;
import com.ruoyi.im.service.ICloudFileService;

/**
 * 云文件管理Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class CloudFileServiceImpl implements ICloudFileService 
{
    @Autowired
    private CloudFileMapper cloudFileMapper;

    /**
     * 查询云文件管理
     * 
     * @param id 云文件管理主键
     * @return 云文件管理
     */
    @Override
    public CloudFile selectCloudFileById(Long id)
    {
        return cloudFileMapper.selectCloudFileById(id);
    }

    /**
     * 查询云文件管理列表
     * 
     * @param cloudFile 云文件管理
     * @return 云文件管理
     */
    @Override
    public List<CloudFile> selectCloudFileList(CloudFile cloudFile)
    {
        return cloudFileMapper.selectCloudFileList(cloudFile);
    }

    /**
     * 新增云文件管理
     * 
     * @param cloudFile 云文件管理
     * @return 结果
     */
    @Override
    public int insertCloudFile(CloudFile cloudFile)
    {
        cloudFile.setCreateTime(DateUtils.getNowDate());
        return cloudFileMapper.insertCloudFile(cloudFile);
    }

    /**
     * 修改云文件管理
     * 
     * @param cloudFile 云文件管理
     * @return 结果
     */
    @Override
    public int updateCloudFile(CloudFile cloudFile)
    {
        cloudFile.setUpdateTime(DateUtils.getNowDate());
        return cloudFileMapper.updateCloudFile(cloudFile);
    }

    /**
     * 批量删除云文件管理
     * 
     * @param ids 需要删除的云文件管理主键
     * @return 结果
     */
    @Override
    public int deleteCloudFileByIds(Long[] ids)
    {
        return cloudFileMapper.deleteCloudFileByIds(ids);
    }

    /**
     * 删除云文件管理信息
     * 
     * @param id 云文件管理主键
     * @return 结果
     */
    @Override
    public int deleteCloudFileById(Long id)
    {
        return cloudFileMapper.deleteCloudFileById(id);
    }
}
