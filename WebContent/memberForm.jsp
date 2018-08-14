<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.js"></script>
</head>
<body>
<div class="side"><jsp:include page="common/submenu.jsp" flush="true"/></div>
<div class="body">
	<div class="top"><jsp:include page="common/top.jsp" flush="true"/></div>
	<div class="contents"><jsp:include page="member/memberForm.jsp" flush="true"/></div>
</div>
</body>
</html>
