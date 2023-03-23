<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link rel="stylesheet" href="/static/css/signin.css" type="text/css">

<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section>
			<div class="squareDiv">
				<div class="showUser">
					<h1>로그인</h1>
					<input type="text" id="user_id" name="user_id">
					<input type="password" id="user_pw" name="user_pw">
					
					<button type="submit" id="loginBtn">로그인</button>
				</div>
			</div>
			
			<div class="signupGo">
				<div class="showUser" id="lowerDiv">
					<button type="button" id="signupBtn">회원가입</button>
				</div>
			</div>
		</section>
	</div>
	
	
	<script>
		$(document).ready(function(){
			//로그인 버튼 클릭시
			$("#loginBtn").on("click", function(){
				let user_id = $("#user_id").val();
				let user_pw = $("#user_pw").val();
				
				$.ajax({
					type: 'post',
					url: '/user/signin',
					data: {
						"user_id":user_id,
						"user_pw":user_pw,
					},
					success:function(res){
						if(res.result){
							location.href="/product/main/view";
						}else{
							alert("로그인 실패");
						}
					},
					error:function(err){
						alert("login error");
					}
				})
			})
		})
	</script>
</body>
</html>