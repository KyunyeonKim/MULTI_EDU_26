<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
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

<h1>샘플등록 페이지</h1>
<jsp:include page="top_menu.jsp"/>
<div>
  
  <form action="s_insertOK.do" method="post" enctype="multipart/form-data">
    <table id="insertTable">
      <tr>
        <td><label for="pname">pname</label></td>
        <td><input type="text" id="pname" name="pname" value="BMW" placeholder="pname를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="model">model</label></td>
        <td><input type="text" id="model" name="model" value="B119" placeholder="model를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="price">price</label></td>
        <td><input type="number" id="price" name="price" value="3000" min="0" step="1000" placeholder="price를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="count">count</label></td>
        <td><input type="number" id="count" name="count" value="10" placeholder="count를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="user_id">user_id</label></td>
        <td><input type="text" id="user_id" name="user_id" value="admin1" placeholder="user_id를 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="file">file</label></td>
        <td><input type="file" id="file" name="file"></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="등록완료"></td>
      </tr>
    </table>
  </form>
</div>
</body>

</html>