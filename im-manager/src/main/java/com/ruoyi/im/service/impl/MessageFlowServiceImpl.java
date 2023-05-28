package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.MessageFlowMapper;
import com.ruoyi.im.domain.MessageFlow;
import com.ruoyi.im.service.IMessageFlowService;

/**
 * 消息流水Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class MessageFlowServiceImpl implements IMessageFlowService 
{
    @Autowired
    private MessageFlowMapper messageFlowMapper;

    /**
     * 查询消息流水
     * 
     * @param id 消息流水主键
     * @return 消息流水
     */
    @Override
    public MessageFlow selectMessageFlowById(Long id)
    {
        return messageFlowMapper.selectMessageFlowById(id);
    }

    /**
     * 查询消息流水列表
     * 
     * @param messageFlow 消息流水
     * @return 消息流水
     */
    @Override
    public List<MessageFlow> selectMessageFlowList(MessageFlow messageFlow)
    {
        return messageFlowMapper.selectMessageFlowList(messageFlow);
    }

    /**
     * 新增消息流水
     * 
     * @param messageFlow 消息流水
     * @return 结果
     */
    @Override
    public int insertMessageFlow(MessageFlow messageFlow)
    {
        messageFlow.setCreateTime(DateUtils.getNowDate());
        return messageFlowMapper.insertMessageFlow(messageFlow);
    }

    /**
     * 修改消息流水
     * 
     * @param messageFlow 消息流水
     * @return 结果
     */
    @Override
    public int updateMessageFlow(MessageFlow messageFlow)
    {
        messageFlow.setUpdateTime(DateUtils.getNowDate());
        return messageFlowMapper.updateMessageFlow(messageFlow);
    }

    /**
     * 批量删除消息流水
     * 
     * @param ids 需要删除的消息流水主键
     * @return 结果
     */
    @Override
    public int deleteMessageFlowByIds(Long[] ids)
    {
        return messageFlowMapper.deleteMessageFlowByIds(ids);
    }

    /**
     * 删除消息流水信息
     * 
     * @param id 消息流水主键
     * @return 结果
     */
    @Override
    public int deleteMessageFlowById(Long id)
    {
        return messageFlowMapper.deleteMessageFlowById(id);
    }
}
