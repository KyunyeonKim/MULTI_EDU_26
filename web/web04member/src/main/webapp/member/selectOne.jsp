<%@ page import="com.example.web04member.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 상세 정보</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">회원 상세 정보</h1>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">회원 ID: <%= ((MemberVO) request.getAttribute("member")).getId() %></h5>
            <p class="card-text">이름: <%= ((MemberVO) request.getAttribute("member")).getName() %></p>
            <p class="card-text">이메일:<%= ((MemberVO) request.getAttribute("member")).getEmail() %></p>
            <p class="card-text">전화번호: <%= ((MemberVO) request.getAttribute("member")).getPhone() %></p>
            <a href="memberUpdate.do?id=<%= ((MemberVO) request.getAttribute("member")).getId() %>" class="btn btn-warning">수정</a>
            <a href="memberDelete.do?id=<%= ((MemberVO) request.getAttribute("member")).getId() %>" class="btn btn-danger">삭제</a>
            <a href="memberSelectAll.do" class="btn btn-secondary">목록으로 돌아가기</a>
        </div>
    </div>
</div>

</body>
</html>
