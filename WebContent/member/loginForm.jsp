<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/common.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LOGIN</h1>
<div class="loginForm">
<form action="LoginServlet" method="post">
<table class="id_pw">
	<tr><th>아이디</th><td><input type="text" name="userid"></td></tr>
	<tr><th>비밀번호</th><td><input type="text" name="passwd"></td></tr>
</table>
<div>
<a href="IdFindUIServlet">아이디 찾기</a>
<a href="memberForm.jsp">회원가입</a><br><br>
</div>
<input type="submit" value="로그인" class="login_btn">
</form>
</div>

</body>
</html>