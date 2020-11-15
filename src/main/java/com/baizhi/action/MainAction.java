package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService;
import com.baizhi.service.BookServiceImpl;
import com.baizhi.service.CategoryService;
import com.baizhi.service.CategoryServiceImpl;

public class MainAction {
	private String bookId;
	private Book book;
	private List<Book>books;
	private Category category;
	private String categoryId;
	private List<Book> recommend;
	private List<Book> hotBook;
	private List<Book> newBook;
	private List<Book> hotBoard;
	private List<Category> categories;
	private String pid;
	private String cid;
	private Integer page;
	private Integer total;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	private CategoryService categoryService = new CategoryServiceImpl();
	private BookService bookService = new BookServiceImpl();
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
    public List<Book> getRecommend() {
		return recommend;
	}
	public void setRecommend(List<Book> recommend) {
		this.recommend = recommend;
	}
	
	public List<Book> getHotBook() {
		return hotBook;
	}
	public void setHotBook(List<Book> hotBook) {
		this.hotBook = hotBook;
	}
	public List<Book> getNewBook() {
		return newBook;
	}
	public void setNewBook(List<Book> newBook) {
		this.newBook = newBook;
	}
	public List<Book> getHotBoard() {
		return hotBoard;
	}
	public void setHotBoard(List<Book> hotBoard) {
		this.hotBoard = hotBoard;
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String main(){
		//获得左栏级别分类
		categories = categoryService.queryAllOnFront();
    	//获得中栏编辑推荐集合
    	recommend = bookService.queryRecommend();
    	//获得中栏热销图书集合
    	hotBook = bookService.queryHotBook();
    	//获得中栏新书上架集合
    	newBook = bookService.queryNewBook();
    	//获得右栏新书热卖集合
    	hotBoard = bookService.queryHotBoard();
    	return"mainOk";
    }
	public String queryOne(){
		book = bookService.queryOneBook(bookId);
		 //System.out.println(book);
		return"queryOneOk";
	}
	public String querySecond(){
		//获得一级分类对象
		category = categoryService.queryFirst(pid);
		//获得当前分类下的所有图书(一级和二级)
		books = bookService.querySecond(pid, cid,page);
		//获得总页数
		total = bookService.queryPages(pid, cid);
		return"querySecondOk";
	}
}
