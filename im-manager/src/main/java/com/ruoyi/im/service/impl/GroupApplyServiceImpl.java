package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.GroupApplyMapper;
import com.ruoyi.im.domain.GroupApply;
import com.ruoyi.im.service.IGroupApplyService;

/**
 * 群聊申请Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class GroupApplyServiceImpl implements IGroupApplyService 
{
    @Autowired
    private GroupApplyMapper groupApplyMapper;

    /**
     * 查询群聊申请
     * 
     * @param id 群聊申请主键
     * @return 群聊申请
     */
    @Override
    public GroupApply selectGroupApplyById(Long id)
    {
        return groupApplyMapper.selectGroupApplyById(id);
    }

    /**
     * 查询群聊申请列表
     * 
     * @param groupApply 群聊申请
     * @return 群聊申请
     */
    @Override
    public List<GroupApply> selectGroupApplyList(GroupApply groupApply)
    {
        return groupApplyMapper.selectGroupApplyList(groupApply);
    }

    /**
     * 新增群聊申请
     * 
     * @param groupApply 群聊申请
     * @return 结果
     */
    @Override
    public int insertGroupApply(GroupApply groupApply)
    {
        groupApply.setCreateTime(DateUtils.getNowDate());
        return groupApplyMapper.insertGroupApply(groupApply);
    }

    /**
     * 修改群聊申请
     * 
     * @param groupApply 群聊申请
     * @return 结果
     */
    @Override
    public int updateGroupApply(GroupApply groupApply)
    {
        groupApply.setUpdateTime(DateUtils.getNowDate());
        return groupApplyMapper.updateGroupApply(groupApply);
    }

    /**
     * 批量删除群聊申请
     * 
     * @param ids 需要删除的群聊申请主键
     * @return 结果
     */
    @Override
    public int deleteGroupApplyByIds(Long[] ids)
    {
        return groupApplyMapper.deleteGroupApplyByIds(ids);
    }

    /**
     * 删除群聊申请信息
     * 
     * @param id 群聊申请主键
     * @return 结果
     */
    @Override
    public int deleteGroupApplyById(Long id)
    {
        return groupApplyMapper.deleteGroupApplyById(id);
    }
}
