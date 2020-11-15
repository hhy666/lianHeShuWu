package com.baizhi.dao;

import java.util.List;


import com.baizhi.entity.Category;

public interface CategoryDao {
	//查询所有类别
    public List<Category>selectAll();
    //添加一级类别
    public void insertFirst(Category c);
    //删除类别
    public void deleteCategory(String categoryId);
    //查询所有一级类别
    public List<Category>selectFirst();
    //添加二级类别
    public void insertSecond(Category c);
    //查询级别
    public Integer selectLevels(String categoryId);
    //查询父级别
    public List<Category> selectParentId(String categoryId);
    //查询前台首页级别分类
    public List<Category> selectAllOnFront();
    //通过一级分类id获得当前一级分类对象
    public Category selectFirstOnId(String pid);
}
