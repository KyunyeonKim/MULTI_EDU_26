<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<p><a href="findAll.do">findAll.do</a></p>
<p><a href="findAll2.do?page=1&limit=3">1페이지 - findAll2.do : skip , limit</a></p>
<p><a href="findAll2.do?page=2&limit=3">2페이지 - findAll2.do : skip , limit</a></p>
<p><a href="findAllDoc.do">findAllDoc.do</a></p>

<p><a href="findOne.do?num=5">findOne.do</a></p>
<p><a href="searchList.do?searchKey=name&searchWord=ki">searchList.do-name</a></p>
<p><a href="searchList.do?searchKey=tel&searchWord=02">searchList.do-tel</a></p>

<p><a href="searchList2.do?searchKey=tel&searchWord=02&page=1&limit=3">1페이지 - searchList2.do-tel</a></p>
<p><a href="searchList2.do?searchKey=tel&searchWord=02&page=2&limit=3">2페이지 - searchList2.do-tel</a></p>

<p><a href="searchList3.do?num1=2&num2=5">searchList3.do- num &gt;= 2 and num = 5</a></p>
<p><a href="searchList4.do?num1=2&num2=5">searchList4.do- num = 2 or(in) num = 5</a></p>


<p><a href="insertOneOK.do?num=6&id=admin77&pw=hi1111&name=kim1&tel=0201">insertOneOK.do</a></p>
<p><a href="insertManyOK.do">insertManyOK.do</a></p>
<p><a href="updateOneOK.do?num=2&id=aaaa&pw=bbb&name=yang2&tel=0222">updateOneOK.do</a></p>
<p><a href="updateManyOK.do?num=6&id=aaaa&pw=bbb&name=yang2&tel=0222">updateManyOK.do 6이상 모두 변경</a></p>
<p><a href="deleteOneOK.do?num=3">deleteOneOK.do</a></p>
<p><a href="deleteManyOK.do?num=6">deleteManyOK.do 6이상 모두삭제</a></p>
</body>
</html>
