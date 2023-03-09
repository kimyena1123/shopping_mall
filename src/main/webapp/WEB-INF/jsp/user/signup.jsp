<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
	
		<header>
			<img src="#" class="logo">
			<nav>
				<ul>
					<li><a href="#">로그인</a></li>
					<li><a href="#">회원가입</a></li>
					<li><a href="#">문의사항</a></li>
				</ul>
			</nav>
		</header>
		<section>
			<div class="introduce">
				<p>이제 CloYeth의 회원이 되어볼까요?
			</div>
			
			<div class="userInfo1">
				<div class="text1">
					<h2>개인정보 입력<h2>
				</div>
				
				<div class="info">
					<div class="left">
						<div class="leftLabel">
							<label for="user_id">아이디</label>
							<label for="user_pw">비밀번호</label>
							<label for="user_pwCheck">비밀번호 확인</label>
						</div>
						
						<div class="leftInput">
							<div class="idCheck">
								<input type="text" id="user_id" name="user_id">
								<button type="button" id="idCheckBtn" class="checkBtn">중복확인</button>
							</div>
							<input type="password" id="user_pw" name="user_pw">
							<input type="password" id="user_pwCehck" name="user_pwCheck">
						</div>
					</div>
					
					<div class="right">
						<div class="rightLabel">
							<label for="user_email">이메일</label>
							<label for="user_name">이름</label>
							<label for="user_birth">생년월일</label>
						</div>
						
						<div class="rightInput">
							<div class="idCheck">
								<input type="email" id="user_email" name="user_email">
								<button type="button" id="emailCheckBtn" class="checkBtn">중복확인</button>
							</div>
							<input type="text" id="user_name" name="user_name">
							<input type="text" id="user_birth" name="user_birth">
						</div>
					</div>
				</div>
			</div>
			
			<div class="userInfo2">
				<div class="text1">
					<h2>연락 및 수신입력<h2>
				</div>
				
				<div class="info">
					<div class="left">
						<div class="leftLabel" id="call">
							<label for="user_address">주소</label>
							<label for="user_number">번호</label>
						</div>
						
						<div class="leftInput" id="callInput">
							<input type="text" id="user_address" name="user_address">
							<input type="text" id="user_number" name="user_number">
						</div>
					</div>
				</div>
				
				<div class="sendDiv">
					<button type="submit" id="register">가입하기</button>
				</div>
			</div>
			
		</section>
	</div>
	
	<script>
	$(document).ready(function(){
		//중복체크 여부 확인
		let isIdCheck = false;
		let isEmailCheck = false;
		
		//중복 상태 저장 변수
		let isIdDuplicate = true;
		let isEmailDuplicate = true;
		
		//가입하기 버튼 눌렀을 때
		$("#register").on("click", function(){
			let user_id = $("#user_id").val();
			let user_pw = $("#user_pw").val();
			let user_pwCheck = $("#user_pwCheck").val();
			let user_name = $("#user_name").val();
			let user_birth = $("#user_birth").val();
			let user_address = $("#user_address").val();
			let user_number = $("#user_number").val();
			let user_email = $("#user_email").val();
			
			//input이 빈값일 경우
			if(user_id == ""){
				alert("아이디를 입력헤주세요");
				return;
			}
			if(user_pw == ""){
				alert("비밀번호를 입력해주세요");
				return;
			}
			if(user_name == ""){
				alert("이름을 입력해주세요");
				return;
			}
			if(user_email == ""){
				alert("이메일을 입력해주세요");
				return;
			}
			if(user_birth == ""){
				alert("생년월일을 입력해주세요");
				return;
			}
			if(user_address == ""){
				alert("주소를 입력해주세요");
				return;
			}
			if(user_number == ""){
				alert("전화번호를 입력해주세요");
				return;
			}
			
			if(user_pw != user_pwCheck){
				alert("비밀번호가 일치하지 않습니다.");
				return;
			}
			
			//중복되었는지 유효성 겸사
			if(!isIdCheck){
				alert("아이디 중복검사를 해주세요");
				return;
			}
			
			if(!isEmailCheck){
				alert("이메일 중복 검사를 해주세요");
				return;
			}
			
			//중복 되었는지 유효성 검사
			if(isIdDuplicate){
				alert("이미 존재하는 아이디 입니다.");
				return;
			}
			
			if(isEmailDuplicate){
				alert("이미 가입된 이메일 입니다.");
				return;
			}
			
			$.ajax({
				type: 'post',
				url: '/user/signup',
				data:{
					"user_id":user_id,
					"user_pw":user_pw,
					"user_name":user_name,
					"user_birth":user_birth,
					"user_email":user_email,
					"user_address":user_address,
					"user_number":user_number,
				},
				success:function(res){
					if(res.result){
						alert("회원가입 성공");
					}else{
						alert("회원가입 실패");
					}
				},
				error:function(err){
					alert('signup insert error');
				}
			}) // ajax
		}) //register
		
		//아이디 중복 검사 클릭시
		$("#idCheckBtn").on("click", function(){
			let user_id = $("#user_id").val();
			
			//input 빈 값 확인
			if(user_id == ""){
				alert("아이디를 입력해주세요");
				return;
			}
			
			$.ajax({
				type: 'post',
				url: '/user/signup/idCheck',
				data: {
					"user_id":user_id,
				},
				success:function(res){
					isIdCheck = true;
					
					if(res.id){
						alert("사용 가능한 아이디 입니다");
						isIdDuplicate = false; //중복되지 않는다.
					}else{
						alert("이미 존재하는 아이디 입니다.");
						isIdDuplicate = true; //중복된다.
					}
				},
				error:function(err){
					alert("idCheck error");
				}
			
			})
		}) // idCheckBtn
		
		//이메일 중복 확인
		$("#emailCheckBtn").on("click", function(){
			let user_email = $("#user_email").val();
			
			//빈값 확인
			if(user_email == ""){
				alert("이메일을 입력해주세요");
				return;
			}
			
			$.ajax({
				type: 'post',
				url: '/user/signup/emailCheck',
				data:{
					"user_email":user_email,
				},
				success:function(res){
					isEmailCheck = true;
					
					if(res.email){
						alert("사용 가능한 이메일 입니다.");
						isEmailDuplicate = false;
					}else{
						alert("이미 가입되어 있는 이메일입니다.");
						isEmailDuplicate = true;
					}
				},
				error:function(err){
					alert("emailCheck error");
				}
			})
		})//email 중복 확인
		
		$("#user_id").on("input", function(){
			//중복 체크 여부를 모두 취소
			isIdCheck = false;
			isIdDuplicate = true;
		})
		
		$("#user_email").on("input", function(){
			isEmailCheck = false;
			isEmailDuplicate = true;
		})
		
	}) // jquery
	</script>
</body>
</html>