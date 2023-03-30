<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="/static/css/detail.css" type="text/css">
<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>

<title>product_detail</title>
</head>
<body>
	<div class="container">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
		<section>
			<div class="showReview">
				<div class="wirteReview">
					<c:set var="productId" value="${productInfos.productId }"/>
					<a href="/review/write/view?productId=<c:out value='${productId}'/>"><div class="writeDiv">글쓰기</div></a>
				</div>
				
				<div class="imgReview">
					<div class="reviews">
						
						<div class="selectReview">
						
						<c:forEach var="review" items="${reviewList }">
						<a href="#" id="aTag">
							<div class="reviweDivs">
								<p>user table : 누가${review.user_name } </p>
								<p>review_imgs table: 리뷰사진</p>
								<p>review table: 어떤 댓글: ${review.comment }</p>
								<p>product table: 어떤 상품의 리뷰: ${review.product_title }</p>
							</div>
						</a>
						</c:forEach>
						
						</div>
					</div>
				</div>
			</div>
			
			
			
			<div class="productInfo">
				<div class="titleInfo">
					<p class="titleName">${productInfos.title }</p>
					<p class="showInfo">가격: <span>${productInfos.price }</span></p>
					<p class="showInfo">색상: ${productInfos.color }</p>
					<p class="showInfo">사이즈: ${productInfos.size }</p>
					<p class="showInfo" id="order_detailInfo">수량: <input type="number" name="order_detail_count" id="order_detail_count" value="1"/></p>
				</div>
				
				<div class="order_detail_in">
					<p class="showInfo">총가격</p>
					<c:set var="current_price" value="${productInfos.price }" />
					<div class="text">
						<a href="/review/View?productId=<c:out value='${productId}'/>" id="review">리뷰보기</a>
						<p class="total_price">${productInfos.price }</p>
					</div>
					
					<div class="orderBtn">
						<button type="button" id="basket">장바구니</button>
						<button type="submit">주문하기</button>
					</div>
				</div>
				
				<div class="productExplain">
					<p>${productInfos.desc }</p>
				</div>
			</div>
		</section>
	</div>
	
</body>

<script>
	$(document).ready(function(){
		let current_count = $("#order_detail_count").val(); // 1
		
		$("#order_detail_count").on("input", function(){
			let productId = '<c:out value="${productId}"/>';
			
			let order_detail_count = $("#order_detail_count").val();
			let price = '<c:out value="${current_price}"/>';
			
			let current_priceString = price.split("원");
			//alert(price);
			//alert(current_price[0]);
			let current_price = parseInt(current_priceString);
			let total_price = order_detail_count * current_price;
			//alert(total_price);
			$(".total_price").text(total_price + "원");
			
		})
	})
</script>
</html>