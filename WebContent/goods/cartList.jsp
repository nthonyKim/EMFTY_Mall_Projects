<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form name="myForm">
	    
	<input type="text" name="num81" value="81" id="num81">
	<input type="text" name="gImage81" value="bottom1" id="gImage81">
	<input type="text" name="gName81" value="제나 레이스 스커트" id="gName81">
	<input type="text" name="gSize81" value="L" id="gSize81">
	<input type="text" name="gColor81" value="navy" id="gColor81"> 
	<input type="text" name="gPrice81" value="9800" id="gPrice81">
	
	<style type="text/css">
		.tblList {border-top:2px solid #bbb;}
		.tblList th {font-weight:bold;color:#333;}
		.tblList th, .tblList td {padding:12px 10px;vertical-align:middle;border-bottom:1px solid #bbb;}
		.tblList td {text-align:center;}
		.alignL {text-align:left !important;}
		a.btn {text-decoration:none;}
		a.gray{color:#333;}
	</style>

	<table class="tblList">
		<colgroup>
			<col style="width:10%">
			<col style="width:10%">
			<col style="width:25%">
			<col style="width:20%">
			<col style="width:15%">
			<col style="width:10%">
			<col style="width:10%">
		</colgroup>
		<thead>
			<tr>
				<th><input type="checkbox" name="allCheck" id="allCheck"> <lable for="allCheck">전체 선택</lable></th>
				<th>주문번호</th>
				<th>상품정보</th>
				<th>판매가</th>
				<th>수량</th>
				<th>합계</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="checkbox" name="check" id="check81" class="check" value="81"></td>
				<td>81</td>
				<td class="alignL">
					<img src="images/items/bottom1.gif" />
					제나 레이스 스커트 [브랜드]
				</td>
				<td>
					￦9,800
					<input class="input_default" type="text" name="cart_amount" id="cartAmount81" maxlength="3" size="2" value="3">
					<input type="button" value="수정" onclick="amountUpdate('81')" /> 
				</td>
				<td>3</td>
				<td>￦29,400</td>
				<td>
					<button>주문</button>
					<button>삭제</button>
				</td>
			</tr>
		</tbody>
	</table>	
</form>

	<div class="btnGroup">
		<a class="btn yellow" href="javascript:orderAllConfirm(myForm)"> 전체 주문하기 </a>
		<a class="btn gray" href="javascript:delAllCart(myForm)"> 전체 삭제하기 </a>
		<a class="btn gray" href="index.jsp"> 계속 쇼핑하기 </a>
	</div>

