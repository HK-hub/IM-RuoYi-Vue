package com.ruoyi.im.mapper;

import java.util.List;
import com.ruoyi.im.domain.UserSetting;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户个性化设置Mapper接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Mapper
public interface UserSettingMapper 
{
    /**
     * 查询用户个性化设置
     * 
     * @param id 用户个性化设置主键
     * @return 用户个性化设置
     */
    public UserSetting selectUserSettingById(Long id);

    /**
     * 查询用户个性化设置列表
     * 
     * @param userSetting 用户个性化设置
     * @return 用户个性化设置集合
     */
    public List<UserSetting> selectUserSettingList(UserSetting userSetting);

    /**
     * 新增用户个性化设置
     * 
     * @param userSetting 用户个性化设置
     * @return 结果
     */
    public int insertUserSetting(UserSetting userSetting);

    /**
     * 修改用户个性化设置
     * 
     * @param userSetting 用户个性化设置
     * @return 结果
     */
    public int updateUserSetting(UserSetting userSetting);

    /**
     * 删除用户个性化设置
     * 
     * @param id 用户个性化设置主键
     * @return 结果
     */
    public int deleteUserSettingById(Long id);

    /**
     * 批量删除用户个性化设置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserSettingByIds(Long[] ids);
}
