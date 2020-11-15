package com.baizhi.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService;
import com.baizhi.service.BookServiceImpl;

public class BookAction {
	private List<Category>categories;
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	private  Book book;
    private List<Book> books;
    private String bookId;
    private String name;
    private File cover;
    private String coverFileName;
    private String key;
    private String content;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public File getCover() {
		return cover;
	}
	public void setCover(File cover) {
		this.cover = cover;
	}
	public String getCoverFileName() {
		return coverFileName;
	}
	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	private BookService bo = new BookServiceImpl();
	
	public String showAll(){
		books = bo.queryAll();
		return"showAllOk";
	}
	public String deleteOne(){
		bo.dorpBook(name);
		return"deleteOk";
	}
	public String querySecondAll(){
		HttpServletRequest request = ServletActionContext.getRequest();
		categories=bo.queryAllSecond();
		HttpSession session = request.getSession();
		session.setAttribute("categories", categories);
		return"querySecondOk";
	}
	public String queryOne(){
		HttpServletRequest request = ServletActionContext.getRequest();
		categories=bo.queryAllSecond();
		 book = bo.queryOneBook(bookId);
		 HttpSession session = request.getSession();
		session.setAttribute("categories", categories);
		session.setAttribute("book", book);
		return"queryOneOk";
	}
	public String updateOne(){
		bo.changeBook(book, cover, coverFileName);
		System.out.println(book);
		return"updateOk";
	}
	public String addOne(){
		HttpServletRequest request = ServletActionContext.getRequest();
		categories=bo.queryAllSecond();
		HttpSession session = request.getSession();
		session.setAttribute("categories", categories);
		bo.rigestBook(book, cover, coverFileName);
		return"insertOk";
	}
	public String fuzzyQuery(){
		books = bo.fuzzyQuery(key, content);
		return"fuzzyQueryOk";
	}
 }
