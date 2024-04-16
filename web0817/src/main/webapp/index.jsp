<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MVC Exam</title>
</head>
<body>
	<!-- 폴더를 요청했을 때 가장 먼저 찾는 파일 - 웰컴파일 -->
	<h1>Welcome MVC</h1>
	<%
		String contextPath = request.getContextPath();
	%>
	<a href="<%= contextPath %>/board/insert_form">게시물 등록</a> <br>
	<a href="<%= contextPath %>/board/list">게시물 목록</a> <br>
</body>
</html>