package com.ruoyi.im.service;

import java.util.List;
import com.ruoyi.im.domain.Category;

/**
 * 笔记分类Service接口
 * 
 * @author HK意境
 * @date 2023-05-28
 */
public interface ICategoryService 
{
    /**
     * 查询笔记分类
     * 
     * @param id 笔记分类主键
     * @return 笔记分类
     */
    public Category selectCategoryById(Long id);

    /**
     * 查询笔记分类列表
     * 
     * @param category 笔记分类
     * @return 笔记分类集合
     */
    public List<Category> selectCategoryList(Category category);

    /**
     * 新增笔记分类
     * 
     * @param category 笔记分类
     * @return 结果
     */
    public int insertCategory(Category category);

    /**
     * 修改笔记分类
     * 
     * @param category 笔记分类
     * @return 结果
     */
    public int updateCategory(Category category);

    /**
     * 批量删除笔记分类
     * 
     * @param ids 需要删除的笔记分类主键集合
     * @return 结果
     */
    public int deleteCategoryByIds(Long[] ids);

    /**
     * 删除笔记分类信息
     * 
     * @param id 笔记分类主键
     * @return 结果
     */
    public int deleteCategoryById(Long id);
}
