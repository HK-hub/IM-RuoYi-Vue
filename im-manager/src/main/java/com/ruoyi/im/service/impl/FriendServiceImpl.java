package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.im.service.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.FriendMapper;
import com.ruoyi.im.domain.Friend;

/**
 * 好友管理Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class FriendServiceImpl implements IFriendService
{
    @Autowired
    private FriendMapper friendMapper;

    /**
     * 查询好友管理
     * 
     * @param id 好友管理主键
     * @return 好友管理
     */
    @Override
    public Friend selectFriendById(Long id)
    {
        return friendMapper.selectFriendById(id);
    }

    /**
     * 查询好友管理列表
     * 
     * @param friend 好友管理
     * @return 好友管理
     */
    @Override
    public List<Friend> selectFriendList(Friend friend)
    {
        return friendMapper.selectFriendList(friend);
    }

    /**
     * 新增好友管理
     * 
     * @param friend 好友管理
     * @return 结果
     */
    @Override
    public int insertFriend(Friend friend)
    {
        friend.setCreateTime(DateUtils.getNowDate());
        return friendMapper.insertFriend(friend);
    }

    /**
     * 修改好友管理
     * 
     * @param friend 好友管理
     * @return 结果
     */
    @Override
    public int updateFriend(Friend friend)
    {
        friend.setUpdateTime(DateUtils.getNowDate());
        return friendMapper.updateFriend(friend);
    }

    /**
     * 批量删除好友管理
     * 
     * @param ids 需要删除的好友管理主键
     * @return 结果
     */
    @Override
    public int deleteFriendByIds(Long[] ids)
    {
        return friendMapper.deleteFriendByIds(ids);
    }

    /**
     * 删除好友管理信息
     * 
     * @param id 好友管理主键
     * @return 结果
     */
    @Override
    public int deleteFriendById(Long id)
    {
        return friendMapper.deleteFriendById(id);
    }
}
