<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="/static/css/item.css" type="text/css">
<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
		<section>
			<aside>
				<nav>
					<ul>
						<li><a href="/product/productItem/view">상품 목록</a></li>
						<li><a href="/product/upload/view">상품 등록</a></li>
						<li><a href="#">상품 수정</a></li>
						<li><a href="#">카테고리 수정</a></li>
					</ul>
				</nav>
			</aside>
			
			<div class="content">
				<div class="nav_category">
					<ul class="categorys">
						<c:forEach var="category" items="${categoryList }">
							<li><a href="#">${category.type }</a></li>
						</c:forEach>
					</ul>
				</div>
			
				<div class="item_list">
					<c:forEach var="product" items="${product_OtherList }">
						<a href="/product_detail/detail/view?id=${product.id }">
							<div class="show_items" data-product-id="${product.id }">
								<c:set var="productId" value="${product.id }" />
								<p>${product.title }</p>
								<p>${product.price }</p>
								<p>${product.type }</p>
							</div>
						</a> 
					</c:forEach>
				</div>
			</div>
		</section>
	</div>
	
	<script>
		
		
	</script>
	
</body>
</html>