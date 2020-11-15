<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/btn.css" />
	</head>
	<body style="background-color: #f0f9fd;text-align: center;">
	
		<div style="font-size:25px">类别管理</div><hr/>
		<div style="margin-bottom: 10px;">
			<div class="button btn-p" onclick="location.href='${pageContext.request.contextPath}/back/category/add-first.jsp'">添加一级类别&raquo;</div>
			<div class="button btn-p" onclick="location.href='${pageContext.request.contextPath}/category/addSecondCategory'">添加二级类别&raquo;</div>
		</div>
		<table bordercolor='#898E90' align='center' border='3px' cellpadding='10px' cellspacing="0px" >
			<tr bgcolor='lightblue'>
				<td>Id</td>
				<td>类别名</td>
				<td>所属类别</td>
				<td>级别</td>
				<td>操作</td>
			</tr>
			<c:forEach var="ca" items="${list}">
			<tr>
				<td>${ca.categoryId }</td>
				<td>${ca.name }</td>
				<td>${ca.category.name}</td>
				<td>${ca.levels}</td>
				<td>
					<div class="button" onclick="location.href='${pageContext.request.contextPath}/category/deleteOne?categoryId=${ca.categoryId }' ">删除 &raquo;</div>	
				</td>
			</tr>
			</c:forEach>
			<!-- <tr>
				<td>1002</td>
				<td>小说</td>
				<td></td>
				<td>1</td>
				<td>
					<div class="button" onclick="location.href='' ">删除 &raquo;</div>	
				</td>
			</tr>
			<tr>
				<td>1003</td>
				<td>教育</td>
				<td></td>
				<td>1</td>
				<td>
					<div class="button" onclick="location.href='' ">删除 &raquo;</div>	
				</td>
			</tr>
			<tr>
				<td>1004</td>
				<td>古典小说</td>
				<td>小说</td>
				<td>2</td>
				<td>
					<div class="button" onclick="location.href='' ">删除 &raquo;</div>	
				</td>
			</tr>
			<tr>
				<td>1005</td>
				<td>近现代小说</td>
				<td>小说</td>
				<td>2</td>
				<td>
					<div class="button" onclick="location.href='' ">删除 &raquo;</div>	
				</td>
			</tr>
			<tr>
				<td>1005</td>
				<td>四大名著</td>
				<td>小说</td>
				<td>2</td>
				<td>
					<div class="button" onclick="location.href='' ">删除 &raquo;</div>	
				</td>
			</tr>
			 -->
			
		</table><br/>
		
	</body>  
</html>



