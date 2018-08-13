<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){		
$("form").submit(function(event){
	var id = $("#userid").val();
	var name = $("#username").val();		
	if(id.length==0){
			alert("userid");
			$("#userid").focus();
			event.preventDefault();
	}else if(name.length==0){
			alert("username");
			$("#username").focus();
			event.preventDefault();				
		};
	});
});


</script>

<h1 align="center">LOGIN</h1>
<div class="login" align="center">
<form action="LoginServlet" method="post">
아이디<input type="text" name="userid"><br>
비밀번호<input type="text" name="passwd"><br>

<a href="IdFindUIServlet">아이디 찾기</a>
<a href="memberForm.jsp">회원가입</a><br><br>

<input type="submit" value="로그인" class="login_btn">
</form>
</div>

</body>
</html>