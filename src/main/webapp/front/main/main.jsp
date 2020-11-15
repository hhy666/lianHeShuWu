<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>联合旧书屋网 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
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
	            /*  $("a[href='#']").click(function(){
	              location.href="${pageContext.request.contextPath}/main/queryOne?bookId=${book.bookId}";
	            })  */
	        })
	    </script>
	</head>
	<body>
		&nbsp;
		<!-- 头部开始 -->
		 <%@include file="../common/head.jsp"%> 
		 <%-- <jsp:include page="/front/common/head.jsp"></jsp:include> --%>
		<!-- 头部结束 -->
		<div style="width: 962px; margin: auto;">			<a href="#" target="_blank"><img
					src="${pageContext.request.contextPath}/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
			    <%@include file="../main/category.jsp"%> 
               <%-- <jsp:include page="/front/main/category.jsp"></jsp:include> --%>
			</div>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--推荐图书开始-->
				<div class=second_c_border1 id="recommend">
				    <%@include file="../main/recommend.jsp"%> 
                   <%--  <jsp:include page="/front/main/recommend.jsp"></jsp:include> --%>
				</div>

				<!--推荐图书结束-->

				<!--热销图书开始-->
				<div class="book_c_border2" id="hot">
				     <%@include file="../main/hot.jsp"%> 
				    <%-- <jsp:include page="/front/main/hot.jsp"></jsp:include> --%>
				</div>
				<!--热销图书结束-->

				<!--最新上架图书开始-->
				<div class="book_c_border2" id="new">
				    <%@include file="../main/new.jsp"%> 
				    <%-- <jsp:include page="/front/main/new.jsp"></jsp:include> --%>
				</div>

				<!--最新上架图书结束-->

				<div class="clear">
				</div>
			</div>
			<!--中栏结束-->



			<!--右栏开始-->
			<div class="book_right">
				<div class="book_r_border2" id="__XinShuReMai">
					<div class="book_r_b2_1x" id="new_bang">
						<div id="NewProduct_1_o_t" onmouseover="">
	                        <jsp:include page="/front/main/hotBoard.jsp"></jsp:include> 
	                        <%-- <%@include file="../main/hotBoard.jsp"%>  --%>
						</div>
					</div>
				</div>
			</div>
			<!--右栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		 
		 <%@include file="../common/foot.jsp"%>
		<%--  <jsp:include page="/front/common/foot.jsp"></jsp:include> --%>
		<!--页尾结束 -->
	</body>
</html>
