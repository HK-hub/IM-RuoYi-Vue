package com.ruoyi.im.mapper;

import java.util.List;
import com.ruoyi.im.domain.MessageFile;

/**
 * 文件消息Mapper接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface MessageFileMapper 
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
     * 删除文件消息
     * 
     * @param id 文件消息主键
     * @return 结果
     */
    public int deleteMessageFileById(String id);

    /**
     * 批量删除文件消息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMessageFileByIds(String[] ids);
}
