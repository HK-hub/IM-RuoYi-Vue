package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.CloudResourceMapper;
import com.ruoyi.im.domain.CloudResource;
import com.ruoyi.im.service.ICloudResourceService;

/**
 * 云资源管理Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class CloudResourceServiceImpl implements ICloudResourceService 
{
    @Autowired
    private CloudResourceMapper cloudResourceMapper;

    /**
     * 查询云资源管理
     * 
     * @param id 云资源管理主键
     * @return 云资源管理
     */
    @Override
    public CloudResource selectCloudResourceById(Long id)
    {
        return cloudResourceMapper.selectCloudResourceById(id);
    }

    /**
     * 查询云资源管理列表
     * 
     * @param cloudResource 云资源管理
     * @return 云资源管理
     */
    @Override
    public List<CloudResource> selectCloudResourceList(CloudResource cloudResource)
    {
        return cloudResourceMapper.selectCloudResourceList(cloudResource);
    }

    /**
     * 新增云资源管理
     * 
     * @param cloudResource 云资源管理
     * @return 结果
     */
    @Override
    public int insertCloudResource(CloudResource cloudResource)
    {
        cloudResource.setCreateTime(DateUtils.getNowDate());
        return cloudResourceMapper.insertCloudResource(cloudResource);
    }

    /**
     * 修改云资源管理
     * 
     * @param cloudResource 云资源管理
     * @return 结果
     */
    @Override
    public int updateCloudResource(CloudResource cloudResource)
    {
        cloudResource.setUpdateTime(DateUtils.getNowDate());
        return cloudResourceMapper.updateCloudResource(cloudResource);
    }

    /**
     * 批量删除云资源管理
     * 
     * @param ids 需要删除的云资源管理主键
     * @return 结果
     */
    @Override
    public int deleteCloudResourceByIds(Long[] ids)
    {
        return cloudResourceMapper.deleteCloudResourceByIds(ids);
    }

    /**
     * 删除云资源管理信息
     * 
     * @param id 云资源管理主键
     * @return 结果
     */
    @Override
    public int deleteCloudResourceById(Long id)
    {
        return cloudResourceMapper.deleteCloudResourceById(id);
    }
}
