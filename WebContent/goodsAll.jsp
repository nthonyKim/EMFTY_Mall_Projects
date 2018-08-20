<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
</head>
<body>

<div class="side"><jsp:include page="common/submenu.jsp" flush="true"/></div>
<div class="body">
	<div class="top"><jsp:include page="common/top.jsp" flush="true"/></div>
	<div class="contents"><jsp:include page="goods/goodsAll.jsp" flush="true"/></div>
</div>

</body>
</html>