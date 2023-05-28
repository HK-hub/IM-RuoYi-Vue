package com.ruoyi.im.service;

import java.util.List;
import com.ruoyi.im.domain.Group;

/**
 * 群聊管理Service接口
 * 
 * @author HK
 * @date 2023-05-28
 */
public interface IGroupService 
{
    /**
     * 查询群聊管理
     * 
     * @param id 群聊管理主键
     * @return 群聊管理
     */
    public Group selectGroupById(Long id);

    /**
     * 查询群聊管理列表
     * 
     * @param group 群聊管理
     * @return 群聊管理集合
     */
    public List<Group> selectGroupList(Group group);

    /**
     * 新增群聊管理
     * 
     * @param group 群聊管理
     * @return 结果
     */
    public int insertGroup(Group group);

    /**
     * 修改群聊管理
     * 
     * @param group 群聊管理
     * @return 结果
     */
    public int updateGroup(Group group);

    /**
     * 批量删除群聊管理
     * 
     * @param ids 需要删除的群聊管理主键集合
     * @return 结果
     */
    public int deleteGroupByIds(Long[] ids);

    /**
     * 删除群聊管理信息
     * 
     * @param id 群聊管理主键
     * @return 结果
     */
    public int deleteGroupById(Long id);
}
