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
<script type="text/javascript" src="js/jquery-3.1.0.js"></script>
 <script type="text/javascript">
    $(document).ready(function(){
    	
    	$("#cart").on("click",function(){
    	//	$("form")[0].action="GoodsCartServlet";
    		$("form").attr("action","GoodsCartServlet");
    	});
    	
    });
</script>
<form name="goodRetrieveForm" method="GET" action="#">
	    <input type="hidden" name="goods_Image1" value="${goodsRetrieve.goods_Image1}">
	     <input type="hidden" name="goods_Code" value="${goodsRetrieve.goods_Code}">
	      <input type="hidden" name="goods_Name" value="${goodsRetrieve.goods_Name}"> 
	      <input type="hidden" name="goods_Price" value="${goodsRetrieve.goods_Price}">

	<table width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
		</tr>
		<tr>
			<td>
				<table align="center" width="710" cellspacing="0" cellpadding="0"
					border="0" style='margin-left: 30px'>
					<tr>
						<td class="td_default"><font size="5"><b>- 상품 정보 -</b></font>
							&nbsp;</td>
					</tr>
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
						<td rowspan="7"><img src="images/items/${goodsRetrieve.goods_Image1}.jpg"
							border="0" align="center" width="300" /></td>
						<td class="td_title">제품코드</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>
						${goodsRetrieve.goods_Code}
						</td>
					</tr>
					<tr>
						<td class="td_title">상품명</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>
						${goodsRetrieve.goods_Name}
						</td>
					</tr>
					<tr>
						<td class="td_title">가격</td>

						<td class="td_red" colspan="2" style='padding-left: 30px'>
						${goodsRetrieve.goods_Price}
						</td>
					</tr>
					<tr>
						<td class="td_title">배송비</td>
						<td colspan="2"><font color="#2e56a9" size="2"
							style='padding-left: 30px'><b> 무료배송</b> </font> <font size="2">(도서
								산간지역 별도 배송비 추가)</font></td>
					</tr>
					<tr>
						<td class="td_title" rowspan="2">상품옵션</td>
					
					</tr>
					<tr>
						<td colspan="2" style='padding-left: 30px'><select
							class="select_change" size="1" name="goods_Color"
							id="goods_Color">
								<option selected value="색상선택">색상선택</option>
								<option value="navy">navy</option>
								<option value="black">black</option>
								<option value="ivory">ivory</option>
								<option value="white">white</option>
								
						</select></td>
					</tr>

				<!-- 	<tr>
						<td class="td_title">주문수량</td>
						<td style="padding-left: 30px"><input type="text"
							name="gAmount" value="1" id="gAmount"
							style="text-align: right; height: 18px">  <img
							src="images/up.png" id="up"> 
							 <img src="images/down.png"
							id="down"></td>
					</tr> -->
				</table>

			</td>
		</tr>
	</table>

	<br> <button>구매</button>
	&nbsp;&nbsp;
	<button id="cart">장바구니</button><br> 
<img src="images/divider_1.jpg"><br> 
<form name="goodRetrieveForm" method="GET" action="#">
	    <input type="hidden" name="goods_Image1" value="${goodsRetrieve.goods_Image1}">
	     <input type="hidden" name="goods_Code" value="${goodsRetrieve.goods_Code}">
	      <input type="hidden" name="goods_Name" value="${goodsRetrieve.goods_Name}"> 
	      <input type="hidden" name="goods_Price" value="${goodsRetrieve.goods_Price}">
	<tr>
	<img src="images/items/${goodsRetrieve.goods_Image2}.jpg" align="center">
</tr><br> 
<br>
<br>
<img src="images/wash_info.jpg"><br> 
	<img src="images/divider_1.jpg"><br> 
	</form>
	<br> 
<table>
<tr>
<td>
<button id=shareInfo name=shareInfo>카톡으로 공유하기</button><!-- 구글링중--> 
<button id=reviewBoard name=reviewBoard>리뷰</button><!-- db테이블 따로 만들고 모든 사용자에게 insert/update/delete/나와 운영자만 보기 권한 필요 sys:답글권한-->
<button id=QnABoard name=QnABoard>Q&A</button><!-- 홈에 있는 질문게시판 -->
<button id=wishCapture name=wishCapture>wishList</button><!-- sql문 wish 테이블(비회원기능) 따로만들어 insert -->
</td> </tr>
</table>
</form>
