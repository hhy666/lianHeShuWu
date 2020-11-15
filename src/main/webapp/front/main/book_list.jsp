<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>联合旧书屋网 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/list.css" rel="stylesheet" type="text/css" />
		<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/front/js/prototype-1.6.0.3.js"></script> --%>
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
	    <script>
	        $(function(){
	            $(".images").mouseover(function(e){
	                //获得 图片 src
	                var obj = "<img id ='bigImg' src='"+$(this).attr("src")+"'/>";
	                //添加到body标签中
	                $("body").append(obj);
	                //添加样式
	                $("#bigImg").css({
	                    //上下位置
	                    "top":e.pageY+10,
	                    //左右位置
	                    "left":e.pageX+10,
	                    //定位
	                    "position":"absolute",
	                    //大小
	                    "height":150
	                })
	            }).mouseout(function(e){
	                $("#bigImg").remove();
	            }).mousemove(function(e){
	                $("#bigImg").css({
	                    //上下位置
	                    "top":e.pageY+10,
	                    //左右位置
	                    "left":e.pageX+10,
	                    //定位
	                    "position":"absolute",
	                    //大小
	                    "height":150
	                }) 
	            })
	
	        })
	    </script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="${pageContext.request.contextPath}/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
		
			您现在的位置:&nbsp;
			<a href='#'>联合旧书屋网</a> &gt;&gt;
			<font style='color: #cc3300' ><strong >${category.name }</strong> </font>
			<c:forEach items="${category.categories }" var="ca">
			    <c:if test="${ca.categoryId eq cid }">&gt;&gt;<font style="color:blue">${ca.name }</font></c:if>
			</c:forEach>
		</div>
       
		<div class="book">
        
			<!--左栏开始-->
			
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
						
							<li>
								<div>
									<div class=second_fenlei>
										&middot;<a href="${pageContext.request.contextPath}/main/querySecond?pid=${pid}&page=1"><font <c:if test="${cid eq null or cid eq ''}">style="color:red"</c:if>>全部</font>&nbsp;</a>
									</div>
								</div>
							</li>
							
							<!--2级分类开始-->
							<c:forEach var="c" items="${category.categories }">
							<div class="clear"></div>
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
										<a href="${pageContext.request.contextPath}/main/querySecond?pid=${pid}&cid=${c.categoryId}&page=1"><font <c:if test="${c.categoryId eq cid}">style="color:red"</c:if>>${c.name }</font>&nbsp;</a>
									</div>
								</div>
							</li>
							
							<div class="clear"></div>
							</c:forEach>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							
							<div class='list_r_title_text3a'>
								<a name=link_page_next href="#">
								<c:if test="${page eq 1 }">
							        <img src='${pageContext.request.contextPath}/front/images/page_up_gray.gif' />
							    </c:if>
							    <c:if test="${page ne 1 }">
								    <a name=link_page_next href="${pageContext.request.contextPath}/main/querySecond?pid=${pid}&cid=${cid}&page=1">
									<img src='${pageContext.request.contextPath}/front/images/page_up.gif' /> 
								</a>
								</c:if> 
								</a>
							</div>
	
							<div class='list_r_title_text3a'>
								<c:if test="${page eq 1 }">
							        <img src='${pageContext.request.contextPath}/front/images/page_up_gray.gif' />
							    </c:if>
							    <c:if test="${page ne 1 }">
								<a name=link_page_next href="${pageContext.request.contextPath}/main/querySecond?pid=${pid}&cid=${cid}&page=${page-1}">
									<img src='${pageContext.request.contextPath}/front/images/page_up.gif' /> 
								</a>
								</c:if> 
							</div>
				
							<div class='list_r_title_text3b'>
								第${page }页/共${total}页
							</div>
							
							<div class='list_r_title_text3a'>
							    <c:if test="${page eq total}">
							        <img src='${pageContext.request.contextPath}/front/images/page_down_gray.gif' />
							    </c:if>
							    <c:if test="${page ne total }">
								<a name=link_page_next href="${pageContext.request.contextPath}/main/querySecond?pid=${pid}&cid=${cid}&page=${page+1}">
									<img src='${pageContext.request.contextPath}/front/images/page_down.gif' /> 
								</a>
								</c:if>
							</div>
			
							<div class='list_r_title_text3a'>
								<c:if test="${page eq total}">
							        <img src='${pageContext.request.contextPath}/front/images/page_down_gray.gif' />
							    </c:if>
							    <c:if test="${page ne total }">
								<a name=link_page_next href="${pageContext.request.contextPath}/main/querySecond?pid=${pid}&cid=${cid}&page=${total}">
									<img src='${pageContext.request.contextPath}/front/images/page_down.gif' /> 
								</a>
								</c:if>
							</div>

							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						
						<div class="list_r_line"></div>
						<c:forEach var="bo" items="${books }">
						<div class="clear"></div>
						
							<div class="list_r_list">
								<span class="list_r_list_book">
									<a name="link_prd_img" href='${pageContext.request.contextPath}/main/queryOne?bookId=${bo.bookId}'>
										<img class="images" src="${pageContext.request.contextPath}/back/img/${bo.cover }" /> 
									</a>
								</span>
								<h2>
									<a name="link_prd_name" href='${pageContext.request.contextPath}/main/queryOne?bookId=${bo.bookId}'>${bo.name }</a>
								</h2>
								<h3>
									顾客评分：100
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#' name='作者'>${bo.author }</a>
								</h4>
								<h4>
									出版社：
									<a href='#' name='出版社'>${bo.press }</a>
								</h4>
								<h4>
									出版时间：<fmt:formatDate value="${bo.pressDate }" pattern="yyyy-MM-dd"/>
								</h4>
								<h5>
									${bo.editorRecomment }
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥${bo.price }</span>
									<span class="red">￥${bo.dprice }</span>
									节省：${bo.price - bo.dprice }
								</h6>
								<span class="list_r_list_button"> 
								<a href="${pageContext.request.contextPath}/cart/addCart?bookId=${bo.bookId}"> 
									<img src='${pageContext.request.contextPath}/front/images/buttom_goumai.gif' /> 
								</a>
								<span id="cartinfo"></span>
							</div>
							
						<div class="clear"></div>
                         </c:forEach>
						
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
