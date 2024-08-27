<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>JSP - Hello World</title>
</head>
<body>
	<h1>게시글 삭제 페이지</h1>
	<br />
	<div>
		<form action="m_deleteOK.do" method="post">
			<input type="hidden" name="num" value="${param.num}">
			<table id="insertTable">
				<tr>
					<th>${param.num}번회원을 정말 삭제하시겠습니까?<input type="submit" value="삭제완료"></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>