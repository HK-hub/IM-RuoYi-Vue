package com.ruoyi.im.service;

import java.util.List;
import com.ruoyi.im.domain.UserInfo;

/**
 * 个人信息Service接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface IUserInfoService 
{
    /**
     * 查询个人信息
     * 
     * @param userId 个人信息主键
     * @return 个人信息
     */
    public UserInfo selectUserInfoByUserId(Long userId);

    /**
     * 查询个人信息列表
     * 
     * @param userInfo 个人信息
     * @return 个人信息集合
     */
    public List<UserInfo> selectUserInfoList(UserInfo userInfo);

    /**
     * 新增个人信息
     * 
     * @param userInfo 个人信息
     * @return 结果
     */
    public int insertUserInfo(UserInfo userInfo);

    /**
     * 修改个人信息
     * 
     * @param userInfo 个人信息
     * @return 结果
     */
    public int updateUserInfo(UserInfo userInfo);

    /**
     * 批量删除个人信息
     * 
     * @param userIds 需要删除的个人信息主键集合
     * @return 结果
     */
    public int deleteUserInfoByUserIds(Long[] userIds);

    /**
     * 删除个人信息信息
     * 
     * @param userId 个人信息主键
     * @return 结果
     */
    public int deleteUserInfoByUserId(Long userId);
}
