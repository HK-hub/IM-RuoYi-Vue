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
import com.ruoyi.im.domain.SplitUpload;
import com.ruoyi.im.service.ISplitUploadService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文件分片数据Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/upload")
public class SplitUploadController extends BaseController
{
    @Autowired
    private ISplitUploadService splitUploadService;

    /**
     * 查询文件分片数据列表
     */
    @PreAuthorize("@ss.hasPermi('im:upload:list')")
    @GetMapping("/list")
    public TableDataInfo list(SplitUpload splitUpload)
    {
        startPage();
        List<SplitUpload> list = splitUploadService.selectSplitUploadList(splitUpload);
        return getDataTable(list);
    }

    /**
     * 导出文件分片数据列表
     */
    @PreAuthorize("@ss.hasPermi('im:upload:export')")
    @Log(title = "文件分片数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SplitUpload splitUpload)
    {
        List<SplitUpload> list = splitUploadService.selectSplitUploadList(splitUpload);
        ExcelUtil<SplitUpload> util = new ExcelUtil<SplitUpload>(SplitUpload.class);
        util.exportExcel(response, list, "文件分片数据数据");
    }

    /**
     * 获取文件分片数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:upload:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(splitUploadService.selectSplitUploadById(id));
    }

    /**
     * 新增文件分片数据
     */
    @PreAuthorize("@ss.hasPermi('im:upload:add')")
    @Log(title = "文件分片数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SplitUpload splitUpload)
    {
        return toAjax(splitUploadService.insertSplitUpload(splitUpload));
    }

    /**
     * 修改文件分片数据
     */
    @PreAuthorize("@ss.hasPermi('im:upload:edit')")
    @Log(title = "文件分片数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SplitUpload splitUpload)
    {
        return toAjax(splitUploadService.updateSplitUpload(splitUpload));
    }

    /**
     * 删除文件分片数据
     */
    @PreAuthorize("@ss.hasPermi('im:upload:remove')")
    @Log(title = "文件分片数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(splitUploadService.deleteSplitUploadByIds(ids));
    }
}
