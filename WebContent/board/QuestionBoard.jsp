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
      검색<select name="searchName">
       <option value="author">작성자</option>
       <option value="title">제목</option>
      </select>
      <input type="text" name="searchValue">
      <input type="submit" value="검색">
      </form>
    </td>
   </tr>
 
 
   <tr>
     <td>글번호</td>
     <td>제목</td>
     <td>작성자</td>
     <td>작성일</td>
   
   </tr>
<%
	List<QuestionBoardDTO> list = 
         (List<QuestionBoardDTO>)request.getAttribute("list");
    for(QuestionBoardDTO dto : list){
%> 
   <tr>
     <td><%= dto.getQuestion_num() %></td>
     <%-- <td><a href='MyBoardRetrieveServlet?num=<%= dto.getNum() %>'><%= dto.getTitle()%></a> </td> --%>
     <td><%= dto.getTitle() %></td>
     <td><%= dto.getUserid() %></td>
     <td><%= dto.getWriteday() %></td>
   </tr>
<%
    }//end for
%> 
 </table>
 <a href="">글쓰기화면</a>
</body>
</html>


