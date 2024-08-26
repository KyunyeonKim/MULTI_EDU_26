<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="home.do">HOME</a>
<c:if test="${user_id==null}">aaaaaa</c:if>
<a href="login.do">login</a>
<a href="logout.do">logout</a>
<h1>${user_id}</h1>
<h1>${name}</h1>
</body>
</html>