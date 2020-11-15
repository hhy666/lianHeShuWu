package com.baizhi.action;

import java.awt.image.BufferedImage;

import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.service.AdminServiceImpl;

import com.baizhi.util.SecurityCodeUtil;


public class AdminAction  {
   private String username;
   private String password;
   private String code;
   private String message;
	public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
	public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
	public String queryAll(){
		AdminService ad = new AdminServiceImpl();
		List<Admin> all = ad.getAll();
		for (Admin admin : all) {
			System.out.println(admin);
		}
		return "queryAll";
	}
	//登录
	public String login(){
		
		AdminService adm = new AdminServiceImpl();
		message = adm.login(username, password,code);
		if("登录成功".equals(message)){
			return"loginOk";
		}
		return"loginError";
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
		ServletActionContext.getRequest().getSession()
		.setAttribute("securityCode", code);
		//生成验证码图片
		BufferedImage image =SecurityCodeUtil.getImage(100, 40, code);
		ImageIO.write(image, "png", response.getOutputStream());
	}
	//安全退出
	public String exit(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		session.invalidate();
		return"exit";
	}
	
}
