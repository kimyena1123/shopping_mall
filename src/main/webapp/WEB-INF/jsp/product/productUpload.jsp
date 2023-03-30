<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productUpload</title>
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="/static/css/productUpload.css" type="text/css">
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
						<li><a href="#">상품 등록</a></li>
						<li><a href="#">상품 수정</a></li>
						<li><a href="#">카테고리 수정</a></li>
					</ul>
				</nav>
			</aside>
			
			<div class="content">
				<div class="productRegister">
					<div class="name">
					<c:set var="productId" value="${ productCount + 2 }"/>
						<p><c:out value="${productId}" />번째 상품 등록</p>
						<div class="black">
							
							<c:forEach var="product" items="${productList }" varStatus="status">
								
								<c:choose>
									<c:when test="${status.first == true }">
									<div class="productIdDiv" data-product-id=${product.id }>${product.id }</div>
									</c:when>
									<c:otherwise>
									<div>아님 ${product.id }</div>
									</c:otherwise>
								</c:choose>
								
								
							</c:forEach>
							
						</div>
					</div>
					
					<div class="productInputs">
						<div class="product_labels">
							<label for="product_category">분류 : </label>
							<label for="product_title">상품명 : </label>
							<label for="product_price">가격 : </label>
							<label for="product_size">사이즈 : </label>
							<label for="product_color">색상 : </label>
							<label for="product_desc">제품 설명 : </label>
							<label for="product_imgs_file">첨부사진 : </label>
							
							<div class="saveBtn">
								<button type="submit" id="registerProduct">등록</button>
							</div>
						</div>
						
						<div class="product_inputs">
							<select name="product_category" id="product_category">
								<option value="">--Please choose an option--</option>
								<c:forEach var="category" items="${categoryList }">
									<option value="${category.id }" 
											data-category-id="${category.id }" 
											class="option_category">
												${ category.type }
									</option>
								</c:forEach>
							</select>
							
							<input type="text" id="product_title" name="product_title" placeholder="상품명">
							<input type="text" id="product_price" name="product_price" placeholder="가격">
							<input type="text" id="product_size" name="product_size" placeholder="사이즈">
							<input type="text" id="product_color" name="product_color" placeholder="색상">
							<input type="text" id="product_desc" name="product_desc" placeholder="제품설명">
							
							<div class="img_file">
								<input type="file" id="product_imgs_file1" name="product_imgs_file1">
								<input type="file" id="product_imgs_file2" name="product_imgs_file2">
								<input type="file" id="product_imgs_file3" name="product_imgs_file3">
								<input type="file" id="product_imgs_file4" name="product_imgs_file4">
							</div>
							
							<button type="button" id="fileBtn">이미지버튼</button>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	
	<script>
	$(document).ready(function(){
		
		$("#fileBtn").on("click", function(){
			
			// 폼 객체 생성
			let formData = new FormData();
			formData.append('product_imgs_file1', $("#product_imgs_file1")[0].files[0]);			
			formData.append('product_imgs_file2', $("#product_imgs_file2")[0].files[0]);			
			formData.append('product_imgs_file3', $("#product_imgs_file3")[0].files[0]);			
			formData.append('product_imgs_file4', $("#product_imgs_file4")[0].files[0]);			
			

			$.ajax({
				type: 'post',
				url: '/product_imgs/insert',
				data:formData,
				enctype: "multipart/form-data",
				processData:false,
				contentType:false,
				success:function(res){
					if(res.result){
						alert("image insert succeses");
						
					}else{
						alert("image insert fail");
					}
				},
				error:function(err){
					alert("product_imgs insert error");
				}
			}) // product_imgs ajax
		
			
		})
		
		//상품등록
		$("#registerProduct").on("click", function(){
			let categoryId = $("#product_category").val();
			let product_title = $("#product_title").val();
			let product_price = $("#product_price").val();
			let product_size = $("#product_size").val();
			let product_color = $("#product_color").val();
			let product_desc = $("#product_desc").val();
			
			let selectCategory = $("#product_category :selected").text();
			let product_category = $.trim(selectCategory);
			
			let last_productId = $(".productIdDiv").data("productId");
			let productId = last_productId + 1;
			
			

			// 폼 객체 생성
			let formData = new FormData();
			
			formData.append('productId', productId);
			formData.append('product_imgs_file1', $("#product_imgs_file1")[0].files[0]);			
			formData.append('product_imgs_file2', $("#product_imgs_file2")[0].files[0]);			
			formData.append('product_imgs_file3', $("#product_imgs_file3")[0].files[0]);			
			formData.append('product_imgs_file4', $("#product_imgs_file4")[0].files[0]);			
			
			
			$.ajax({
				type: 'post',
				url: '/product/insert',
				data: {
					"categoryId":categoryId,
					"title":product_title,
					"price":product_price,
				},
				success:function(res){
					
					if(res.result){
						$.ajax({
							type:'post',
							url: '/product_detail/insert',
							data:{
								"productId":productId,
								"color":product_color,
								"size":product_size,
								"desc":product_desc,
							},
							success:function(res){
								if(res.result){
									alert("product_detail insert success");
									
									$.ajax({
										type: 'post',
										url: '/product_imgs/insert',
										data:formData,
										enctype: "multipart/form-data",
										processData:false,
										contentType:false,
										success:function(res){
											if(res.result){
												alert("image insert succeses");
												location.href="/product/productItem/view"; 
											}else{
												alert("image insert fail");
											}
										},
										error:function(err){
											alert("product_imgs insert error");
										}
									}) // product_imgs ajax
									
								}else{
									alert('product_deatail insert fail');
								}
							},
							error:function(err){
								alert("product_detail insert error");
							}
						}) // product_detail insert ajax
						
						
						
						
					}else{
						alert("product insert 실패")
					}
				},
				error:function(err){
					alert("product_insert error");
				}
			})
			
			
			
		})
	})
	
	</script>
</body>
</html>