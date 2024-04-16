<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>숫자맞추기게임</title>
</head>
<body>
	<form action="number_check" method="post">
		<fieldset>
			1~100 사이 숫자 입력 : 
			<input type="number" min="1" max="100" name="num">
			<br>
			<input type="submit" value="정답확인">
		</fieldset>
	</form>
	<div id="result">${result}</div>
</body>
</html>