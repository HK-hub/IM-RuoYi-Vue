package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.SplitUploadMapper;
import com.ruoyi.im.domain.SplitUpload;
import com.ruoyi.im.service.ISplitUploadService;

/**
 * 文件分片数据Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class SplitUploadServiceImpl implements ISplitUploadService 
{
    @Autowired
    private SplitUploadMapper splitUploadMapper;

    /**
     * 查询文件分片数据
     * 
     * @param id 文件分片数据主键
     * @return 文件分片数据
     */
    @Override
    public SplitUpload selectSplitUploadById(String id)
    {
        return splitUploadMapper.selectSplitUploadById(id);
    }

    /**
     * 查询文件分片数据列表
     * 
     * @param splitUpload 文件分片数据
     * @return 文件分片数据
     */
    @Override
    public List<SplitUpload> selectSplitUploadList(SplitUpload splitUpload)
    {
        return splitUploadMapper.selectSplitUploadList(splitUpload);
    }

    /**
     * 新增文件分片数据
     * 
     * @param splitUpload 文件分片数据
     * @return 结果
     */
    @Override
    public int insertSplitUpload(SplitUpload splitUpload)
    {
        splitUpload.setCreateTime(DateUtils.getNowDate());
        return splitUploadMapper.insertSplitUpload(splitUpload);
    }

    /**
     * 修改文件分片数据
     * 
     * @param splitUpload 文件分片数据
     * @return 结果
     */
    @Override
    public int updateSplitUpload(SplitUpload splitUpload)
    {
        splitUpload.setUpdateTime(DateUtils.getNowDate());
        return splitUploadMapper.updateSplitUpload(splitUpload);
    }

    /**
     * 批量删除文件分片数据
     * 
     * @param ids 需要删除的文件分片数据主键
     * @return 结果
     */
    @Override
    public int deleteSplitUploadByIds(String[] ids)
    {
        return splitUploadMapper.deleteSplitUploadByIds(ids);
    }

    /**
     * 删除文件分片数据信息
     * 
     * @param id 文件分片数据主键
     * @return 结果
     */
    @Override
    public int deleteSplitUploadById(String id)
    {
        return splitUploadMapper.deleteSplitUploadById(id);
    }
}
