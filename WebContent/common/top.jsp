<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>        

<div class="topmenu">
	<ul>
		<li>search</li>
		<li><a href="CartUIServlet">CART</a></li>
<c:if test="${empty login}">
		<li><a href="LoginUIServlet">USER</a></li>
</c:if>
<c:if test="${!empty login}">
		<li><a href="MypageServlet">MYPAGE</a></li>
		<li><a href="LogoutUIServlet">LOGOUT</a></li>
</c:if> 
	</ul>
</div>