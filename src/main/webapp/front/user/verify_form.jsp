<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 联大旧书屋网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
	    <script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>

		<div class="login_step">
			注册步骤: 1.填写信息 >
			<span class="red_bold">2.验证邮箱</span> > 3.注册成功
		</div>
		<form action="${pageContext.request.contextPath}/user/active" method="post">
			<div class="validate_email">
				<h2>
					感谢您注册联大旧书屋网！现在请按以下步骤完成您的注册!
				</h2>
				<div class="look_email">
					<h4>
						第一步：查看您的电子邮箱
					</h4>
					<div class="mess reduce_h">
						我们给您发送了验证邮件，邮件地址为：
						<span class="red"><span id="lblEmail">${user.email }</span>
						</span>
						<span class="t1"></span> 
						请登录您的邮箱收信。
					</div>
					<h4>
						第二步：输入验证码:${activeCode }<span style="color:red; margin-left: 100px;">${message }</span>
						
					</h4>
					<div class="mess">
						<span class="write_in">输入您收到邮件中的验证码：</span>
						<input name="code" onblur="checkCode()" type="text" id="validatecode" class="yzm_text" />
						
						<input class="finsh" type="submit" value="完 成" id="Button1" />
						
						<span id="errorMsg" class="no_right"></span>
						<script>
						function checkCode(){
							var code = $("#validatecode").val();											
							if(code == ""){
								$("#errorMsg").html("<img width='15px' src='${pageContext.request.contextPath}/front/images/wrong.gif'/>   <font color='red'>请输入验证码！</font>");
												
								return false;
							}else{
								return true;
							}
						};
						</script>
					</div>
				</div>
			</div>
		</form>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>
