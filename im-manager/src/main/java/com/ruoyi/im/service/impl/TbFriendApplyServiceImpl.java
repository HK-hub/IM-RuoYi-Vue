package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.im.service.service.ITbFriendApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.TbFriendApplyMapper;
import com.ruoyi.im.domain.TbFriendApply;

/**
 * 好友申请Service业务层处理
 * 
 * @author HK
 * @date 2023-05-28
 */
@Service
public class TbFriendApplyServiceImpl implements ITbFriendApplyService
{
    @Autowired
    private TbFriendApplyMapper tbFriendApplyMapper;

    /**
     * 查询好友申请
     * 
     * @param id 好友申请主键
     * @return 好友申请
     */
    @Override
    public TbFriendApply selectTbFriendApplyById(Long id)
    {
        return tbFriendApplyMapper.selectTbFriendApplyById(id);
    }

    /**
     * 查询好友申请列表
     * 
     * @param tbFriendApply 好友申请
     * @return 好友申请
     */
    @Override
    public List<TbFriendApply> selectTbFriendApplyList(TbFriendApply tbFriendApply)
    {
        return tbFriendApplyMapper.selectTbFriendApplyList(tbFriendApply);
    }

    /**
     * 新增好友申请
     * 
     * @param tbFriendApply 好友申请
     * @return 结果
     */
    @Override
    public int insertTbFriendApply(TbFriendApply tbFriendApply)
    {
        tbFriendApply.setCreateTime(DateUtils.getNowDate());
        return tbFriendApplyMapper.insertTbFriendApply(tbFriendApply);
    }

    /**
     * 修改好友申请
     * 
     * @param tbFriendApply 好友申请
     * @return 结果
     */
    @Override
    public int updateTbFriendApply(TbFriendApply tbFriendApply)
    {
        tbFriendApply.setUpdateTime(DateUtils.getNowDate());
        return tbFriendApplyMapper.updateTbFriendApply(tbFriendApply);
    }

    /**
     * 批量删除好友申请
     * 
     * @param ids 需要删除的好友申请主键
     * @return 结果
     */
    @Override
    public int deleteTbFriendApplyByIds(Long[] ids)
    {
        return tbFriendApplyMapper.deleteTbFriendApplyByIds(ids);
    }

    /**
     * 删除好友申请信息
     * 
     * @param id 好友申请主键
     * @return 结果
     */
    @Override
    public int deleteTbFriendApplyById(Long id)
    {
        return tbFriendApplyMapper.deleteTbFriendApplyById(id);
    }
}
