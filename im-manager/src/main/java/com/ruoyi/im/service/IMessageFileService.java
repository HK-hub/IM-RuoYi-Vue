package com.ruoyi.im.service;

import java.util.List;
import com.ruoyi.im.domain.MessageFile;

/**
 * 文件消息Service接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface IMessageFileService 
{
    /**
     * 查询文件消息
     * 
     * @param id 文件消息主键
     * @return 文件消息
     */
    public MessageFile selectMessageFileById(String id);

    /**
     * 查询文件消息列表
     * 
     * @param messageFile 文件消息
     * @return 文件消息集合
     */
    public List<MessageFile> selectMessageFileList(MessageFile messageFile);

    /**
     * 新增文件消息
     * 
     * @param messageFile 文件消息
     * @return 结果
     */
    public int insertMessageFile(MessageFile messageFile);

    /**
     * 修改文件消息
     * 
     * @param messageFile 文件消息
     * @return 结果
     */
    public int updateMessageFile(MessageFile messageFile);

    /**
     * 批量删除文件消息
     * 
     * @param ids 需要删除的文件消息主键集合
     * @return 结果
     */
    public int deleteMessageFileByIds(String[] ids);

    /**
     * 删除文件消息信息
     * 
     * @param id 文件消息主键
     * @return 结果
     */
    public int deleteMessageFileById(String id);
}
