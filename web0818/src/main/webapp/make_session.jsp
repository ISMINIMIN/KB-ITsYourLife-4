<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>세션 생성하기</title>
</head>
<body>
	<%
		session.setAttribute("myname", "HONG");
	%>
	<h1>myname에 HONG 저장</h1>
</body>
</html>