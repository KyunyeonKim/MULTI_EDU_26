<%@ page import="com.example.web04member.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 삭제</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">회원 삭제</h1>
    <form action="memberDeleteOK.do" method="post">
        <div class="alert alert-danger" role="alert">
            <input type="hidden" name="id" value="<%= ((MemberVO) request.getAttribute("member")).getId() %>">
            <p>정말로 이 회원을 삭제하시겠습니까?</p>
            <p><strong>ID:</strong> <%= ((MemberVO) request.getAttribute("member")).getId() %></p>
            <p><strong>이름:</strong> <%= ((MemberVO) request.getAttribute("member")).getName() %></p>
            <p><strong>이메일:</strong> <%= ((MemberVO) request.getAttribute("member")).getEmail() %></p>
            <p><strong>전화번호:</strong> <%= ((MemberVO) request.getAttribute("member")).getPhone() %></p>
        </div>
        <button type="submit" class="btn btn-danger">삭제</button>
        <a href="memberSelectAll.do" class="btn btn-secondary">목록으로 돌아가기</a>
    </form>
</div>

</body>
</html>
