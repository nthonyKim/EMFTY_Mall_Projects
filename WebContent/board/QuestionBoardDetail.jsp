<%@page import="com.dto.QuestionBoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   
       <h1>Question View </h1><pre></pre>
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
 	<table border="1" summary="">
	
<tr class="first"> 
	<th scope="row"><td>글번호</th> <td><%= Question_num%></td></tr>	              		
<tr>
	<th scope="row">작성일</th>
	<td> <%= writeday %></td> 
</tr>
 <tr>
 	<th scope="row">제목</th>
 	<td><%= title %></td>
 </tr>
 <tr>
	 <th scope="row">작성자 </th>
 	<td><%= userid %></td>
 </tr>
 <tr>
 	<td scope="row">내용</td>
 	<td><%= Question_contents %></td>
 </tr>
<%--  <tr><td>첨부이미지<%= image_name  %></td></tr> --%>

 <tr><td><img src="images/question/<%=image_name%>" border="0" width="300"></td></tr>
 </table>
 </div>
<br> 
 <input type="submit" value="수정"> 
<br> 
  </form>
<!--   <a href="QuestionBoard_WirteUIServlet">글쓰기</a> -->
 <a href=""></a><!-- QuestionBoardUpdateServlet 불러와서 위 양식 그대로 'input'으로 부른뒤 mapper의 update의 기능 구현 -->
 <a href="QuestionBoardServlet">목록으로</a>
 </body>
<body>
<!-- form action으로 comment 테이블 insert 반복문이므로 table 형태-->




<p>--기존 코멘트 셀렉(페이징필요)-</p>
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
<p>--------------------------------------------------------------------------------------------------------------------------</p>
<br>
<button bgcolor="white">글쓰기</button>
<button bgcolor="white">목록으로</button>
</body>
</html>



