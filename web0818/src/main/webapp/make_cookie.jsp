<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>쿠키 생성하기</title>
</head>
<body>
	<%
		Cookie cookie = new Cookie("visited", "Y");
		response.addCookie(cookie);
	%>
	<h1>쿠키 설정</h1>
</body>
</html>