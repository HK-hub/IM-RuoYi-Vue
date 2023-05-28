package com.ruoyi.im.service.service;

import java.util.List;
import com.ruoyi.im.domain.TbFriendGroup;

/**
 * 好友分组Service接口
 * 
 * @author HK
 * @date 2023-05-28
 */
public interface ITbFriendGroupService 
{
    /**
     * 查询好友分组
     * 
     * @param id 好友分组主键
     * @return 好友分组
     */
    public TbFriendGroup selectTbFriendGroupById(Long id);

    /**
     * 查询好友分组列表
     * 
     * @param tbFriendGroup 好友分组
     * @return 好友分组集合
     */
    public List<TbFriendGroup> selectTbFriendGroupList(TbFriendGroup tbFriendGroup);

    /**
     * 新增好友分组
     * 
     * @param tbFriendGroup 好友分组
     * @return 结果
     */
    public int insertTbFriendGroup(TbFriendGroup tbFriendGroup);

    /**
     * 修改好友分组
     * 
     * @param tbFriendGroup 好友分组
     * @return 结果
     */
    public int updateTbFriendGroup(TbFriendGroup tbFriendGroup);

    /**
     * 批量删除好友分组
     * 
     * @param ids 需要删除的好友分组主键集合
     * @return 结果
     */
    public int deleteTbFriendGroupByIds(Long[] ids);

    /**
     * 删除好友分组信息
     * 
     * @param id 好友分组主键
     * @return 结果
     */
    public int deleteTbFriendGroupById(Long id);
}
