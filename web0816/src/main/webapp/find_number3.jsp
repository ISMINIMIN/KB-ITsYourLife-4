<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! 
	int com_num = new java.util.Random().nextInt(100) + 1;
%>
    
<%
	String num = request.getParameter("num");
	int my_num = Integer.parseInt(num);
%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>숫자맞추기게임 정답확인</title>
</head>
<body>
	<%
		String url = "";
		if(com_num == my_num) {
			url = "find_number_right.jsp";
		} else if(com_num > my_num) {
			url = "find_number_up.jsp";
		} else {
			url = "find_number_down.jsp";
		}
		
		// Redirect
		response.sendRedirect(url);
	%>
</body>
</html>