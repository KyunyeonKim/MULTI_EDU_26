<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>게시글 상세 페이지</title>
</head>
<body>
<h1>게시글 상세 페이지</h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<table border="1">
  <thead>
  <tr>
    <th>글번호</th>
    <th>글제목</th>
    <th>글내용</th>
    <th>작성자</th>
    <th>작성일자</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>${vo2.num}</td>
    <td>${vo2.title}</td>
    <td>${vo2.content}</td>
    <td>${vo2.writer}</td>
    <td>${vo2.wdate}</td>
  </tr>
  </tbody>
</table>
<a href="b_update.do?num=${vo2.num}">게시글수정</a>
<a href="b_delete.do?num=${vo2.num}">게시글삭제</a>
<br/><br/>

<!-- 댓글 목록 -->
<h2>댓글 목록</h2>
<table border="1">
  <thead>
  <tr>
    <th>댓글번호</th>
    <th>댓글내용</th>
    <th>작성자</th>
    <th>작성일자</th>
    <th>삭제</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="comment" items="${commentsList}">
    <tr>
      <td>${comment.commentId}</td>
      <td>${comment.commentContent}</td>
      <td>${comment.commenter}</td>
      <td>${comment.commentDate}</td>
      <td><a href="c_deleteOK.do?num=${comment.commentId}&boardNum=${vo2.num}">삭제</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<!-- 댓글 작성 폼 -->
<h2>댓글 작성</h2>
<form action="c_insertOK.do" method="post">
  <input type="hidden" name="boardNum" value="${vo2.num}"/>
  <p>
    <label>댓글 내용:</label>
    <textarea name="content" rows="4" cols="50"></textarea>
  </p>
  <p>
    <label>작성자:</label>
    <input type="text" name="writer"/>
  </p>
  <p>
    <input type="submit" value="댓글 추가"/>
  </p>
</form>

<a href="b_selectAll.do">게시글 목록으로 돌아가기</a>
</body>
</html>
