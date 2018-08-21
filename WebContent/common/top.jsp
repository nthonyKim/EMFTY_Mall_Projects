<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>        

<div class="topmenu">
	<ul>
		<li>search</li>
		<li><a href="CartUIServlet"><img src="images/icon/cart.png"></a></li>
<c:if test="${empty login}">
		<li><a href="LoginUIServlet"><img src="images/icon/user.png"></a></li>
</c:if>
<c:if test="${!empty login}">
		<li><a href="MypageServlet"><img src="images/icon/user.png"></a></li>
		<li><a href="LogoutUIServlet"><img src="images/icon/logout.png"></a></li>
</c:if> 
	</ul>
</div>