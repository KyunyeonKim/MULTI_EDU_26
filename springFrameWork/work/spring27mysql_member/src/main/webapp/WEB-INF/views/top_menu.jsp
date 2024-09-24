<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<a href="home.do">home</a>
<a href="m_insert.do">insert</a>
<a href="m_selectAll.do">selectAll</a>
<c:choose>
	<c:when test="${user_id != null }">
		<a href="logout.do">로그아웃</a>
	</c:when>
	<c:otherwise>
		<a href="login.do">로그인</a>
	</c:otherwise>
</c:choose>


