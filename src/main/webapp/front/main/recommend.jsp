<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	<c:forEach var="r" items="${recommend }">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='${pageContext.request.contextPath}/main/queryOne?bookId=${r.bookId}' target='_blank'>
					<img class="images" src="${pageContext.request.contextPath}/back/img/${r.cover}" width=70 border=0 /> 
				</a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='${pageContext.request.contextPath}/main/queryOne?bookId=${r.bookId}' target='_blank' title='书名'>${r.name }</a>
				</h3>
				<h4>
					作者：${r.author } 著
					<br />
					出版社：${r.press }&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：<fmt:formatDate value="${r.pressDate }" pattern="yyyy-MM-dd"/>
				</h4>
				<h5>
					${r.contentAbstract }
				</h5>
				<h6>
					定价：￥${r.price }&nbsp;&nbsp;
					书屋价：￥${r.dprice }
					销量：<font color="red">${r.ale }</font>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
	</c:forEach>		
	</div>
</div>
