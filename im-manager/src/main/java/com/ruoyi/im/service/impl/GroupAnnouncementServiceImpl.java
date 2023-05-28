package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.GroupAnnouncementMapper;
import com.ruoyi.im.domain.GroupAnnouncement;
import com.ruoyi.im.service.IGroupAnnouncementService;

/**
 * 群公告Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class GroupAnnouncementServiceImpl implements IGroupAnnouncementService 
{
    @Autowired
    private GroupAnnouncementMapper groupAnnouncementMapper;

    /**
     * 查询群公告
     * 
     * @param id 群公告主键
     * @return 群公告
     */
    @Override
    public GroupAnnouncement selectGroupAnnouncementById(Long id)
    {
        return groupAnnouncementMapper.selectGroupAnnouncementById(id);
    }

    /**
     * 查询群公告列表
     * 
     * @param groupAnnouncement 群公告
     * @return 群公告
     */
    @Override
    public List<GroupAnnouncement> selectGroupAnnouncementList(GroupAnnouncement groupAnnouncement)
    {
        return groupAnnouncementMapper.selectGroupAnnouncementList(groupAnnouncement);
    }

    /**
     * 新增群公告
     * 
     * @param groupAnnouncement 群公告
     * @return 结果
     */
    @Override
    public int insertGroupAnnouncement(GroupAnnouncement groupAnnouncement)
    {
        groupAnnouncement.setCreateTime(DateUtils.getNowDate());
        return groupAnnouncementMapper.insertGroupAnnouncement(groupAnnouncement);
    }

    /**
     * 修改群公告
     * 
     * @param groupAnnouncement 群公告
     * @return 结果
     */
    @Override
    public int updateGroupAnnouncement(GroupAnnouncement groupAnnouncement)
    {
        groupAnnouncement.setUpdateTime(DateUtils.getNowDate());
        return groupAnnouncementMapper.updateGroupAnnouncement(groupAnnouncement);
    }

    /**
     * 批量删除群公告
     * 
     * @param ids 需要删除的群公告主键
     * @return 结果
     */
    @Override
    public int deleteGroupAnnouncementByIds(Long[] ids)
    {
        return groupAnnouncementMapper.deleteGroupAnnouncementByIds(ids);
    }

    /**
     * 删除群公告信息
     * 
     * @param id 群公告主键
     * @return 结果
     */
    @Override
    public int deleteGroupAnnouncementById(Long id)
    {
        return groupAnnouncementMapper.deleteGroupAnnouncementById(id);
    }
}
