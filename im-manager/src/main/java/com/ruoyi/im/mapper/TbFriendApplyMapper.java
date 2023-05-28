package com.ruoyi.im.mapper;

import java.util.List;
import com.ruoyi.im.domain.TbFriendApply;

/**
 * 好友申请Mapper接口
 * 
 * @author HK
 * @date 2023-05-28
 */
public interface TbFriendApplyMapper 
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
     * 删除好友申请
     * 
     * @param id 好友申请主键
     * @return 结果
     */
    public int deleteTbFriendApplyById(Long id);

    /**
     * 批量删除好友申请
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbFriendApplyByIds(Long[] ids);
}
