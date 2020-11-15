package com.baizhi.service;

import java.io.File;
import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;

public interface BookService {
    public List<Book> queryAll();
    public void dorpBook(String name);
    public Book queryOneBook(String bookId);
    public List<Category> queryAllSecond();
    public void changeBook(Book book,File cover,String coverFileName);
    public void rigestBook(Book book,File cover,String coverFileName);
    public List<Book> fuzzyQuery(String key,String content);
    public List<Book> queryRecommend();
    public List<Book> queryHotBook();
    public List<Book> queryNewBook();
    public List<Book> queryHotBoard();
    //查询前台二级页面的图书
    public List<Book> querySecond(String pid,String cid,Integer page);
    //查询前台二级页面图书总页数
    public Integer queryPages(String pid,String cid);
    
}
