package com.ruoyi.im.service;

import java.util.List;
import com.ruoyi.im.domain.GroupSetting;

/**
 * 群设置Service接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface IGroupSettingService 
{
    /**
     * 查询群设置
     * 
     * @param groupId 群设置主键
     * @return 群设置
     */
    public GroupSetting selectGroupSettingByGroupId(Long groupId);

    /**
     * 查询群设置列表
     * 
     * @param groupSetting 群设置
     * @return 群设置集合
     */
    public List<GroupSetting> selectGroupSettingList(GroupSetting groupSetting);

    /**
     * 新增群设置
     * 
     * @param groupSetting 群设置
     * @return 结果
     */
    public int insertGroupSetting(GroupSetting groupSetting);

    /**
     * 修改群设置
     * 
     * @param groupSetting 群设置
     * @return 结果
     */
    public int updateGroupSetting(GroupSetting groupSetting);

    /**
     * 批量删除群设置
     * 
     * @param groupIds 需要删除的群设置主键集合
     * @return 结果
     */
    public int deleteGroupSettingByGroupIds(Long[] groupIds);

    /**
     * 删除群设置信息
     * 
     * @param groupId 群设置主键
     * @return 结果
     */
    public int deleteGroupSettingByGroupId(Long groupId);
}
