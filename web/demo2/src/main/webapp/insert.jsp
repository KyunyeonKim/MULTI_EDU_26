<%--
  Created by IntelliJ IDEA.
  User: kgn47
  Date: 2024-07-29
  Time: 오후 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Board Item</title>
</head>
<body>
<h1>Insert Board Item</h1>
<form action="insert.do" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br>
    <label for="content">Content:</label>
    <textarea id="content" name="content" rows="4" cols="50" required></textarea><br>
    <input type="submit" value="Submit">
</form>
<a href="top_menu.jsp">Back to Menu</a>
</body>
</html>
