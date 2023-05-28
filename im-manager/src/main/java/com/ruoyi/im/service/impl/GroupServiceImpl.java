package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.GroupMapper;
import com.ruoyi.im.domain.Group;
import com.ruoyi.im.service.IGroupService;

/**
 * 群聊管理Service业务层处理
 * 
 * @author HK
 * @date 2023-05-28
 */
@Service
public class GroupServiceImpl implements IGroupService 
{
    @Autowired
    private GroupMapper groupMapper;

    /**
     * 查询群聊管理
     * 
     * @param id 群聊管理主键
     * @return 群聊管理
     */
    @Override
    public Group selectGroupById(Long id)
    {
        return groupMapper.selectGroupById(id);
    }

    /**
     * 查询群聊管理列表
     * 
     * @param group 群聊管理
     * @return 群聊管理
     */
    @Override
    public List<Group> selectGroupList(Group group)
    {
        return groupMapper.selectGroupList(group);
    }

    /**
     * 新增群聊管理
     * 
     * @param group 群聊管理
     * @return 结果
     */
    @Override
    public int insertGroup(Group group)
    {
        group.setCreateTime(DateUtils.getNowDate());
        return groupMapper.insertGroup(group);
    }

    /**
     * 修改群聊管理
     * 
     * @param group 群聊管理
     * @return 结果
     */
    @Override
    public int updateGroup(Group group)
    {
        group.setUpdateTime(DateUtils.getNowDate());
        return groupMapper.updateGroup(group);
    }

    /**
     * 批量删除群聊管理
     * 
     * @param ids 需要删除的群聊管理主键
     * @return 结果
     */
    @Override
    public int deleteGroupByIds(Long[] ids)
    {
        return groupMapper.deleteGroupByIds(ids);
    }

    /**
     * 删除群聊管理信息
     * 
     * @param id 群聊管理主键
     * @return 结果
     */
    @Override
    public int deleteGroupById(Long id)
    {
        return groupMapper.deleteGroupById(id);
    }
}
