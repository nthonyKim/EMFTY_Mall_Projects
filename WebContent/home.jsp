<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${! empty success}">
  <script type="text/javascript">
    alert('${success}');
    <%
    session.removeAttribute("success");
   %>
  </script>
</c:if>
<c:if test="${! empty mesg}">
  <script type="text/javascript">
    alert('${mesg}');
    <%
    session.removeAttribute("mesg");
   %>
  </script>
</c:if>
<h1>쇼핑몰</h1D>
<jsp:include page="common/top.jsp" flush="true" /><br> 
<jsp:include page="common/submenu.jsp" flush="true" />
<hr>
<img src="images/b_image_1" width="300" height="300" />
</body>
</html>