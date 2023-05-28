package com.ruoyi.im.service;

import java.util.List;
import com.ruoyi.im.domain.SplitUpload;

/**
 * 文件分片数据Service接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface ISplitUploadService 
{
    /**
     * 查询文件分片数据
     * 
     * @param id 文件分片数据主键
     * @return 文件分片数据
     */
    public SplitUpload selectSplitUploadById(String id);

    /**
     * 查询文件分片数据列表
     * 
     * @param splitUpload 文件分片数据
     * @return 文件分片数据集合
     */
    public List<SplitUpload> selectSplitUploadList(SplitUpload splitUpload);

    /**
     * 新增文件分片数据
     * 
     * @param splitUpload 文件分片数据
     * @return 结果
     */
    public int insertSplitUpload(SplitUpload splitUpload);

    /**
     * 修改文件分片数据
     * 
     * @param splitUpload 文件分片数据
     * @return 结果
     */
    public int updateSplitUpload(SplitUpload splitUpload);

    /**
     * 批量删除文件分片数据
     * 
     * @param ids 需要删除的文件分片数据主键集合
     * @return 结果
     */
    public int deleteSplitUploadByIds(String[] ids);

    /**
     * 删除文件分片数据信息
     * 
     * @param id 文件分片数据主键
     * @return 结果
     */
    public int deleteSplitUploadById(String id);
}
