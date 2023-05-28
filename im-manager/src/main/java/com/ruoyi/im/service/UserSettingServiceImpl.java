package com.ruoyi.im.service;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.UserSettingMapper;
import com.ruoyi.im.domain.UserSetting;
import com.ruoyi.im.service.IUserSettingService;

/**
 * 用户个性化设置Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class UserSettingServiceImpl implements IUserSettingService 
{
    @Autowired
    private UserSettingMapper userSettingMapper;

    /**
     * 查询用户个性化设置
     * 
     * @param id 用户个性化设置主键
     * @return 用户个性化设置
     */
    @Override
    public UserSetting selectUserSettingById(Long id)
    {
        return userSettingMapper.selectUserSettingById(id);
    }

    /**
     * 查询用户个性化设置列表
     * 
     * @param userSetting 用户个性化设置
     * @return 用户个性化设置
     */
    @Override
    public List<UserSetting> selectUserSettingList(UserSetting userSetting)
    {
        return userSettingMapper.selectUserSettingList(userSetting);
    }

    /**
     * 新增用户个性化设置
     * 
     * @param userSetting 用户个性化设置
     * @return 结果
     */
    @Override
    public int insertUserSetting(UserSetting userSetting)
    {
        userSetting.setCreateTime(DateUtils.getNowDate());
        return userSettingMapper.insertUserSetting(userSetting);
    }

    /**
     * 修改用户个性化设置
     * 
     * @param userSetting 用户个性化设置
     * @return 结果
     */
    @Override
    public int updateUserSetting(UserSetting userSetting)
    {
        userSetting.setUpdateTime(DateUtils.getNowDate());
        return userSettingMapper.updateUserSetting(userSetting);
    }

    /**
     * 批量删除用户个性化设置
     * 
     * @param ids 需要删除的用户个性化设置主键
     * @return 结果
     */
    @Override
    public int deleteUserSettingByIds(Long[] ids)
    {
        return userSettingMapper.deleteUserSettingByIds(ids);
    }

    /**
     * 删除用户个性化设置信息
     * 
     * @param id 用户个性化设置主键
     * @return 结果
     */
    @Override
    public int deleteUserSettingById(Long id)
    {
        return userSettingMapper.deleteUserSettingById(id);
    }
}
