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
<link rel="stylesheet" href="/static/css/orderPage.css" type="text/css">
<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>

<title>주문페이지</title>
</head>
<body>
	<div class="container">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
		<section>
			<div class="orderDiv">
				<div class="buyItemList">
				
				<c:forEach var="order" items="${orderList }" varStatus="status">
					<div class="selectItemList">
						<img src="${order.productImgs_img }" class="smallImg">
						
						<div class="checkItem">
							<p>수량: ${order.count }</p>
							<p>가격: ${order.basket_price }</p>
							<p>제품이름: ${order.title }.</p>
						
							<c:set var="countString" value="${countString += order.count }/"/>
							<c:set var= "title" value="${title += order.title  }."/>
							<c:set var= "priceString" value="${priceString += order.basket_price}."/>
							
							<c:set var= "total_count" value="${total_count + order.count }"/>
							<c:set var= "total_price" value="${total_price + order.basket_price}"/>
							
						</div>
					</div>
					</c:forEach>
					
				</div>
				
				<div class="checkItemCount">
					<p>전체수량: <span><c:out value="${total_count }"/>개</span></p>
					<p>총금액: <span><c:out value="${total_price }"/>원</span></p>
				</div>
				
				<div class="userInfos">
				
					<div class="labels">
						<label for="user_name">주문자: </label>
						<label for="user_address">배송지: </label>
						<label for="card_name">결제수단: </label>
						<label for="user_number">전화번호: </label>
					</div>
					
					<div class="inputs">
						<input type="text" id="user_name" name="user_name" class="inputTag" value="${orderOther.user_name}">
						<c:set var= "user_name" value="${orderOther.user_name }"/>
						
						<input type="text" id="user_address" name="user_address" class="inputTag" value="${orderOther.user_address}">
						<c:set var= "user_address" value="${orderOther.user_address }"/>
						
						<select id="card_name" name="card_name" class="inputTag">
							<option>---select your card---</option >
							<option>국민</option>
							<option>신한</option>
							<option>농협</option>
							<option>카카오뱅크</option>
						</select>
						
						<input type="text" id="user_number" name="user_number"class="inputTag" value="${ orderOther.user_number}">
						<c:set var= "user_number" value="${ orderOther.user_number }"/>
						
					</div>
				</div>
				
				<div class="btn">
					<button type="button" id="before">취소하기</button>
					<button type="submit" id="pay">결제하기</button>
				</div>
			</div>
		</section>
	</div>
	
	<script>
		$(document).ready(function(){
			$("#pay").on("click", function(){
				
				
				let total_count = '<c:out value="${total_count}"/>';
				let total_price = '<c:out value="${total_price}"/>';
				
				let userName = '<c:out value="${user_name}"/>';
				let address = '<c:out value="${user_address}"/>';
				let phone_number = '<c:out value="${user_number}"/>';
				
				let card_name = $("#card_name").val();
				let title = '<c:out value="${title}"/>';
			
				
				let productTitle = title.split(".");
				
				let length = productTitle.length - 1;
				
				
				let countString = '<c:out value="${countString}"/>';
				let countNumber = countString.split("/");
				//alert(countNumber[0] + countNumber[1]);
				
				let priceString = '<c:out value="${priceString}"/>';
				let priceNumber = priceString.split(".");
				
				
				let formData = new FormData();
				
				for(var i = 0; i < length; i++){
					
					countNumber[i] = parseInt(countNumber[i]);
					let counti = countNumber
					
					let productTitlei = productTitle[i];
				
					priceNumber[i] = parseInt(priceNumber[i]);
					let pricei = priceNumber[i];

					formData.append("count" + i, counti); //count0, count1, count2, count3 ...
					formData.append("productTitle" + i, productTitlei);
					formData.append("price" + i, pricei);
				}
				
				console.log(formData.get("price0"));
				
				
				if(card_name == "---select your card---"){
					alert("결제할 카드를 선택해 주세요");
				}

				
				$.ajax({
					type: 'post',
					url: '/order/insert',
					data: {
						"userName":userName,
						"address":address,
						"phone_number":phone_number,
						"total_price":total_price,
						"card_name":card_name,
					},
					success:function(res){
						
						if(res.result){
							alert("주문 완료");
						}else{
							alert("order insert fail");
						}
					},
					error:function(err){
						alert("order error");
					}
				})
				
			})
		})
	</script>
</body>
</html>