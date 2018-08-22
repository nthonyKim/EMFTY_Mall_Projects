<%@page import="com.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="adsense" style="text-align: center; padding:0px 0px 10px 10px"> 

<table cellpadding="0" cellspacing="0" table width="100%">
<tr>
	<td width="50%">
	<img src="images/banner_image.jpg" align=top>
	</td>
	<td width="50%"></td>
</table>

<script type="text/javascript">
	$(document).ready(function(){
		$(".sortBox > button").on("click", function(){
			$(".box").stop().slideToggle("300");
		})
	})
</script>
<div class="sortBox">
	<button type="button">sort</button>
	<div class="box">
		<div>
			색상 : 
			<span><input type="checkbox" id="check1" name="check"> <label for="check1">가</label></span>
			<span><input type="checkbox" id="check2" name="check"> <label for="check2">나</label></span>
			<span><input type="checkbox" id="check3" name="check"> <label for="check3">다</label></span>
		</div>
		
		<div>
			브랜드 :
			<span><input type="checkbox" id="check4" name="check"> <label for="check4">라</label></span>
			<span><input type="checkbox" id="check5" name="check"> <label for="check5">마</label></span>
			<span><input type="checkbox" id="check6" name="check"> <label for="check6">바</label></span>
		</div>
		<button class="btn gray small">버튼</button>
	</div>
</div>
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
    <c:forEach var="dto" items="${goodsList}" varStatus="status">	
						<td>
							<table style='padding:15px'>
								<tr>
									<td>
										<a href="GoodsRetrieveServlet?goods_Code=${dto.goods_Code}"> 
											<img src="images/items/thum/${dto.goods_Image1}.jpg" border="0" align="center" width="200">
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
										<a class= "a_black" href="GoodsRetrieveServlet?goods_Code=${dto.goods_Code}"> 
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
