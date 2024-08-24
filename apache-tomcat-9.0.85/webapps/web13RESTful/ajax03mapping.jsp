<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("ready.....");

		$.ajax({
			url : "http://localhost:8090/web13RESTful/rest05mapping.do",
			type : "get",
			data : {name:"lee길동",age:33},
			dataType : "json",
			success : function(obj){
				console.log(obj);
				$("#result").html(obj.result);
			},
			error:function(xhr,status){
				console.log("status...",status);
			}
		});

	});
</script>
</head>
<body>
	<h1>ajax03mapping.jsp</h1>
	<h3 id="result"></h3>
</body>
</html>