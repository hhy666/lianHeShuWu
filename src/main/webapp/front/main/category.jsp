<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
         <c:forEach var ="c1" items="${categories}">
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='${pageContext.request.contextPath}/main/querySecond?pid=${c1.categoryId}&page=1'>${c1.name }</a>]
				</h3>
				<ul class="ul_left_list">

						<!--2级分类开始-->
					<c:forEach var="c2" items="${c1.categories}">
						<li>
							<a href='${pageContext.request.contextPath}/main/querySecond?pid=${c1.categoryId}&cid=${c2.categoryId}&page=1'>${c2.name }</a>
						</li>
						
					</c:forEach>
						<!--2级分类结束-->

				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
		</c:forEach>
		<!--1级分类结束-->
		


		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
