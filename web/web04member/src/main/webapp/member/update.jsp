<%@ page import="com.example.web04member.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 수정</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">회원 수정</h1>
    <form action="memberUpdateOK.do" method="post">
        <input type="hidden" name="id" value="<%= ((MemberVO) request.getAttribute("member")).getId() %>">
        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" class="form-control" id="name" name="name" value="<%= ((MemberVO) request.getAttribute("member")).getName() %>" required>
        </div>
        <div class="form-group">
            <label for="email">이메일</label>
            <input type="text" class="form-control" id="email" name="email" value="<%= ((MemberVO) request.getAttribute("member")).getEmail() %>" required>
        </div>
        <div class="form-group">
            <label for="phone">전화번호</label>
            <input type="text" class="form-control" id="phone" name="phone" value="<%= ((MemberVO) request.getAttribute("member")).getPhone() %>" required>
        </div>
        <button type="submit" class="btn btn-warning">수정</button>
        <a href="memberSelectAll.do" class="btn btn-secondary">목록으로 돌아가기</a>
    </form>
</div>


</body>
</html>
