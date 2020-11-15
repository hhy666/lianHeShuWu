package com.baizhi.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.util.MybatisUtils;

public class AdminServiceImpl implements AdminService {

	@Override
	public String login(String username, String password,String code) {
		    AdminDao dao =MybatisUtils.getSqlSession().getMapper(AdminDao.class);
		    Admin queryAdminByUsername = dao.queryAdminByUsername(username);
		    String message;
		    //session中查询出的验证码
		    String sessionCode =(String) ServletActionContext.getRequest()
		    		.getSession().getAttribute("securityCode");
		    if(code.equalsIgnoreCase(sessionCode)){
		    	if(queryAdminByUsername==null){
		    	    message = "用户名不存在";
		        }else if(password.equals(queryAdminByUsername.getPassword())){
		        	ServletActionContext.getRequest().getSession()
		        	.setAttribute("admin", queryAdminByUsername);
		    	    message = "登录成功";
		        }else{
		    	    message="密码错误";
		        }
		    }else{
		    	message="验证码错误";
		    }
		    MybatisUtils.close();
	        return message;
	 }
	

	@Override
	public List<Admin> getAll() {
		AdminDao dao =MybatisUtils.getSqlSession().getMapper(AdminDao.class);
		List<Admin> admins = dao.queryAll();
		MybatisUtils.close();
		return admins;
	}
    
}
