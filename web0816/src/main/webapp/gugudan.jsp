<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error_gugudan.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>구구단</title>
</head>
<body>
	<%
		String dan = request.getParameter("dan");
		int my_dan = Integer.parseInt(dan);
		for(int i=1; i<10; i++) {
			// out.print(dan * i + "<br>");
	%>
		<%= my_dan %> x <%= i %> = <%= my_dan * i %> <br>
	<%
		}
	%>
</body>
</html>