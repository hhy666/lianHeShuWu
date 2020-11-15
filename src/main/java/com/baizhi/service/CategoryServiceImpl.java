package com.baizhi.service;

import java.util.List;
import java.util.UUID;






import com.baizhi.dao.BookDao;
import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.util.MybatisUtils;

public class CategoryServiceImpl implements CategoryService {
	@Override
	public List<Category> queryAll() {
		CategoryDao dao = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		List<Category> categories = dao.selectAll();
		MybatisUtils.close();
		return categories;
	}

	@Override
	public List<Category> queryAllFirst() {
		CategoryDao dao = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		List<Category> categories = dao.selectFirst();
		MybatisUtils.close();
		return categories;
	}

	@Override
	public String addSecondCategory(Category c) {
		String id;
		try{
		CategoryDao dao = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		 id = UUID.randomUUID().toString();
		 c.setCategoryId(id);
		 c.setLevels(2);
		 dao.insertSecond(c);
		MybatisUtils.commit();
		return id;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtils.rollback();
			return null;
		}finally{
			MybatisUtils.close();
		}
	}

	@Override
	public void dorpCategory(String categoryId) {
		try{
		    CategoryDao dao = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		    Integer selectLevels = dao.selectLevels(categoryId);
		    List<Category> selectParentId = dao.selectParentId(categoryId);
		    BookDao bookDao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		    if(selectLevels == 2 ){
		    	Integer num = bookDao.selectSecondRecords(categoryId);
		    	if(num == 0){
		    	    dao.deleteCategory(categoryId);
		    	    MybatisUtils.commit();
		    	}
		    }else if(selectLevels == 1 && selectParentId.size() == 0 ){
		    	dao.deleteCategory(categoryId);
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
	public String addFirstCategory(Category c) {
		String id;
		try{
		CategoryDao dao = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		 id = UUID.randomUUID().toString();
		 c.setCategoryId(id);
		 c.setLevels(1);
		 dao.insertFirst(c);
		MybatisUtils.commit();
		return id;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtils.rollback();
			return null;
		}finally{
			MybatisUtils.close();
		}
	}

	@Override
	public List<Category> queryAllOnFront() {
		CategoryDao dao = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		List<Category> selectAllOnFront = dao.selectAllOnFront();
		MybatisUtils.close();
		return selectAllOnFront;
	}

	@Override
	public Category queryFirst(String pid) {
		CategoryDao dao = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		 Category selectFirstOnId = dao.selectFirstOnId(pid);
		MybatisUtils.close();
		return selectFirstOnId;
	}

}
