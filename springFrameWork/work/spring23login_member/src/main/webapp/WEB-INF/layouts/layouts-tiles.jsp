<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/style2.css">
</head>
<body>
<div id="header">
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
</div>
<div id="content">
	<tiles:insertAttribute name="content"></tiles:insertAttribute>
</div>
<div id="footer">
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
	
</body>
</html>