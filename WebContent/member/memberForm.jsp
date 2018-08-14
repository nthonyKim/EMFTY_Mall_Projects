<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="MemberAddServlet" method="post">
<div class="member">
	<div>
		<table border="1">
		<tr><td>아이디</td>
			<td><input type="text" name="userid"></td></tr>
		<tr><td>비밀번호</td>
			<td><input type="text" name="userpasswd1"></td></tr>
		<tr><td>비밀번호 확인</td>
			<td><input type="text" name="userpasswd2"></td></tr>
		<tr><td>이름</td>
			<td><input type="text" name="username"></td></tr>
		<tr><td><input type="text" name="post" id="sample4_postcode" placeholder="우편번호"></td>
			<td><input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"></td></tr>
		<tr><td><input type="text" name="addr1" id="sample4_roadAddress" placeholder="도로명주소"></td>
			<td><input type="text" name="addr2" id="sample4_jibunAddress" placeholder="지번주소"></td></tr>
		<tr><td>휴대폰</td>
			<td><select name="phone1">
				<option value="011">011</option> 
				<option value="010">010</option> 
			</select></td>
			<td>	<input type="text" name="phone2"></td>
			<td><input type="text" name="phone3"></td>
			
		
		
		
		</tr>
		
		
		</table>
	</div>




</div>
</form>

</body>
</html>