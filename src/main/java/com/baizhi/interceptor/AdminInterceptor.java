package com.baizhi.interceptor;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Admin;
import com.baizhi.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AdminInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Admin admin =(Admin)ServletActionContext.getRequest().getSession().getAttribute("admin");
		if(admin != null){
			invocation.invoke();
		}
			//没有登录
			return"relogin";
		
	}
}
