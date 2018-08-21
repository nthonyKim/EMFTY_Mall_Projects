<%@page import="com.dto.NoticeDTO"%>
<%@page import="com.dao.NoticeDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <table border="1">
 

 
   <tr>
   <td>글번호</td>
      <td>제목</td>
         <td>내용</td>
            <td>작성일</td>
                         <tr>
   <td colspan="5"> <hr></td></tr>
 
 
<%
    List<NoticeDTO> list = 
         (List<NoticeDTO>)request.getAttribute("list");
    for(NoticeDTO dto : list){

%> 
   <tr>
     <td><%= dto.getSeq()%></td>
     <td><%= dto.getTitle()%></td>
      <td><%= dto.getContent()%></td>
        <td><%= dto.getReg_dts()%> </td> 
</tr>
   <tr>
   <td colspan="5"> <hr></td></tr>

     

<%
    }//end for
%> 
 </table>
 <button class="btn gray small" onclick="">관리(insert-sys전용 구현)</button>
</body>
</html>


