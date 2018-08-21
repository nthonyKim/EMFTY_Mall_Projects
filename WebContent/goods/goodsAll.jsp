<%@page import="com.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				border="0">
				
				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td height="1" colspan="8" bgcolor="CECECE"></td>
				</tr>
				<tr>
					<td height="10"></td>
				</tr>
				<tr>
    <c:forEach var="dto" items="${goodsAll}" varStatus="status">	
						<td>
							<table style='padding:15px'>
								<tr>
									<td>
										<a href="GoodsRetrieveServlet?goods_Code=${dto.goods_Code}"> 
											<img src="images/items/${dto.goods_Image1}.jpg" border="0" align="center" width="200">
										</a>
									</td>
								</tr>
								<tr>
								<td class= "td_default" align ="center">
										<a class= "a_black">
										${dto.goods_Brand}<br>
										</a>
										<font color="gray">
										 <br>
										</font>
									</td>
									<td height="10">
								</tr>
								<tr>
									<td class= "td_default" align ="center">
										<a class= "a_black" href="GoodsListServlet?goods_Code=${dto.goods_Code}"> 
										${dto.goods_Name}<br>
										</a>
										<font color="gray">
										 <br>
										</font>
									</td>
									
								</tr>
								<br>
								<tr>
								
									
								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_gray" align ="center">
										${dto.goods_Content}
									</td>
								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_red" align ="center"><font color="red"><strong>
									
					<fmt:formatNumber value="${dto.goods_Price}" type="currency"> </fmt:formatNumber>				
					<%-- ${dto.goods_Price} --%>
										</strong></font></td>
								</tr>
							</table>
						</td>

  					<c:if test="${(status.index+1)%4==0 }">
						     <tr>
								<td height="10">
							</tr>
                  </c:if>
</c:forEach>
			</table>
		</td>
	</tr>
	<tr>
		<td height="10">
	</tr>
</table>
