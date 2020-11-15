package com.baizhi.interceptor;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user =(User)ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user == null){
			//没有登录
			return"relogin";
		}else{
			if(user.getCode() == null){
			//没有激活
			return"reactive";
			}else{
				invocation.invoke();
			}
		}
		return null;
	}

}
