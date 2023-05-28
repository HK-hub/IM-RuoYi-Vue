package com.ruoyi.im.service;

import java.util.List;
import com.ruoyi.im.domain.GroupApply;

/**
 * 群聊申请Service接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface IGroupApplyService 
{
    /**
     * 查询群聊申请
     * 
     * @param id 群聊申请主键
     * @return 群聊申请
     */
    public GroupApply selectGroupApplyById(Long id);

    /**
     * 查询群聊申请列表
     * 
     * @param groupApply 群聊申请
     * @return 群聊申请集合
     */
    public List<GroupApply> selectGroupApplyList(GroupApply groupApply);

    /**
     * 新增群聊申请
     * 
     * @param groupApply 群聊申请
     * @return 结果
     */
    public int insertGroupApply(GroupApply groupApply);

    /**
     * 修改群聊申请
     * 
     * @param groupApply 群聊申请
     * @return 结果
     */
    public int updateGroupApply(GroupApply groupApply);

    /**
     * 批量删除群聊申请
     * 
     * @param ids 需要删除的群聊申请主键集合
     * @return 结果
     */
    public int deleteGroupApplyByIds(Long[] ids);

    /**
     * 删除群聊申请信息
     * 
     * @param id 群聊申请主键
     * @return 结果
     */
    public int deleteGroupApplyById(Long id);
}
