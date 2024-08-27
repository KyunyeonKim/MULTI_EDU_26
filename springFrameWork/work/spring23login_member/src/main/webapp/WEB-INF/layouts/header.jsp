<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul id="menu">
	<li><a href="home.do">HOME</a></li>
	<li><a href="m_selectAll.do">회원목록</a>
		<ul>
			<li><a href="m_selectAll.do">회원목록</a>
			<li><a href="m_insert.do">회원가입</a></li>
		</ul></li>
	<li>
		<c:choose>
			<c:when test="${user_id != null }">
				<a href="logout.do">로그아웃</a>
			</c:when>
			<c:otherwise>
				<a href="login.do">로그인</a>
			</c:otherwise>
		</c:choose>
	</li>
</ul>