<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <script type="text/javascript" src="js/jquery-3.1.0.js"></script>

	<c:if test="${!empty mesg}">
		<script type="text/javascript">
			alert("${mesg}");
			<%
			System.out.println(session.getAttribute("mesg"));
			session.removeAttribute("mesg");
			%>
		</script>
	</c:if>	
<link rel="stylesheet" type="text/css" href="css/common.css" />
<div class="wrap">
<div class="side"><jsp:include page="common/submenu.jsp" flush="true"/></div>
<div class="body">
	<div class="top"><jsp:include page="common/top.jsp" flush="true"/></div>
	<div class="contents"><jsp:include page="member/idFind.jsp" flush="true"/></div>
</div>
</div>