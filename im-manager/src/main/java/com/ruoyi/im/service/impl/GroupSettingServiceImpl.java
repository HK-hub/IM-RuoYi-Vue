package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.GroupSettingMapper;
import com.ruoyi.im.domain.GroupSetting;
import com.ruoyi.im.service.IGroupSettingService;

/**
 * 群设置Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class GroupSettingServiceImpl implements IGroupSettingService 
{
    @Autowired
    private GroupSettingMapper groupSettingMapper;

    /**
     * 查询群设置
     * 
     * @param groupId 群设置主键
     * @return 群设置
     */
    @Override
    public GroupSetting selectGroupSettingByGroupId(Long groupId)
    {
        return groupSettingMapper.selectGroupSettingByGroupId(groupId);
    }

    /**
     * 查询群设置列表
     * 
     * @param groupSetting 群设置
     * @return 群设置
     */
    @Override
    public List<GroupSetting> selectGroupSettingList(GroupSetting groupSetting)
    {
        return groupSettingMapper.selectGroupSettingList(groupSetting);
    }

    /**
     * 新增群设置
     * 
     * @param groupSetting 群设置
     * @return 结果
     */
    @Override
    public int insertGroupSetting(GroupSetting groupSetting)
    {
        groupSetting.setCreateTime(DateUtils.getNowDate());
        return groupSettingMapper.insertGroupSetting(groupSetting);
    }

    /**
     * 修改群设置
     * 
     * @param groupSetting 群设置
     * @return 结果
     */
    @Override
    public int updateGroupSetting(GroupSetting groupSetting)
    {
        groupSetting.setUpdateTime(DateUtils.getNowDate());
        return groupSettingMapper.updateGroupSetting(groupSetting);
    }

    /**
     * 批量删除群设置
     * 
     * @param groupIds 需要删除的群设置主键
     * @return 结果
     */
    @Override
    public int deleteGroupSettingByGroupIds(Long[] groupIds)
    {
        return groupSettingMapper.deleteGroupSettingByGroupIds(groupIds);
    }

    /**
     * 删除群设置信息
     * 
     * @param groupId 群设置主键
     * @return 结果
     */
    @Override
    public int deleteGroupSettingByGroupId(Long groupId)
    {
        return groupSettingMapper.deleteGroupSettingByGroupId(groupId);
    }
}
