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

<a href="index2.do">index2.do</a>
<hr>
<c:forEach var="i" begin="1" end="10">
  반복문
</c:forEach>
<hr>
<c:forEach var="i" begin="1" end="10">
  ${i}
</c:forEach>
<hr>
<c:forEach var="i" begin="1" end="10" step="2">
  ${i}
</c:forEach>

<hr>
<c:forEach var="i" begin="1" end="10">
  <c:if test="${i>5}">${i}</c:if>
</c:forEach>
<hr>
<c:set var="start" value="1"/>
<c:set var="stop" value="5"/>
<c:forEach var="i" begin="${start}" end="${stop}">
  <a href="b_selectAll.do?cpage=${i}">${i}</a>
</c:forEach>
<hr>
<c:set var="result" value="3"/>
<c:choose>
  <c:when test="${result==1}">Good</c:when>
  <c:when test="${result==2}">Hello</c:when>
  <c:when test="${result==3}">Bye</c:when>
  <c:when test="${result==4}">
    <c:redirect url="index2.jsp"/>
  </c:when>
  <c:when test="${result==5}">
    <c:redirect url="index2.do"/>
  </c:when>
  <c:otherwise>otherwise</c:otherwise>
</c:choose>

<hr>
<c:catch var="ex">
  <%
    int[] sus = new int[5];
    out.print(sus[5]);
  %>
</c:catch>
${ex}
<hr>

<c:set var="name" value="kim"/>
이름 : ${name}
<hr>
<c:remove var="name"/>
이름 : ${name}
<hr>
<c:set var="su" value="33"/>
<h3>${su == 33}</h3>
<h3>${su >= 33}</h3>
<h3>${su <= 33}</h3>
<h3>${su > 33}</h3>
<h3>${su < 33}</h3>
<h3>${su != 33}</h3>

<hr>
<c:set var="name" value="kim"/>
<h3>${name == 'kim'}</h3>
<h3>${name != 'kim'}</h3>


<hr>

<c:forEach var="vo" items="${list}">
  ${vo.name},${vo.age}<br>
</c:forEach>

</body>
</html>