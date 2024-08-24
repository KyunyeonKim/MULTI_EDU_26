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
			url : "http://localhost:8090/web13RESTful/rest03selectOne.do",
			type : "get",
			data : {},
			dataType : "json",// xml,html,text....
			success : function(responseText,status){
				console.log(responseText,status);
				$("#num").html(responseText.num);
				$("#name").html(responseText.name);
				$("#age").html(responseText.age);
			},
			error:function(xhr,status){
				console.log("xhr...",xhr);
				console.log("status...",status);
				
			}
		});

	});
</script>
</head>
<body>
	<h1>ajax01object.jsp</h1>
	<h3 id="num">num:</h3>
	<h3 id="name">name:</h3>
    <h3 id="age">age:</h3>
</body>
</html>