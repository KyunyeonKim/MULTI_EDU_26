<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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
<p><a href="findOne.do?age=11">findOne.do</a></p>
<p><a href="searchList.do?searchKey=name&searchWord=nn">searchList.do-name</a></p>
<p><a href="searchList.do?searchKey=phone&searchWord=10">searchList.do-phone</a></p>

<p><a href="searchList2.do?searchKey=phone&searchWord=10&page=1&limit=3">1페이지 - searchList2.do-phone</a></p>
<p><a href="searchList2.do?searchKey=phone&searchWord=10&page=2&limit=3">2페이지 - searchList2.do-phone</a></p>


<p><a href="searchList3.do?age1=3&age2=6">searchList3.do- age &gt;= 3 and age = 6</a></p>
<p><a href="searchList4.do?age1=3&age2=6">searchList4.do- age = 3 or(in) age = 6</a></p>

<p><a href="insertOneOK.do?age=101&name=kim1&office=multi1&phone=0201">insertOneOK.do</a></p>
<p><a href="insertManyOK.do">insertManyOK.do</a></p>
<p><a href="updateOneOK.do?age=102&name=yang2&office=multi2&phone=0222">updateOneOK.do</a></p>
<p><a href="updateManyOK.do?age=102&name=aaa&office=bbb&phone=010">updateManyOK.do - 102 이상 모두변경</a></p>
<p><a href="deleteOneOK.do?age=101">deleteOneOK.do</a></p>
<p><a href="deleteManyOK.do?age=101">deleteManyOK.do- 101 이상 모두삭제</a></p>


</body>
</html>
