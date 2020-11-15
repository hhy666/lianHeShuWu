<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach var="n" items="${newBook }">
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath}/main/queryOne?bookId=${n.bookId}" target='_blank'>
				<img class="images" src="${pageContext.request.contextPath}/back/img/${n.cover}" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath}/main/queryOne?bookId=${n.bookId}" target="_blank">${n.name }</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${n.price}
		</div>
		<div class="price">
			书屋价：￥${n.dprice }
		</div>
		<div class="price">
			销量：<font color="red">${n.ale }</font>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>