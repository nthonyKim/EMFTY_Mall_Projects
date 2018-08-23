<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form name="myForm">   
	<input type="hidden" name="num81" value="81" id="num81">
	<input type="hidden" name="gImage81" value="bottom1" id="gImage81">
	<input type="hidden" name="gName81" value="제나 레이스 스커트" id="gName81">
	<input type="hidden" name="gSize81" value="L" id="gSize81">
	<input type="hidden" name="gColor81" value=+"navy" id="gColor81"> 
	<input type="hidden" name="gPrice81" value="9800" id="gPrice81">
	
	<h1>장바구니</h1>
	<table class="tblList">
		<colgroup>
			<col style="width:12%">
			<col style="width:10%">
			<col style="width:*">
			<col style="width:20%">
			<col style="width:15%">
			<col style="width:10%">
			<col style="width:15%">
		</colgroup>
		<thead>
			<tr>
				<th><input type="checkbox" name="allCheck" id="allCheck"><label for="allCheck">전체 선택</label></th>
				<th>주문번호</th>
				<th>상품정보</th>
				<th>판매가</th>
				<th>수량</th>
				<th>합계</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="cartDTO" items="${cartList}">
			<tr>
				<td><input type="checkbox" name="check" id="check81" class="check" value="${cartDTO.num}"></td>
				<td>${cartDTO.num}</td>
				<td>
					<p class="img"><img src="images/items/thum/${cartDTO.goods_image}.jpg" /></p>
					<p class="alignL">${cartDTO.goods_name}</p>
				</td>
				<td>
					<fmt:formatNumber value="${cartDTO.goods_price}" type="currency" />
					<span class="space">
						<input class="alignR" type="text" name="cart_amount" id="cartAmount81" maxlength="3" style="width:50px;">
						<input type="button" class="btn xsmall" value="수정" id="amountUpdate" />
					</span> 
				</td>
				<td>${cartDTO.goods_amount}</td>
				<td><fmt:formatNumber value="${cartDTO.goods_amount * cartDTO.goods_price}" type="currency" /></td>
				<td>
					<span class="btns">
						<button class="btn xsmall yellow">주문</button>
						<button class="btn xsmall darkGray">삭제</button>
					</span>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>	
</form>

<div class="btnGroup">
	<a class="btn yellow" href="javascript:orderAllConfirm(myForm)">전체 주문하기</a>
	<a class="btn darkGray" href="javascript:delAllCart(myForm)">전체 삭제하기</a>
	<a class="btn gray" href="index.jsp">계속 쇼핑하기</a>
</div>

