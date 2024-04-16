<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>action_include</title>
</head>
<body>
	<%
		String name = "홍길동";
	%>

	<h1>Include Action</h1>
	<%@ include file="top_menu.jsp" %> <!-- include 지시자 : 소스 결합 후 페이지 실행 -->

	<hr>
	<jsp:include page="top_menu2.jsp"></jsp:include> <!-- include 액션 : jsp가 실행된 후 결과 문자열과 페이지 결합 -->
</body>
</html>