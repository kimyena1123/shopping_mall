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
				<c:when test="${not empty session_index }">
					<P>${session_name }님</P>
				</c:when>
			
				<c:otherwise>
					<li><a href="#">로그인</a></li>
					<li><a href="#">회원가입</a></li>
				</c:otherwise>
				</c:choose>
			<li><a href="#">문의사항</a></li>
		</ul>
	</nav>
</header>