<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>게시글 작성</title>
</head>
<body>
<h1>게시글 작성</h1>
<jsp:include page="top_menu.jsp"/>
<br/>
<form action="b_insertOk.do" method="post"> <!-- POST 방식으로 변경 -->
  <label for="title">제목:</label><br/>
  <input type="text" id="title" name="title" required/><br/><br/>

  <label for="content">내용:</label><br/>
  <textarea id="content" name="content" rows="10" cols="30" required></textarea><br/><br/>

  <label for="author">작성자:</label><br/>
  <input type="text" id="author" name="author" required/><br/><br/>

  <input type="submit" value="작성"/>
</form>
<br/>
<a href="index.jsp">HOME</a>
</body>
</html>
