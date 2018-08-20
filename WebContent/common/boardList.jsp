<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쇼핑몰</h1>
<jsp:include page="top.jsp" flush="true" /><br> 
<jsp:include page="submenu.jsp" flush="true" />
<hr>

<table width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0" border="0">
				<tr>
					<td height="5" colspan="6"></td>
				</tr>
				<tr>
					<td height="1" colspan="6" bgcolor="CECECE"></td>
				</tr>
				<tr>
					<td height="10">SEQ</td>
					<td height="10">TITLE</td>
					<td height="10">CONTENT</td>
					<td height="10">REG_DTS</td>

				</tr>
    			<c:forEach var="dto" items="${boardList}" varStatus="status">	
    			<tr>
					<td>${dto.seq}</td>
					<td>${dto.title}</td>
					<td>${dto.content}</td>
					<td>${dto.regdts}</td>

				</tr>			
				</c:forEach>
			</table>
		</td>
	</tr>
	<tr>
		<td height="10">
	</tr>
</table>

</body>
</html>