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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>
    $(function(){
    	console.log("ready....");
    	$("#btn_idCheck").click(function(){
    		console.log("click....");
    		 //2.제이쿼리 비동기통신 방법으로 구현하세요
            let url2 = "http://localhost:8088/member/api/json_idCheck.do";
            $.ajax({
              url:url2,
              type:"get",
              data:{id:$("#id").val()},
              dataType:"json",
              success:function(response){
                console.log(response);
                let message = '';
                if(response.result === 'OK'){
                  message = '사용가능';
                }else{
                  message = '중복된 아이디';
                }
                $("#result").html(message);
              },
              error:function(ex){
                console.log(ex);
              }
            });
    	});
    });
    
   
  </script>
</head>

<body>
	<h1>회원가입 페이지</h1>
	<jsp:include page="../top_menu.jsp" />
	<div>

		<form action="m_insertOK.do" method="post"
			enctype="multipart/form-data">
			<table id="insertTable">
				<tr>
					<td><label for="id">ID</label></td>
					<td><input type="text" id="id" name="id" value="admin"
						placeholder="ID를 입력하세요">
					<input type="button" id="btn_idCheck" value="idCheck">
          <span id="result">사용가능 or 중복된 아이디</span>	
					</td>
				</tr>
				<tr>
					<td><label for="pw">PW</label></td>
					<td><input type="text" id="pw" name="pw" value="hi1111"
						placeholder="PW를 입력하세요"></td>
				</tr>

				<tr>
					<td><label for="name">NAME</label></td>
					<td><input type="text" id="name" name="name" value="kim"
						placeholder="NAME를 입력하세요"></td>
				</tr>
				<tr>
					<td><label for="tel">TEL</label></td>
					<td><input type="text" id="tel" name="tel" value="010"
						placeholder="TEL를 입력하세요"></td>
				</tr>
				<tr>
					<td><label for="file">FILE</label></td>
					<td><input type="file" id="file" name="file"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="가입완료"></td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>