<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>        
<script type="text/javascript">
$(document).ready(function(){
	$(".toggle").click(function(){
        $("#search").stop().animate({
        	width: 'toggle'        
        });
    });//
		
	$("#search").on("keypress",function(e){
		if (e.which == 13) {
			$("form").attr("action","GoodsAllServlet");
			$(this).submit();
		}
	})//
})

</script>
<div class="topmenu">
	<ul>
		<li>
	<form>
		<input type="text" name="search" id="search" placeholder="search..."><img src="./images/icon/search.png" class="toggle">
	</form>
		</li>
		<li><a href="GoodsCartListServlet"><img src="images/icon/cart.png"></a></li>
<c:if test="${empty login}">
		<li><a href="LoginUIServlet"><img src="images/icon/user.png"></a></li>
</c:if>
<c:if test="${!empty login}">
	<c:if test="${login.userid eq 'admin'}">
		<li><a href="AdminPageServlet"><img src="images/icon/user.png"></a></li>
	</c:if>
		<li><a href="MypageServlet"><img src="images/icon/user.png"></a></li>
		<li><a href="LogoutUIServlet"><img src="images/icon/logout.png"></a></li>
</c:if> 
	</ul>
</div>