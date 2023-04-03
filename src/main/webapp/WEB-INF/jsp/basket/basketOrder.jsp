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
<link rel="stylesheet" href="/static/css/shopping_basketPage.css" type="text/css">
<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>

<title>장바구니페이지</title>
</head>
<body>
   <div class="container">
      <c:import url="/WEB-INF/jsp/include/header.jsp" />
      
      <section>
         <div class="basketList">
            
            <div class="title">
               <h1>장바구니</h1>
            </div>
            
            <div class="explain">
               <p>전체 [${countNum}개의 주문상품]이 있습니다</p>
               <p>장바구니의 제품들은 예약되지 않습니다.</p>
               <p>결제를 완료하고 구입까지 끝마쳐주세요</p>
            </div>
            
            <div class="basketList2">
            
            <c:forEach var="basket" items="${basketList }">
               <div class="productShow">
                  <div class="productImg">
                     <img src="${basket.productImgs_img }" alt="대표사진">
                  </div>
                  
                  <div class="ItemInfo">
                     <p>상품 이름 : ${ basket.product_title}</p>
                     <p>상품 수량 : ${basket.count }개 </p>
                     <p>상품 가격 : ${basket.product_price }
                     <p>구매 가격 : ${basket.price }원 </p>
                     <c:set var= "total" value="${total + basket.price}"/>
                  
                  
                  <c:set var= "userId" value="${basket.userId}"/>
                  
                  </div>
                  
                  <div class="deleteItem">
                     <p data-basket-id="${basket.id }" class="deleteBtn">삭제</p>
                  </div>
               </div>
               
            </c:forEach>
               
            </div>
            
         </div>
         
         <div class="orderDiv">
            <div class="noeDiv">
               <a href="/order/page/view?userId=<c:out value="${userId}"/>" id="orderGo"><div class="order"><p>>> 구매하기</p></div></a>
               
               <div class="summarise">
                  <p class="bold">주문 요약</p>
                  <div id="charge" class="money">
                     <p>총 ${countNum }개의 상품</p>
                     <p class="AllProductMoney"></p>
                  </div>
                  
                  <div id="delivery" class="money">
                     <p> 배송비</p>
                     <p> 무료</p>
                  
                  </div>
                  
                  <div id="allCharge" class="money">
                     <p>합계  </p>
                     <p class="AllProductMoney">  </p>
                  </div>
               </div>
            </div>
            
         </div>
      </section>
   </div>
   
   <script>
      $(document).ready(function(){
    	  let total_price = '<c:out value="${total}"/>';
			$(".AllProductMoney").text(total_price + "원");
		
         
         $(".deleteBtn").on("click", function(){
            let basketId = $(this).data("basketId");
            
            $.ajax({
               type:'post',
               url: '/basket/delete',
               data: {
                  "basketId":basketId,
               },
               success:function(res){
                  if(res.result){
                     alert("장바구니 삭제 완료");
                     location.reload();
                  }else{
                     alert("장바구니 삭제 실패");
                  }
               },
               error:function(err){
                  alert("basket delete error");
               }
            
            })
         })
      })
   </script>
</body>
</html>