<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="/static/css/header.css" type="text/css">

<header>
	<img src="#" class="logo">
	<nav>
		<ul>
			<c:choose>
				<c:when test="${not empty session_index && session_name ne '김예나' }">
					<li><a>${session_name }님</a></li>
					<li><a href="#">홈</a></li>
					<li><a href="#">장바구니</a</li>
					<li><a href="/user/signout">로그아웃</a>
				</c:when>
				
				<c:when test="${session_name eq '김예나'}"> 
					<li><a>${session_name }님</a></li>
					<li><a href="/product/productItem/view">상품관리</a></li>
					<li><a href="#">주문내역</a></li>
					<li><a href="/user/signout">로그아웃</a></li>
				</c:when>
				
				<c:otherwise>
					<li><a href="/user/signin/view">로그인</a></li>
					<li><a href="/user/signup/view">회원가입</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
</header>