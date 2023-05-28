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
import com.ruoyi.im.domain.Category;
import com.ruoyi.im.service.ICategoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 笔记分类Controller
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/im/category")
public class CategoryController extends BaseController
{
    @Autowired
    private ICategoryService categoryService;

    /**
     * 查询笔记分类列表
     */
    @PreAuthorize("@ss.hasPermi('im:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(Category category)
    {
        startPage();
        List<Category> list = categoryService.selectCategoryList(category);
        return getDataTable(list);
    }

    /**
     * 导出笔记分类列表
     */
    @PreAuthorize("@ss.hasPermi('im:category:export')")
    @Log(title = "笔记分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Category category)
    {
        List<Category> list = categoryService.selectCategoryList(category);
        ExcelUtil<Category> util = new ExcelUtil<Category>(Category.class);
        util.exportExcel(response, list, "笔记分类数据");
    }

    /**
     * 获取笔记分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('im:category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(categoryService.selectCategoryById(id));
    }

    /**
     * 新增笔记分类
     */
    @PreAuthorize("@ss.hasPermi('im:category:add')")
    @Log(title = "笔记分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Category category)
    {
        return toAjax(categoryService.insertCategory(category));
    }

    /**
     * 修改笔记分类
     */
    @PreAuthorize("@ss.hasPermi('im:category:edit')")
    @Log(title = "笔记分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Category category)
    {
        return toAjax(categoryService.updateCategory(category));
    }

    /**
     * 删除笔记分类
     */
    @PreAuthorize("@ss.hasPermi('im:category:remove')")
    @Log(title = "笔记分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(categoryService.deleteCategoryByIds(ids));
    }
}
