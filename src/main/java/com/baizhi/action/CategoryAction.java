package com.baizhi.action;

import java.util.List;



import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.service.CategoryServiceImpl;

public class CategoryAction {
    private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	private List<Category>list;
	public List<Category> getList() {
		return list;
	}

	public void setList(List<Category> list) {
		this.list = list;
	}
	private String categoryId;
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	private CategoryService ca = new CategoryServiceImpl();
	public String queryAll(){
		 list = ca.queryAll();
		return "queryOk";
	}
	public String addSecondCategory(){
		list = ca.queryAllFirst();
		return "queryFirstOk";
	}
	public String addSecond(){
		ca.addSecondCategory(category);
		System.out.println(category);
		return"addOk";
	}
	public String deleteOne(){
		ca.dorpCategory(categoryId);
		return"deleteOk";		
	}
	public String addFirst(){
		ca.addFirstCategory(category);
		return"addFirstOk";
	}
}
