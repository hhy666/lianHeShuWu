package com.baizhi.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.MybatisUtils;

public class UserServiceImpl implements UserService {

	@Override
	public String login(User user) {
		UserDao dao = MybatisUtils.getSqlSession().getMapper(UserDao.class);
		User selectUserByEmail = dao.selectUserByEmail(user.getEmail());
		String message;
		if(selectUserByEmail == null){
			message ="用户不存在";
		}else if("冻结".equals(selectUserByEmail.getStatus())){
			message = "此用户已被冻结";	
		}else{
			String secretPassword = selectUserByEmail.getPassword();  
		    String salt = selectUserByEmail.getSalt();
			if(secretPassword.equals(MD5Utils.getPassword(user.getPassword()+salt))){
				ServletActionContext.getRequest().getSession().setAttribute("user", selectUserByEmail);
				message ="登录成功";
			}else{
				message ="密码错误";
			}
		}
		MybatisUtils.close();
		return message;
	}

	@Override
	public String registUser(User user, String code) {
		try{
			 //session中查询出的验证码
		    String sessionCode =(String) ServletActionContext.getRequest().getSession().getAttribute("securityCode");
		    UserDao dao = MybatisUtils.getSqlSession().getMapper(UserDao.class);
		    User selectUserByEmail = dao.selectUserByEmail(user.getEmail());
		    String message;
		    if(code.equalsIgnoreCase(sessionCode)){
		    	if(selectUserByEmail == null){
		    		String id = UUID.randomUUID().toString();
		 		    String salt = MD5Utils.getSalt();
		 		    String password = MD5Utils.getPassword(user.getPassword()+salt);
		 		    user.setUserId(id);
		 		    user.setSalt(salt);
		 		    user.setPassword(password);
		 		    user.setCreateDate(new Date());
		 		    user.setStatus("正常");
		 		    dao.insertUser(user);
		 		    ServletActionContext.getRequest().getSession().setAttribute("user", user);
		 		    message ="注册成功";
		    	}else{
		    		message = "此邮箱已被注册";
		    	}
		    }else{
		    	message ="验证码错误";
		    }
		    MybatisUtils.commit();
		    return message;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtils.rollback();
			return null;
		}finally{
			MybatisUtils.close();
		}
	}

	@Override
	public String active(String code) {
		User sessionUser = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		String sessionCode =(String)ServletActionContext.getRequest().getSession().getAttribute("activeCode");
		String message ="";
		try{
		     if(sessionCode.equals(code)){
				//比对成功,修改数据库字段,同时更新session中的用户登录标记
				User user = new User();
				user.setUserId(sessionUser.getUserId());
				user.setCode(code);
				UserDao dao = MybatisUtils.getSqlSession().getMapper(UserDao.class);
				dao.updateUser(user);
				//更新session
				sessionUser.setCode(code);
				ServletActionContext.getRequest().getSession().setAttribute("user", sessionUser);
				message ="比对成功";
				
			}else{
				message ="激活码错误";
			}
		     MybatisUtils.commit();
		     return message;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtils.rollback();
			return null;
		}
		
	}

	@Override
	public List<User> queryAllUser() {
		UserDao dao = MybatisUtils.getSqlSession().getMapper(UserDao.class);
		List<User> selectAllUser = dao.selectAllUser();
		MybatisUtils.close();
		return selectAllUser;
	}

	@Override
	public void updateUser(User user) {
		try {
			UserDao dao = MybatisUtils.getSqlSession().getMapper(UserDao.class);
			User selectUserByUserId = dao.selectUserByUserId(user.getUserId());
			if("正常".equals(selectUserByUserId.getStatus())){
				user.setStatus("冻结");
			}else{
				user.setStatus("正常");
			}
			dao.updateUser1(user);
			MybatisUtils.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			MybatisUtils.rollback();
		}
	}

	@Override
	public User queryUser(String userId) {
		UserDao dao = MybatisUtils.getSqlSession().getMapper(UserDao.class);
		User selectUserByUserId = dao.selectUserByUserId(userId);
		MybatisUtils.close();
		return selectUserByUserId;
	}
	

}
