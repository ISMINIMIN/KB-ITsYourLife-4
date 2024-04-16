<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! 
	int com_num = new java.util.Random().nextInt(100) + 1;
%>
    
<%
	int num = Integer.parseInt(request.getParameter("num"));
%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>숫자맞추기게임 정답확인</title>
</head>
<body>
	<%
		if(com_num == num) {
	%>
	<h1><%= num %> : 추카추카, 정답입니다.</h1>	
	<%
		} else if(com_num > num) {
	%>
	<h1><%= num %> : 올려주세요.</h1>
	<%
		} else {
	%>
	<h1><%= num %> : 내려주세요.</h1>
	<%
		}
	%>
</body>
</html>