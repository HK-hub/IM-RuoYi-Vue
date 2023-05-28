package com.ruoyi.im.service.service;

import java.util.List;
import com.ruoyi.im.domain.Friend;

/**
 * 好友管理Service接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface IFriendService 
{
    /**
     * 查询好友管理
     * 
     * @param id 好友管理主键
     * @return 好友管理
     */
    public Friend selectFriendById(Long id);

    /**
     * 查询好友管理列表
     * 
     * @param friend 好友管理
     * @return 好友管理集合
     */
    public List<Friend> selectFriendList(Friend friend);

    /**
     * 新增好友管理
     * 
     * @param friend 好友管理
     * @return 结果
     */
    public int insertFriend(Friend friend);

    /**
     * 修改好友管理
     * 
     * @param friend 好友管理
     * @return 结果
     */
    public int updateFriend(Friend friend);

    /**
     * 批量删除好友管理
     * 
     * @param ids 需要删除的好友管理主键集合
     * @return 结果
     */
    public int deleteFriendByIds(Long[] ids);

    /**
     * 删除好友管理信息
     * 
     * @param id 好友管理主键
     * @return 结果
     */
    public int deleteFriendById(Long id);
}
