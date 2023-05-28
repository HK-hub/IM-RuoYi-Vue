package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.GroupMemberMapper;
import com.ruoyi.im.domain.GroupMember;
import com.ruoyi.im.service.IGroupMemberService;

/**
 * 群员管理Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class GroupMemberServiceImpl implements IGroupMemberService 
{
    @Autowired
    private GroupMemberMapper groupMemberMapper;

    /**
     * 查询群员管理
     * 
     * @param id 群员管理主键
     * @return 群员管理
     */
    @Override
    public GroupMember selectGroupMemberById(Long id)
    {
        return groupMemberMapper.selectGroupMemberById(id);
    }

    /**
     * 查询群员管理列表
     * 
     * @param groupMember 群员管理
     * @return 群员管理
     */
    @Override
    public List<GroupMember> selectGroupMemberList(GroupMember groupMember)
    {
        return groupMemberMapper.selectGroupMemberList(groupMember);
    }

    /**
     * 新增群员管理
     * 
     * @param groupMember 群员管理
     * @return 结果
     */
    @Override
    public int insertGroupMember(GroupMember groupMember)
    {
        groupMember.setCreateTime(DateUtils.getNowDate());
        return groupMemberMapper.insertGroupMember(groupMember);
    }

    /**
     * 修改群员管理
     * 
     * @param groupMember 群员管理
     * @return 结果
     */
    @Override
    public int updateGroupMember(GroupMember groupMember)
    {
        groupMember.setUpdateTime(DateUtils.getNowDate());
        return groupMemberMapper.updateGroupMember(groupMember);
    }

    /**
     * 批量删除群员管理
     * 
     * @param ids 需要删除的群员管理主键
     * @return 结果
     */
    @Override
    public int deleteGroupMemberByIds(Long[] ids)
    {
        return groupMemberMapper.deleteGroupMemberByIds(ids);
    }

    /**
     * 删除群员管理信息
     * 
     * @param id 群员管理主键
     * @return 结果
     */
    @Override
    public int deleteGroupMemberById(Long id)
    {
        return groupMemberMapper.deleteGroupMemberById(id);
    }
}
