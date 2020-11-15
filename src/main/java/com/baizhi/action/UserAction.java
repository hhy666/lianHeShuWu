package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.imageio.ImageIO;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.SecurityCodeUtil;

public class UserAction {
	private User user;
	private String userId;
	private List<User>users;
	private String code;
	private String message;
	
	private UserService userService = new UserServiceImpl();
	
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
    
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
    
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String login(){
    	message =userService.login(user);
    	if("登录成功".equals(message)){
			return"loginOk";
		}
		return"loginError";
    }
	public String addUser(){
		message = userService.registUser(user, code);
		
		if("注册成功".equals(message)){
			
			return"addUserOk";
		}
		return"addUserError";
	}
	//生成激活码
	public String generate(){
		String activeCode = MD5Utils.getSalt();
		ServletActionContext.getRequest().getSession().setAttribute("activeCode",activeCode );
		return"generateOk";
	}
	//比对激活码
	public String active(){
		message = userService.active(code);
		if("比对成功".equals(message)){
			return "activeOk";
		}else{
			return"activeError";
		}
	}
	//验证码
	public void getImageCodes() throws Exception{
		//获取相应对象
		HttpServletResponse response = ServletActionContext.getResponse();
		//设置响应类型
		response.setContentType("image/png");
		//获取验证码随机字符
		String code = SecurityCodeUtil.generateVerifyCode(4);
		//将验证码存入session中
		ServletActionContext.getRequest().getSession().setAttribute("securityCode", code);
		//生成验证码图片
		BufferedImage image =SecurityCodeUtil.getImage(100, 40, code);
		ImageIO.write(image, "png", response.getOutputStream());
	}    
	//安全退出
	public String exit(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		session.invalidate();
		return"exitOk";
	}
	//调用service查询所有用户
	public String queryAllUser(){
		users = userService.queryAllUser();
		return"queryAllUserOk";
	}
	//修改状态
	public String updateUser(){
		userService.updateUser(user);
		return"updateOk";
	}
	public String queryUser(){
		user = userService.queryUser(userId);
		return "queryUserOk";
	}
}
