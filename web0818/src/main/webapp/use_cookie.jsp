<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>쿠키 사용하기</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		String msg = "처음 방문";
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("visited") && cookie.getValue().equals("Y")) {
				msg = "이미 방문";
				break;
			}
		}
	%>
	
	<h1><%= msg %></h1>
</body>
</html>