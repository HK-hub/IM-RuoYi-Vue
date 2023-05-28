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
import com.ruoyi.im.domain.CloudResource;
import com.ruoyi.im.service.ICloudResourceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 云资源管理Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/cloud_resource")
public class CloudResourceController extends BaseController
{
    @Autowired
    private ICloudResourceService cloudResourceService;

    /**
     * 查询云资源管理列表
     */
    @PreAuthorize("@ss.hasPermi('im:cloud_resource:list')")
    @GetMapping("/list")
    public TableDataInfo list(CloudResource cloudResource)
    {
        startPage();
        List<CloudResource> list = cloudResourceService.selectCloudResourceList(cloudResource);
        return getDataTable(list);
    }

    /**
     * 导出云资源管理列表
     */
    @PreAuthorize("@ss.hasPermi('im:cloud_resource:export')")
    @Log(title = "云资源管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CloudResource cloudResource)
    {
        List<CloudResource> list = cloudResourceService.selectCloudResourceList(cloudResource);
        ExcelUtil<CloudResource> util = new ExcelUtil<CloudResource>(CloudResource.class);
        util.exportExcel(response, list, "云资源管理数据");
    }

    /**
     * 获取云资源管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:cloud_resource:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cloudResourceService.selectCloudResourceById(id));
    }

    /**
     * 新增云资源管理
     */
    @PreAuthorize("@ss.hasPermi('im:cloud_resource:add')")
    @Log(title = "云资源管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CloudResource cloudResource)
    {
        return toAjax(cloudResourceService.insertCloudResource(cloudResource));
    }

    /**
     * 修改云资源管理
     */
    @PreAuthorize("@ss.hasPermi('im:cloud_resource:edit')")
    @Log(title = "云资源管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CloudResource cloudResource)
    {
        return toAjax(cloudResourceService.updateCloudResource(cloudResource));
    }

    /**
     * 删除云资源管理
     */
    @PreAuthorize("@ss.hasPermi('im:cloud_resource:remove')")
    @Log(title = "云资源管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cloudResourceService.deleteCloudResourceByIds(ids));
    }
}
