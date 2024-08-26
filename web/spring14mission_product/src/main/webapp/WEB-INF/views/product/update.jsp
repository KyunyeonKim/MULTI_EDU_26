<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
input[type=text], textarea, select {
	padding: 8px 8px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ff8f8f;
	border-radius: 14px;
	box-sizing: border-box;
}

input[type=submit], a {
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

#insertTable td, th {
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

	<h1>제품수정 페이지</h1>
	<jsp:include page="../top_menu.jsp" />
	<div>

		<form action="p_updateOK.do" method="post">
			<table id="insertTable">
				<tr>
					<td><label for="num">NUM</label></td>
					<td>${param.num}<input type="hidden" id="num" name="num"
						value="${param.num}"></td>
				</tr>
				<tr>
					<td><label for="pname">pname</label></td>
					<td><input type="text" id="pname" name="pname"
						value="${vo2.pname}" placeholder="pname를 입력하세요"></td>
				</tr>
				<tr>
					<td><label for="model">model</label></td>
					<td><input type="text" id="model" name="model"
						value="${vo2.model}" placeholder="model를 입력하세요"></td>
				</tr>
				<tr>
					<td><label for="price">price</label></td>
					<td><input type="number" id="price" name="price"
						value="${vo2.price}" min="0" step="1000"
						placeholder="price를 입력하세요"></td>
				</tr>
				<tr>
					<td><label for="count">count</label></td>
					<td><input type="number" id="count" name="count"
						value="${vo2.count}" placeholder="count를 입력하세요"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정완료"></td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>