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

 <table border="1">

   <tr>
    <td colspan="5">
    <form action="">
     검색<pre>   </pre><select name="searchName"> 
       <option value="userid">작성자</option>
       <option value="title">제목</option>
      </select>
      <input type="text" name="searchValue">
      <input type="submit" value="검색">
      </form>
    </td>
   </tr>
</table>
<table class="tbl" border="1">

 <thead>
 <td colspan="5"><hr></td></tr>
   <tr>
     <th>글번호</th>
     <th>제목</th>
     <th>작성자</th>
     <th>작성일</th>
   </tr>
   </thead> 

<%
	List<QuestionBoardDTO> list = 
         (List<QuestionBoardDTO>)request.getAttribute("list");
    for(QuestionBoardDTO dto : list){
%> 
   <tr>
    <td><%= dto.getQuestion_num() %></td>
      <td><a href='QuestionBoardDetailServlet?Question_num=<%= dto.getQuestion_num() %>'><%= dto.getTitle()%></a> </td> 
    <%--  <td><%= dto.getTitle() %></td> --%>
     <td><%= dto.getUserid() %></td>
     <td><%= dto.getWirteday () %></td>
   </tr>
    <tr>

   
   
<%
    }//end for
%> 
 </table>
 <br> 
 <a href="QuestionBoardWriteUIServlet">질문하기</a>
</body>
</html>


