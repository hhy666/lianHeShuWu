package com.baizhi.util;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils{
	
	private static SqlSessionFactory sqlSessionFactory = null;
	private static final ThreadLocal<SqlSession> tol = new ThreadLocal<SqlSession>();
	
	static{
		try {
			Reader resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	获取sqlSession
	public static SqlSession getSqlSession(){
		SqlSession sqlSession = tol.get();
		if(sqlSession == null){
			sqlSession = sqlSessionFactory.openSession();
			tol.set(sqlSession);
		}
		return sqlSession;
	}
	
//	关闭sqlSession
	public static void close(){
		SqlSession sqlSession = tol.get();
		if(sqlSession != null){
			sqlSession.close();
			tol.remove();
		}
	}
	
//	提交事务
	public static void commit(){
		getSqlSession().commit();
		close();
	}
	
//	事务回滚
	public static void rollback(){
		getSqlSession().rollback();
		close();
	}
	
}
