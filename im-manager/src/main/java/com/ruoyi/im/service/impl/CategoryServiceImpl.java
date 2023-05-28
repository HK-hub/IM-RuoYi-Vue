package com.ruoyi.im.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.im.mapper.CategoryMapper;
import com.ruoyi.im.domain.Category;
import com.ruoyi.im.service.ICategoryService;

/**
 * 笔记分类Service业务层处理
 * 
 * @author HK意境
 * @date 2023-05-28
 */
@Service
public class CategoryServiceImpl implements ICategoryService 
{
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询笔记分类
     * 
     * @param id 笔记分类主键
     * @return 笔记分类
     */
    @Override
    public Category selectCategoryById(Long id)
    {
        return categoryMapper.selectCategoryById(id);
    }

    /**
     * 查询笔记分类列表
     * 
     * @param category 笔记分类
     * @return 笔记分类
     */
    @Override
    public List<Category> selectCategoryList(Category category)
    {
        return categoryMapper.selectCategoryList(category);
    }

    /**
     * 新增笔记分类
     * 
     * @param category 笔记分类
     * @return 结果
     */
    @Override
    public int insertCategory(Category category)
    {
        category.setCreateTime(DateUtils.getNowDate());
        return categoryMapper.insertCategory(category);
    }

    /**
     * 修改笔记分类
     * 
     * @param category 笔记分类
     * @return 结果
     */
    @Override
    public int updateCategory(Category category)
    {
        category.setUpdateTime(DateUtils.getNowDate());
        return categoryMapper.updateCategory(category);
    }

    /**
     * 批量删除笔记分类
     * 
     * @param ids 需要删除的笔记分类主键
     * @return 结果
     */
    @Override
    public int deleteCategoryByIds(Long[] ids)
    {
        return categoryMapper.deleteCategoryByIds(ids);
    }

    /**
     * 删除笔记分类信息
     * 
     * @param id 笔记分类主键
     * @return 结果
     */
    @Override
    public int deleteCategoryById(Long id)
    {
        return categoryMapper.deleteCategoryById(id);
    }
}
