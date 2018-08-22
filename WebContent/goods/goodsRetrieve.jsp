<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <c:if test="${! empty mesg}">
  <script type="text/javascript">
    alert('${mesg}');
    location.replace="";
    <%
    session.removeAttribute("mesg");
   %>
  </script>
</c:if>	
 <script type="text/javascript">
    $(document).ready(function(){
    	
    	$("#cart").on("click",function(){
    	//	$("form")[0].action="GoodsCartServlet";
    		$("form").attr("action","GoodsCartServlet");
    	});
    	
    	var count = parseInt($("#goodsAmount").val());
    	var input = $("#goodsAmount");
    	
    	$("#up").on("click", function(){	
    		count++;
    		console.log(count);
    		input.val(count);
    	})
    	
    	$("#down").on("click", function(){

        	if(parseInt(input.val())<=1){
        		input.val(1);
        	}else {
        		count--;
        		input.val(count);
        	}
    	})
    	
    	$("#goodsAmount").on("keyup", function(){
    		count = parseInt($("#goodsAmount").val());
    	})
    	
    });
</script>
<form name="goodRetrieveForm" method="GET" action="#">
	    <input type="hidden" name="goods_Image1" value="${goodsRetrieve.goods_Image1}">
	    <input type="hidden" name="goods_Code" value="${goodsRetrieve.goods_Code}">
	    <input type="hidden" name="goods_Name" value="${goodsRetrieve.goods_Name}"> 
	    <input type="hidden" name="goods_Price" value="${goodsRetrieve.goods_Price}">


	<div class="proView">
		<div class="imgSec">
			<img src="images/items/thum/${goodsRetrieve.goods_Image1}.jpg">
		</div>
		<dl>
			<dt>제품코드</dt>
			<dd>${goodsRetrieve.goods_Code}</dd>
			<dt>상품명</dt>
			<dd>${goodsRetrieve.goods_Name}</dd>
			<dt>가격</dt>
			<dd><fmt:formatNumber value="${goodsRetrieve.goods_Price}" type="currency" />원</dd>
			<dt>배송비</dt>
			<dd>
				<strong style="color:#2e56a9">무료배송</strong>
				<span>(도서산간지역 별도 배송비 추가)</span>
			</dd>
			<dt>상품옵션</dt>
			<dd>
				<select class="select_change" size="1" name="goods_Color" id="goods_Color">
					<option selected="" value="색상선택">색상선택</option>
					<option value="navy">navy</option>
					<option value="black">black</option>
					<option value="ivory">ivory</option>
					<option value="white">white</option>
					<option value="red">red</option>
					<option value="purple">purple</option>
				</select>
			</dd>
			<dt>주문수량</dt>
			<dd>
				<input type="text" name="gAmount" value="1" id="goodsAmount">
				<span class="btnAmount"><img src="images/up.png" id="up"> <img src="images/down.png" id="down"></span>
			</dd>
		</dl>
	</div>
	<div class="btnGroup">
		<button class="btn yellow">구매</button>
		<button class="btn gray" id="cart">장바구니</button> 
	</div>
	<img src="images/divider_1.jpg">
	<div class="alignC">
		<img src="images/items/${goodsRetrieve.goods_Image2}.jpg">
		<img src="images/wash_info.jpg">
		<img src="images/divider_1.jpg">
	</div>
	<div>
		<button id="shareInfo" name="shareInfo">카톡으로 공유하기</button><!-- 구글링중--> 
		<button id="reviewBoard" name="reviewBoard">리뷰</button><!-- db테이블 따로 만들고 모든 사용자에게 insert/update/delete/나와 운영자만 보기 권한 필요 sys:답글권한-->
		<button id="QnABoard" name="QnABoard">Q&amp;A</button><!-- 홈에 있는 질문게시판 -->
		<button id="wishCapture" name="wishCapture">wishList</button><!-- sql문 wish 테이블(비회원기능) 따로만들어 insert -->
	</div>
</form>
