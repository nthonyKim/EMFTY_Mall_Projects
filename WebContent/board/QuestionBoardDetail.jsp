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
       <div id="wrap" align="center">
       <h1>Question View </h1><pre></pre>
<table border="1">
 
   <tr>
    <td colspan="5">
    <form action="">
     검색<pre>   </pre><select name="searchName"> 
       <option value="author">작성자</option>
       <option value="title">제목</option>
      </select>
      <input type="text" name="searchValue">
      <input type="submit" value="검색">
      </form>
    </td>
   </tr>
 <td colspan="5"><hr></td></tr>
   <tr>
     <th>글번호</th>
     <th>제목</th>
     </tr>
     <tr>
     <td>작성자</td>

     
     <td>작성일</td>
   
   </tr><tr>
   <td colspan="5"><hr></td></tr>
<%
	List<QuestionBoardDTO> list = 
         (List<QuestionBoardDTO>)request.getAttribute("list");
    for(QuestionBoardDTO dto : list){
%> 
   <tr>
    <td><th><%= dto.getQuestion_num() %></th></td> 
     <td><th><%= dto.getTitle() %></th></td></tr>
     <tr>
     <td><%= dto.getUserid() %></td>
 
     <td><%= dto.getWriteday() %></td>
   </tr>
    <tr>
   <td colspan="5"> <hr></td></tr>
   
   
<%
    }//end for
%> 
 </table><pre></pre>
 <a href="">Back</a>
</body>
</html> 


