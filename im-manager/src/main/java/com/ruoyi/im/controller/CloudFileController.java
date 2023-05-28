package com.ruoyi.im.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.im.domain.CloudFile;
import com.ruoyi.im.service.ICloudFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 云文件管理Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/cloud_file")
public class CloudFileController extends BaseController
{
    @Autowired
    private ICloudFileService cloudFileService;

    /**
     * 查询云文件管理列表
     */
    @PreAuthorize("@ss.hasPermi('im:cloud_file:list')")
    @GetMapping("/list")
    public TableDataInfo list(CloudFile cloudFile)
    {
        startPage();
        List<CloudFile> list = cloudFileService.selectCloudFileList(cloudFile);
        return getDataTable(list);
    }

    /**
     * 导出云文件管理列表
     */
    @PreAuthorize("@ss.hasPermi('im:cloud_file:export')")
    @Log(title = "云文件管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CloudFile cloudFile)
    {
        List<CloudFile> list = cloudFileService.selectCloudFileList(cloudFile);
        ExcelUtil<CloudFile> util = new ExcelUtil<CloudFile>(CloudFile.class);
        util.exportExcel(response, list, "云文件管理数据");
    }

    /**
     * 获取云文件管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:cloud_file:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cloudFileService.selectCloudFileById(id));
    }

    /**
     * 新增云文件管理
     */
    @PreAuthorize("@ss.hasPermi('im:cloud_file:add')")
    @Log(title = "云文件管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CloudFile cloudFile)
    {
        return toAjax(cloudFileService.insertCloudFile(cloudFile));
    }

    /**
     * 修改云文件管理
     */
    @PreAuthorize("@ss.hasPermi('im:cloud_file:edit')")
    @Log(title = "云文件管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CloudFile cloudFile)
    {
        return toAjax(cloudFileService.updateCloudFile(cloudFile));
    }

    /**
     * 删除云文件管理
     */
    @PreAuthorize("@ss.hasPermi('im:cloud_file:remove')")
    @Log(title = "云文件管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cloudFileService.deleteCloudFileByIds(ids));
    }
}
