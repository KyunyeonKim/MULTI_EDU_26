<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
     <style>
    input[type=text],
    textarea,
    select {
      
      padding: 8px 8px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ff8f8f;
      border-radius: 14px;
      box-sizing: border-box;
    }

    input[type=submit] ,a{
      width: 15%;
      background-color: #4CAF50;
      color: white;
      padding: 8px 8px;
      margin: 8px 0px;
      border: none;
      border-radius: 14px;
      cursor: pointer;
    }

    input[type=submit]:hover {
      background-color: #b7e5b9;
    }

    div {
      border-radius: 15px;
      background-color: #f0f0f0;
      margin: 20px;
    }

    #insertTable {
      font-family: Arial, Helvetica, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }

    #insertTable td,th {
      border: 1px solid #ddd;
      padding: 8px;
    }

    #insertTable tr:nth-child(even) {
      background-color: #ebebeb;
    }

    #insertTable tr:hover {
      background-color: #ffc6c6;
    }
  </style>
</head>
<body>
<h1>제품 정보 페이지</h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<div>
<table  id="insertTable">
  <thead>
  <tr>
    <th>NUM</th>
    <th>PNAME</th>
    <th>MODEL</th>
    <th>PRICE</th>
    <th>COUNT</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>${vo2.num}</td>
    <td>${vo2.pname}</td>
    <td>${vo2.model}</td>
    <td>${vo2.price}</td>
    <td>${vo2.count}</td>
  </tr>
  </tbody>
</table>
</div>
<a href="p_update.do?num=${vo2.num}">제품수정</a>
<a href="p_delete.do?num=${vo2.num}">제품삭제</a>
</body>
</html>