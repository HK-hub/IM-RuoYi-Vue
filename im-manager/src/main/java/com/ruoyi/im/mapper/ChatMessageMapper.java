package com.ruoyi.im.mapper;

import java.util.List;
import com.ruoyi.im.domain.ChatMessage;

/**
 * 消息内容Mapper接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface ChatMessageMapper 
{
    /**
     * 查询消息内容
     * 
     * @param id 消息内容主键
     * @return 消息内容
     */
    public ChatMessage selectChatMessageById(Long id);

    /**
     * 查询消息内容列表
     * 
     * @param chatMessage 消息内容
     * @return 消息内容集合
     */
    public List<ChatMessage> selectChatMessageList(ChatMessage chatMessage);

    /**
     * 新增消息内容
     * 
     * @param chatMessage 消息内容
     * @return 结果
     */
    public int insertChatMessage(ChatMessage chatMessage);

    /**
     * 修改消息内容
     * 
     * @param chatMessage 消息内容
     * @return 结果
     */
    public int updateChatMessage(ChatMessage chatMessage);

    /**
     * 删除消息内容
     * 
     * @param id 消息内容主键
     * @return 结果
     */
    public int deleteChatMessageById(Long id);

    /**
     * 批量删除消息内容
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatMessageByIds(Long[] ids);
}
