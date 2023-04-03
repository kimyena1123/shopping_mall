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
			
			<div class="content" id="content2">
				<div class="nav_category">
					<ul class="categorys">
						
						<c:forEach var="category" items="${categoryList }">
							<li><a href="#">${category.type }</a></li>
						</c:forEach>
				
					</ul>
				</div>
			
				<div class="item_list" id="item_list2">
					
					<c:forEach var="product" items="${product_OtherList }">
						<a href="/product_detail/detail/view?id=${product.id }">
							<div class="show_items" id="show_items2" data-product-id="${product.id }">
								<div class="productImg">
									<img src="${product.product_img }" />
								</div>
								
								<c:set var="productId" value="${product.id }" />
								<p>${product.title }</p>
								<p>${product.price }</p>
								<p>${product.type }</p>
								<h3>${product.categoryId }</h3>
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