package com.baizhi.service;

import java.io.File;
import java.util.List;
import java.util.UUID;



import org.apache.commons.io.FileUtils;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.BookDao;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.util.MybatisUtils;

public class BookServiceImpl implements BookService {

	@Override
	public List<Book> queryAll() {
		BookDao dao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		List<Book> books = dao.selectAll();
		for (Book book : books) {
			System.out.println(book);
		}
		MybatisUtils.close();
		return books;
	}

	@Override
	public void dorpBook(String name) {
		try{
		    BookDao dao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		    if(name != null){
		    	 dao.deleteBook(name);
		    	 MybatisUtils.commit();
		    }
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtils.rollback();
		}finally{
			MybatisUtils.close();
		}
	}

	@Override
	public Book queryOneBook(String bookId) {
		
		BookDao dao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		Book queryBookById = dao.queryBookById(bookId);
		System.out.println(queryBookById);
		MybatisUtils.close();
		return queryBookById;
	}

	@Override
	public List<Category> queryAllSecond() {
		BookDao dao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
	    List<Category> selectSecond = dao.selectSecond();
	    MybatisUtils.close();
	    return selectSecond;
	}

	@Override
	public void changeBook(Book book,File cover,String coverFileName) {
		BookDao dao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		String realPath = ServletActionContext.getServletContext().getRealPath("back/img");
		File file = new File(realPath);
		Book book1 = dao.queryBookById(book.getBookId());
		if(!file.exists()){
			file.mkdir();
		}
		try{
			FileUtils.copyFile(cover, new File(realPath,coverFileName));
		   
		    book.setCover(coverFileName);
		    book.setAle(book1.getAle());
		    dao.updateBook(book);
		    MybatisUtils.commit();
		  
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtils.rollback();
			
		}finally{
			MybatisUtils.close();
			
		}
	}

	@Override
	public void rigestBook(Book book,File cover,String coverFileName) {
		String id;
			//执行文件上传
		String realPath = ServletActionContext.getServletContext().getRealPath("back/img");
		File file = new File(realPath);
		if(!file.exists()){
			file.mkdir();
		}
		try{	
            FileUtils.copyFile(cover, new File(realPath,coverFileName));
		    BookDao dao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		    id = UUID.randomUUID().toString();
		    book.setBookId(id);
		    book.setCover(coverFileName);
		    book.setAle(0);
		    dao.insertBook(book);
		    MybatisUtils.commit();
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtils.rollback();
		}finally{
			MybatisUtils.close();
		}
	}

	@Override
	public List<Book> fuzzyQuery(String key, String content) {
		 BookDao dao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		 List<Book> books = dao.fuzzySelectBook(key, content);
		 MybatisUtils.close();
		return books;
	}

	@Override
	public List<Book> queryRecommend() {
		 BookDao dao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		 List<Book> selectRecommend = dao.selectRecommend();
		 for (Book book : selectRecommend) {
			System.out.println(book);
		}
		 MybatisUtils.close();
		return selectRecommend;
	}

	@Override
	public List<Book> queryHotBook() {
		BookDao dao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		List<Book> selectHotBook = dao.selectHotBook();
		MybatisUtils.close();
		return selectHotBook;
	}

	@Override
	public List<Book> queryNewBook() {
		BookDao dao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		List<Book> selectNewBook = dao.selectNewBook();
		MybatisUtils.close();
		return selectNewBook;
	}

	@Override
	public List<Book> queryHotBoard() {
		BookDao dao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		List<Book> selectHotBoard = dao.selectHotBoard();
		MybatisUtils.close();
		return selectHotBoard;
	}

	@Override
	public List<Book> querySecond(String pid, String cid,Integer page) {
		BookDao dao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		//每页开始行数======(页数 - 1)*每页总行数+1
		Integer begin = (page - 1)*3+1;
		//每页结束行数=====每页开始行数+每页总行数-1
		Integer end = begin + 2;
		if(cid == null|| cid.equals("")){
			//当前点击的是一级类别,调用一级所有图书
			List<Book> selectFirst = dao.selectFirst(pid, begin, end);
			MybatisUtils.close();
			return selectFirst;
		}else{
			//当前点击的是二级类别,调用二级图书
			List<Book> selectSecond = dao.selectSecondBook(cid, begin, end);
			MybatisUtils.close();
			return selectSecond;
	   }
	}

	@Override
	public Integer queryPages(String pid, String cid) {
		BookDao dao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		if(cid == null|| cid.equals("")){
			//当前点击的是一级类别图书总页数
			Integer records = dao.selectFirstRecords(pid);
			MybatisUtils.close();
			return records%3 == 0?records/3:records/3+1;
		}else{
			//当前点击的是二级类别图书总页数
			Integer records = dao.selectSecondRecords(cid);
			MybatisUtils.close();
			return records%3 == 0?records/3:records/3+1;
	   }
	}
}
