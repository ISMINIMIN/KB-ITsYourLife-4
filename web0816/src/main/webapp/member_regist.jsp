<%@page import="web0816.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDto dto = new MemberDto();
	String name = request.getParameter("name");
	String param_age = request.getParameter("age");
	int age = Integer.parseInt(param_age);
	
	dto.setName(name);
	dto.setAge(age);
%>

<jsp:useBean id="myMem" class="web0816.dto.MemberDto"></jsp:useBean>
<jsp:setProperty property="name" name="myMem" param="name"/> <!-- property(dto class의 변수) 변수명과 param 변수명이 같은 경우 생략 가능 -->
<jsp:setProperty property="age" name="myMem" param="age"/>

<jsp:useBean id="myMem2" class="web0816.dto.MemberDto"></jsp:useBean>
<jsp:setProperty property="*" name="myMem2"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>member_regist.jsp</title>
</head>
<body>
	MemberDto : <%= dto %> <br>
	myMem.name : <jsp:getProperty property="name" name="myMem"/> <br>
	myMem.age : <jsp:getProperty property="age" name="myMem"/> <br>
	myMem2.name : <jsp:getProperty property="name" name="myMem2"/> <br>
	myMem2.age : <jsp:getProperty property="age" name="myMem2"/> <br>
</body>
</html>