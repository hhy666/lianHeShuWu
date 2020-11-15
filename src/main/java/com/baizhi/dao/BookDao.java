package com.baizhi.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;

public interface BookDao {
    public List<Book> selectAll();
    public void insertBook(Book book);
    public void updateBook(Book book);
    public void deleteBook(String name);
    public Book queryBookById(String bookId);
    public List<Category> selectSecond();
    public List<Book> fuzzySelectBook(@Param("type")String key,@Param("input")String content);
    public List<Book> selectRecommend();
    public List<Book> selectHotBook();
    public List<Book> selectNewBook();
    public List<Book> selectHotBoard();
    //通过pid查询当前一级类别下的图书
    public List<Book> selectFirst(@Param("pid")String pid,@Param("begin")Integer begin,@Param("end")Integer end);
    //通过cid查询当前二级类别下的图书
    public List<Book>  selectSecondBook(@Param("cid")String cid,@Param("begin")Integer begin,@Param("end")Integer end);
    //通过pid查询当前一级类别下的图书数量
    public Integer selectFirstRecords(String pid);
    //通过cid查询当前二级类别下的图书数量
    public Integer selectSecondRecords(String cid);
}
