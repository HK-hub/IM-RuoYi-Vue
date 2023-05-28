package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.im.service.service.ITbFriendGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.TbFriendGroupMapper;
import com.ruoyi.im.domain.TbFriendGroup;

/**
 * 好友分组Service业务层处理
 * 
 * @author HK
 * @date 2023-05-28
 */
@Service
public class TbFriendGroupServiceImpl implements ITbFriendGroupService
{
    @Autowired
    private TbFriendGroupMapper tbFriendGroupMapper;

    /**
     * 查询好友分组
     * 
     * @param id 好友分组主键
     * @return 好友分组
     */
    @Override
    public TbFriendGroup selectTbFriendGroupById(Long id)
    {
        return tbFriendGroupMapper.selectTbFriendGroupById(id);
    }

    /**
     * 查询好友分组列表
     * 
     * @param tbFriendGroup 好友分组
     * @return 好友分组
     */
    @Override
    public List<TbFriendGroup> selectTbFriendGroupList(TbFriendGroup tbFriendGroup)
    {
        return tbFriendGroupMapper.selectTbFriendGroupList(tbFriendGroup);
    }

    /**
     * 新增好友分组
     * 
     * @param tbFriendGroup 好友分组
     * @return 结果
     */
    @Override
    public int insertTbFriendGroup(TbFriendGroup tbFriendGroup)
    {
        tbFriendGroup.setCreateTime(DateUtils.getNowDate());
        return tbFriendGroupMapper.insertTbFriendGroup(tbFriendGroup);
    }

    /**
     * 修改好友分组
     * 
     * @param tbFriendGroup 好友分组
     * @return 结果
     */
    @Override
    public int updateTbFriendGroup(TbFriendGroup tbFriendGroup)
    {
        tbFriendGroup.setUpdateTime(DateUtils.getNowDate());
        return tbFriendGroupMapper.updateTbFriendGroup(tbFriendGroup);
    }

    /**
     * 批量删除好友分组
     * 
     * @param ids 需要删除的好友分组主键
     * @return 结果
     */
    @Override
    public int deleteTbFriendGroupByIds(Long[] ids)
    {
        return tbFriendGroupMapper.deleteTbFriendGroupByIds(ids);
    }

    /**
     * 删除好友分组信息
     * 
     * @param id 好友分组主键
     * @return 结果
     */
    @Override
    public int deleteTbFriendGroupById(Long id)
    {
        return tbFriendGroupMapper.deleteTbFriendGroupById(id);
    }
}
