package com.baizhi.service;

import java.util.List;




import com.baizhi.entity.Category;

public interface CategoryService {
     public List<Category>queryAll();
     //查询所有一级类别
     public List<Category> queryAllFirst();
     //添加二级分类
     public String addSecondCategory(Category c);
     //删除分类
     public void dorpCategory(String categoryId);
     //添加一级分类
     public String addFirstCategory(Category c);
     //查询前台左栏分类
     public List<Category>queryAllOnFront();
     //获得一级分类对象
     public Category queryFirst(String pid);
}
