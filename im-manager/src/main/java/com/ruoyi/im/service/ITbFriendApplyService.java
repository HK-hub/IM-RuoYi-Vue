package com.ruoyi.im.service.service;

import java.util.List;
import com.ruoyi.im.domain.TbFriendApply;

/**
 * 好友申请Service接口
 * 
 * @author HK
 * @date 2023-05-28
 */
public interface ITbFriendApplyService 
{
    /**
     * 查询好友申请
     * 
     * @param id 好友申请主键
     * @return 好友申请
     */
    public TbFriendApply selectTbFriendApplyById(Long id);

    /**
     * 查询好友申请列表
     * 
     * @param tbFriendApply 好友申请
     * @return 好友申请集合
     */
    public List<TbFriendApply> selectTbFriendApplyList(TbFriendApply tbFriendApply);

    /**
     * 新增好友申请
     * 
     * @param tbFriendApply 好友申请
     * @return 结果
     */
    public int insertTbFriendApply(TbFriendApply tbFriendApply);

    /**
     * 修改好友申请
     * 
     * @param tbFriendApply 好友申请
     * @return 结果
     */
    public int updateTbFriendApply(TbFriendApply tbFriendApply);

    /**
     * 批量删除好友申请
     * 
     * @param ids 需要删除的好友申请主键集合
     * @return 结果
     */
    public int deleteTbFriendApplyByIds(Long[] ids);

    /**
     * 删除好友申请信息
     * 
     * @param id 好友申请主键
     * @return 结果
     */
    public int deleteTbFriendApplyById(Long id);
}
