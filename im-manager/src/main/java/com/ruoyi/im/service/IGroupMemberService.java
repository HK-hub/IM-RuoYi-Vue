package com.ruoyi.im.service;

import java.util.List;
import com.ruoyi.im.domain.GroupMember;

/**
 * 群员管理Service接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface IGroupMemberService 
{
    /**
     * 查询群员管理
     * 
     * @param id 群员管理主键
     * @return 群员管理
     */
    public GroupMember selectGroupMemberById(Long id);

    /**
     * 查询群员管理列表
     * 
     * @param groupMember 群员管理
     * @return 群员管理集合
     */
    public List<GroupMember> selectGroupMemberList(GroupMember groupMember);

    /**
     * 新增群员管理
     * 
     * @param groupMember 群员管理
     * @return 结果
     */
    public int insertGroupMember(GroupMember groupMember);

    /**
     * 修改群员管理
     * 
     * @param groupMember 群员管理
     * @return 结果
     */
    public int updateGroupMember(GroupMember groupMember);

    /**
     * 批量删除群员管理
     * 
     * @param ids 需要删除的群员管理主键集合
     * @return 结果
     */
    public int deleteGroupMemberByIds(Long[] ids);

    /**
     * 删除群员管理信息
     * 
     * @param id 群员管理主键
     * @return 结果
     */
    public int deleteGroupMemberById(Long id);
}
