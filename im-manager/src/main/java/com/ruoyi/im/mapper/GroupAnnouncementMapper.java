package com.ruoyi.im.mapper;

import java.util.List;
import com.ruoyi.im.domain.GroupAnnouncement;

/**
 * 群公告Mapper接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface GroupAnnouncementMapper 
{
    /**
     * 查询群公告
     * 
     * @param id 群公告主键
     * @return 群公告
     */
    public GroupAnnouncement selectGroupAnnouncementById(Long id);

    /**
     * 查询群公告列表
     * 
     * @param groupAnnouncement 群公告
     * @return 群公告集合
     */
    public List<GroupAnnouncement> selectGroupAnnouncementList(GroupAnnouncement groupAnnouncement);

    /**
     * 新增群公告
     * 
     * @param groupAnnouncement 群公告
     * @return 结果
     */
    public int insertGroupAnnouncement(GroupAnnouncement groupAnnouncement);

    /**
     * 修改群公告
     * 
     * @param groupAnnouncement 群公告
     * @return 结果
     */
    public int updateGroupAnnouncement(GroupAnnouncement groupAnnouncement);

    /**
     * 删除群公告
     * 
     * @param id 群公告主键
     * @return 结果
     */
    public int deleteGroupAnnouncementById(Long id);

    /**
     * 批量删除群公告
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGroupAnnouncementByIds(Long[] ids);
}
