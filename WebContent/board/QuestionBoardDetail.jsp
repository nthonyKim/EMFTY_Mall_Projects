<%@page import="com.dto.QuestionBoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>th,td {padding:5px}
table{border-spacing:5px}
</style>

<meta charset="UTF-8">
<title>CSS</title>
<style>
table {
	width: 80%;
	border: 1px solid #444444;
	}
.a{
background-color: #fff;
}
</style>
</head>
<body>
   
       <h1>Question View </h1>
       <div id="QuestionView" background-color: #333
    height: 100px
    position: relative>

   <%
   QuestionBoardDTO dto = (QuestionBoardDTO)request.getAttribute("list");
   String Question_num= dto.getQuestion_num();
   String title = dto.getTitle();
   String userid = dto.getUserid();
   String Question_contents = dto.getQuestion_contents();
   String writeday = dto.getWriteday();
   String image_name = ""; 
	if(dto.getImage_name() != null){ image_name = dto.getImage_name(); }
	
%>


</div>
<!-- <table border="1">
 </table> -->
 
 <form>
<img src="images/banner_2.jpg"><br> 
 <input type="hidden" name="Question_num" value="<%= Question_num %>" id="Question_num"><br> 
<div class="content">
 	<table>
	
<tr> 
	<th><td>글번호</th> 
	<td><%= Question_num%></td>
</tr>	              		
<tr>
	<th>작성일</th>
	<td> <%= writeday %></td> 
</tr>
 <tr>
 	<th class="a">제목</th>
 	<td><%= title %></td>
 </tr>
 <tr>
	 <th>작성자 </th>
 	<td><%= userid %></td>
 </tr>
 <tr>
 	<td>내용</td>
 	<td><%= Question_contents %></td>
 </tr>
<%--  <tr><td>첨부이미지<%= image_name  %></td></tr> --%>

 <tr>
 	<td>이미지</td>
 	<td><img src="images/question/<%=image_name%>" border="10" width="200"></td>
 </tr>
 </table>
 </div>
<br> 
 <input type="submit" value="수정"> 
<br> 
  </form>
<!--   <a href="QuestionBoard_WirteUIServlet">글쓰기</a> -->
 <a href=""></a><!-- QuestionBoardUpdateServlet 불러와서 위 양식 그대로 'input'으로 부른뒤 mapper의 update의 기능 구현 -->
 <a href="QuestionBoardServlet">목록으로</a>
 <a href="">수정하기</a><!-- QuestionBoardUpdateServlet?해당코드->go -->
 </body>
<body>
<!-- form action으로 comment 테이블 insert 반복문이므로 table 형태-->
<!-- --------------------------------------------------------------------------------------------------- -->

<table border="1"> 
 
   <tr>
    <td colspan="5"></td>
   <tr>
	<td>코멘트 내용</td>
     <td>작성자</td>
     <td>작성일</td>
     <td>조회수</td>
   </tr>
 </table>
 <p>----------------------------------------------------------------------------------------------------------------------------</p>
<form>
commentor {#userid} 님 <br> 
comment <textarea cols="150" rows="3">댓글을 입력하세요.</textarea><br> 
<input type="submit" name="register" value="Register">
</form> 

<p>---------------------------------------------------------------------------------------------------------------------------</p>
<br>
<button bgcolor="white">글쓰기</button>
<button bgcolor="white">목록으로</button>
</body>
</html>



