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
			<div class="wirteReview">
				<div class="complete">작성완료</div>
				
				<div class="write">
					<div class="text">상세한 리뷰를 작성해주세요.</div>
					<textarea id="review_comment" name="review_comment" rows="30" cols="170"></textarea>
				</div>
				
				<div class="reviewImgs">
					<div class="fourImgs">사진은 최대 4장까지</div>
					
					<div class="inputFile">
						<input type="file" id="file1" name="file1">
						<input type="file" id="file2" name="file2">
						<input type="file" id="file3" name="file3">
						<input type="file" id="file4" name="file4">
					</div>
					<div class="showImgs">
						<div class="exampleImg">
							<img id="imgFile1" src="#">
						</div>
						<div class="exampleImg">
							<img id="imgFile2" src="#">
						</div>
						<div class="exampleImg">
							<img id="imgFile3" src="#">
						</div>
						<div class="exampleImg">
							<img id="imgFile4" src="#">
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
					<c:set var="review_id" value="${review.id }"/>
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
		<c:set var="productId" value="${productInfos.productId }"/>
	</div>
	
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
		
	
		
		$("#file1").on("change", function(e){
				
				var file = e.target.files[0];
				var reader = new FileReader();
				
				reader.onload = function(e){
					$("#imgFile1").attr("src", e.target.result);
				}
				reader.readAsDataURL(file);
		})
		
		$("#file2").on("change", function(e){
				
				var file = e.target.files[0];
				var reader = new FileReader();
				
				reader.onload = function(e){
					$("#imgFile2").attr("src", e.target.result);
				}
				reader.readAsDataURL(file);
		})
		
		$("#file3").on("change", function(e){
				
				var file = e.target.files[0];
				var reader = new FileReader();
				
				reader.onload = function(e){
					$("#imgFile3").attr("src", e.target.result);
				}
				reader.readAsDataURL(file);
		})
		
		$("#file4").on("change", function(e){
				
				var file = e.target.files[0];
				var reader = new FileReader();
				
				reader.onload = function(e){
					$("#imgFile4").attr("src", e.target.result);
				}
				reader.readAsDataURL(file);
		})
		
		$(".complete").on("click", function(){
			let review_comment = $("#review_comment").val();
			let productId = '<c:out value="${productId}"/>';
			
			//폼 객체 생성
			let formData = new FormData();
			formData.append('file1', $("#file1")[0].files[0]);
			formData.append('file2', $("#file2")[0].files[0]);
			formData.append('file3', $("#file3")[0].files[0]);
			formData.append('file4', $("#file4")[0].files[0]);
			
			
			$.ajax({
				type: 'post',
				url: '/review/write',
				data: {
					"productId":productId,
					"comment":review_comment,
				},
				success:function(res){
					if(res.result){
						//방금 생성된 review테이블의 id를 가져와야 한다.
						let reviewId = '<c:out value="${review_id}"/>';
						let reviewIdString = parseInt(reviewId);
						let review_id = reviewIdString + 1;
						
						formData.append('review_id', review_id);
						
						alert(review_id);
						$.ajax({
							type:'post',
							url:'/review_imgs/insert',
							data: formData,
							enctype: "multipart/form-data",
							processData:false,
							contentType:false,
							success:function(res){
								if(res.result){
									location.href="/review/view";
								}else{
									alert("review_img insert fail");
								}
							},
							error:function(err){
								alert("review img error");
							}
						})
					}else{
						alert("review table insert fail");
					}
				},
				error:function(err){
					alert("review table insert error");
				}
			})//ajax end
			
		})//complete jquery end
	})
</script>
	
</body>


</html>