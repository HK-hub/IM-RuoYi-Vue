package com.ruoyi.im.service;

import java.util.List;
import com.ruoyi.im.domain.MessageFlow;

/**
 * 消息流水Service接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface IMessageFlowService 
{
    /**
     * 查询消息流水
     * 
     * @param id 消息流水主键
     * @return 消息流水
     */
    public MessageFlow selectMessageFlowById(Long id);

    /**
     * 查询消息流水列表
     * 
     * @param messageFlow 消息流水
     * @return 消息流水集合
     */
    public List<MessageFlow> selectMessageFlowList(MessageFlow messageFlow);

    /**
     * 新增消息流水
     * 
     * @param messageFlow 消息流水
     * @return 结果
     */
    public int insertMessageFlow(MessageFlow messageFlow);

    /**
     * 修改消息流水
     * 
     * @param messageFlow 消息流水
     * @return 结果
     */
    public int updateMessageFlow(MessageFlow messageFlow);

    /**
     * 批量删除消息流水
     * 
     * @param ids 需要删除的消息流水主键集合
     * @return 结果
     */
    public int deleteMessageFlowByIds(Long[] ids);

    /**
     * 删除消息流水信息
     * 
     * @param id 消息流水主键
     * @return 结果
     */
    public int deleteMessageFlowById(Long id);
}
