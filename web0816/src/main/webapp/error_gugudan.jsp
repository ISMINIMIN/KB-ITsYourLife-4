<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
    <!-- isErrorPage="true" : 다른 jsp에서 발생한 예외를 받도록 설정, exception 변수에 예외 저장 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>error_gugudan</title>
</head>
<body>
	<h1>예외정보 : <%= exception.getMessage() %></h1>
	<!-- Forward(포워드) : 주소 변함없이 다른 jsp의 내용을 표시하는 기능 / Redirect(리다이렉트) : 주소를 변경하면서 다른 jsp의 내용을 표시하는 기능 -->
</body>
</html>