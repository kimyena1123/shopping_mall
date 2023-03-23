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
						<p>상품 등록</p>
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
								<option value="티셔츠">티셔츠</option>
								<option value="바지">바지</option>
								<option value="치마">치마</option>
								<option value="원피스">원피스</option>
							</select>
							
							<input type="text" id="product_title" name="product_title" placeholder="상품명">
							<input type="text" id="product_price" name="product_price" placeholder="가격">
							<input type="text" id="product_size" name="product_size" placeholder="사이즈">
							<input type="text" id="product_color" name="product_color" placeholder="색상">
							<input type="text" id="product_desc" name="product_desc" placeholder="제품설명">
							
							<input type="file" id="product_imgs_file1" name="product_imgs_file1">
							<input type="file" id="product_imgs_file2" name="product_imgs_file2">
							<input type="file" id="product_imgs_file3" name="product_imgs_file3">
							<input type="file" id="product_imgs_file4" name="product_imgs_file4">
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	
	<script>
	$(document).ready(function(){
		//상품등록
		$("#registerProduct").on("click", function(){
			let product_category = $("#product_category").val();
			let product_title = $("#product_title").val();
			let product_price = $("#product_price").val();
			let product_size = $("#product_size").val();
			let product_color = $("#product_color").val();
			let product_desc = $("#product_desc").val();
			
			$.ajax({
				type: 'post',
				url: '/product/upload',
				data:{
					"product_category"
				}
			})
			
			
		})
	})
	
	</script>
</body>
</html>