package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.ChatMessageMapper;
import com.ruoyi.im.domain.ChatMessage;
import com.ruoyi.im.service.IChatMessageService;

/**
 * 消息内容Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class ChatMessageServiceImpl implements IChatMessageService 
{
    @Autowired
    private ChatMessageMapper chatMessageMapper;

    /**
     * 查询消息内容
     * 
     * @param id 消息内容主键
     * @return 消息内容
     */
    @Override
    public ChatMessage selectChatMessageById(Long id)
    {
        return chatMessageMapper.selectChatMessageById(id);
    }

    /**
     * 查询消息内容列表
     * 
     * @param chatMessage 消息内容
     * @return 消息内容
     */
    @Override
    public List<ChatMessage> selectChatMessageList(ChatMessage chatMessage)
    {
        return chatMessageMapper.selectChatMessageList(chatMessage);
    }

    /**
     * 新增消息内容
     * 
     * @param chatMessage 消息内容
     * @return 结果
     */
    @Override
    public int insertChatMessage(ChatMessage chatMessage)
    {
        chatMessage.setCreateTime(DateUtils.getNowDate());
        return chatMessageMapper.insertChatMessage(chatMessage);
    }

    /**
     * 修改消息内容
     * 
     * @param chatMessage 消息内容
     * @return 结果
     */
    @Override
    public int updateChatMessage(ChatMessage chatMessage)
    {
        chatMessage.setUpdateTime(DateUtils.getNowDate());
        return chatMessageMapper.updateChatMessage(chatMessage);
    }

    /**
     * 批量删除消息内容
     * 
     * @param ids 需要删除的消息内容主键
     * @return 结果
     */
    @Override
    public int deleteChatMessageByIds(Long[] ids)
    {
        return chatMessageMapper.deleteChatMessageByIds(ids);
    }

    /**
     * 删除消息内容信息
     * 
     * @param id 消息内容主键
     * @return 结果
     */
    @Override
    public int deleteChatMessageById(Long id)
    {
        return chatMessageMapper.deleteChatMessageById(id);
    }
}
