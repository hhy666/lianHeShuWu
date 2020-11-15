package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.User;

public interface UserService {
	//用户登录
	 public String login(User user);
	 //注册用户
	 public String registUser(User user,String code);
	 //激活码比对
	 public String active(String code);
	 //查询所有用户
	 public List<User> queryAllUser();
	 //修改用户状态
	 public void updateUser(User user);
	 public User queryUser(String userId);
	 
	
}
