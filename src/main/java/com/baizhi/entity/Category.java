package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
    private String categoryId;
    private String name;
    private String parentId;
    private Integer levels;
    private Category category;
    private List<Category>categories;
    private List<Book>books;
	public Category() {
		super();
	}
	public Category(String categoryId, String name, String parentId,
			Integer levels, Category category, List<Category> categories, List<Book>books) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.parentId = parentId;
		this.levels = levels;
		this.category = category;
		this.categories = categories;
		this.books = books;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Integer getLevels() {
		return levels;
	}
	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name
				+ ", parentId=" + parentId + ", levels=" + levels
				+ ", category=" + category + ", categories=" + categories + ",books="+books+"]";
	}
	
}	