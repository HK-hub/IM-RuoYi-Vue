package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.MessageFileMapper;
import com.ruoyi.im.domain.MessageFile;
import com.ruoyi.im.service.IMessageFileService;

/**
 * 文件消息Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class MessageFileServiceImpl implements IMessageFileService 
{
    @Autowired
    private MessageFileMapper messageFileMapper;

    /**
     * 查询文件消息
     * 
     * @param id 文件消息主键
     * @return 文件消息
     */
    @Override
    public MessageFile selectMessageFileById(String id)
    {
        return messageFileMapper.selectMessageFileById(id);
    }

    /**
     * 查询文件消息列表
     * 
     * @param messageFile 文件消息
     * @return 文件消息
     */
    @Override
    public List<MessageFile> selectMessageFileList(MessageFile messageFile)
    {
        return messageFileMapper.selectMessageFileList(messageFile);
    }

    /**
     * 新增文件消息
     * 
     * @param messageFile 文件消息
     * @return 结果
     */
    @Override
    public int insertMessageFile(MessageFile messageFile)
    {
        messageFile.setCreateTime(DateUtils.getNowDate());
        return messageFileMapper.insertMessageFile(messageFile);
    }

    /**
     * 修改文件消息
     * 
     * @param messageFile 文件消息
     * @return 结果
     */
    @Override
    public int updateMessageFile(MessageFile messageFile)
    {
        messageFile.setUpdateTime(DateUtils.getNowDate());
        return messageFileMapper.updateMessageFile(messageFile);
    }

    /**
     * 批量删除文件消息
     * 
     * @param ids 需要删除的文件消息主键
     * @return 结果
     */
    @Override
    public int deleteMessageFileByIds(String[] ids)
    {
        return messageFileMapper.deleteMessageFileByIds(ids);
    }

    /**
     * 删除文件消息信息
     * 
     * @param id 文件消息主键
     * @return 结果
     */
    @Override
    public int deleteMessageFileById(String id)
    {
        return messageFileMapper.deleteMessageFileById(id);
    }
}
