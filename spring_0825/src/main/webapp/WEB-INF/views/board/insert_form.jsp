<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시물 등록</title>
</head>
<body>
	<h1>게시물 등록</h1>
	<a href="board_list">게시물 목록</a> <br>
	<br>
	<form action="board_insert_action" method="post">
		<fieldset>
			게시물 제목 : <input type="text" name="title"> <br>
			게시물 작성자 : <input type="text" name="writer"> <br>
			게시물 내용 : <br>
			<textarea rows="3" cols="60" name="content"></textarea> <br>
			<input type="submit" value="등록하기">
		</fieldset>
	</form>
</body>
</html>