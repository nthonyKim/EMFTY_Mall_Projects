<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${!empty success}">
		<script type="text/javascript">
			alert("${success}");
			//alert는 따옴표가 없으면 변수로 인식하기 때문에 따옴표로 묶어준다
		</script>
	</c:if>
	<c:if test="${!empty mesg}">
		<script type="text/javascript">
			alert("${mesg}");
			<%
			session.removeAttribute("mesg");
			%>
		</script>
	</c:if>	

<div class="side"><jsp:include page="common/side.jsp" flush="true"/></div>
<div class="body">
	<div class="top"><jsp:include page="common/top.jsp" flush="true"/></div>
	<div class="contents"><jsp:include page="main.jsp" flush="true"/></div>
</div>
