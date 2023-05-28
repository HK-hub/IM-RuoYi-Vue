package com.ruoyi.im.service;

import java.util.List;
import com.ruoyi.im.domain.CloudResource;

/**
 * 云资源管理Service接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface ICloudResourceService 
{
    /**
     * 查询云资源管理
     * 
     * @param id 云资源管理主键
     * @return 云资源管理
     */
    public CloudResource selectCloudResourceById(Long id);

    /**
     * 查询云资源管理列表
     * 
     * @param cloudResource 云资源管理
     * @return 云资源管理集合
     */
    public List<CloudResource> selectCloudResourceList(CloudResource cloudResource);

    /**
     * 新增云资源管理
     * 
     * @param cloudResource 云资源管理
     * @return 结果
     */
    public int insertCloudResource(CloudResource cloudResource);

    /**
     * 修改云资源管理
     * 
     * @param cloudResource 云资源管理
     * @return 结果
     */
    public int updateCloudResource(CloudResource cloudResource);

    /**
     * 批量删除云资源管理
     * 
     * @param ids 需要删除的云资源管理主键集合
     * @return 结果
     */
    public int deleteCloudResourceByIds(Long[] ids);

    /**
     * 删除云资源管理信息
     * 
     * @param id 云资源管理主键
     * @return 结果
     */
    public int deleteCloudResourceById(Long id);
}
