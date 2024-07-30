<%@ page import="com.example.web04member.MemberVO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>전체 회원 목록</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">전체 회원 목록</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>이름</th>
            <th>이메일</th>
            <th>전화번호</th>
            <th>작업</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<MemberVO> memberList = (List<MemberVO>) request.getAttribute("memberList");
            for (MemberVO member : memberList) {
        %>
        <tr>
            <td><%= member.getId() %></td>
            <td><%= member.getName() %></td>
            <td><%= member.getEmail() %></td>
            <td><%= member.getPhone() %></td>
            <td>
                <a href="memberSelectOne.do?id=<%= member.getId() %>" class="btn btn-info btn-sm">조회</a>
                <a href="memberUpdate.do?id=<%= member.getId() %>" class="btn btn-warning btn-sm">수정</a>
                <a href="memberDelete.do?id=<%= member.getId() %>" class="btn btn-danger btn-sm">삭제</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <div class="text-center mt-4">
        <a href="memberInsert.do" class="btn btn-primary">회원 등록</a>
    </div>
</div>

