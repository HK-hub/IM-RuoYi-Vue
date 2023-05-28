package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.UserInfoMapper;
import com.ruoyi.im.domain.UserInfo;
import com.ruoyi.im.service.IUserInfoService;

/**
 * 个人信息Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService 
{
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 查询个人信息
     * 
     * @param userId 个人信息主键
     * @return 个人信息
     */
    @Override
    public UserInfo selectUserInfoByUserId(Long userId)
    {
        return userInfoMapper.selectUserInfoByUserId(userId);
    }

    /**
     * 查询个人信息列表
     * 
     * @param userInfo 个人信息
     * @return 个人信息
     */
    @Override
    public List<UserInfo> selectUserInfoList(UserInfo userInfo)
    {
        return userInfoMapper.selectUserInfoList(userInfo);
    }

    /**
     * 新增个人信息
     * 
     * @param userInfo 个人信息
     * @return 结果
     */
    @Override
    public int insertUserInfo(UserInfo userInfo)
    {
        userInfo.setCreateTime(DateUtils.getNowDate());
        return userInfoMapper.insertUserInfo(userInfo);
    }

    /**
     * 修改个人信息
     * 
     * @param userInfo 个人信息
     * @return 结果
     */
    @Override
    public int updateUserInfo(UserInfo userInfo)
    {
        userInfo.setUpdateTime(DateUtils.getNowDate());
        return userInfoMapper.updateUserInfo(userInfo);
    }

    /**
     * 批量删除个人信息
     * 
     * @param userIds 需要删除的个人信息主键
     * @return 结果
     */
    @Override
    public int deleteUserInfoByUserIds(Long[] userIds)
    {
        return userInfoMapper.deleteUserInfoByUserIds(userIds);
    }

    /**
     * 删除个人信息信息
     * 
     * @param userId 个人信息主键
     * @return 结果
     */
    @Override
    public int deleteUserInfoByUserId(Long userId)
    {
        return userInfoMapper.deleteUserInfoByUserId(userId);
    }
}
