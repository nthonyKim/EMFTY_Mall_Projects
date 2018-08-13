<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>        
    
<c:if test="${empty login}">
  <a href="">로그인</a>
  <a href="">회원가입</a>
</c:if>   
<c:if test="${! empty login}">
  ${login.username}님!&nbsp;
  <a href="">로그아웃</a>
  <a href="">MyPage</a>
  <a href="">장바구니</a>
</c:if>     
=======
<div class="topmenu">
	<ul>
		<li>search</li>
		<li><a href="CartUIServlet">CART</a></li>
		<li><a href="MemberUIServlet">USER</a></li>
	</ul>
</div>
>>>>>>> refs/heads/nthony
