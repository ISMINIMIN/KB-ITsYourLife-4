<%@page import="java.util.TreeSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	private TreeSet<Integer> lotto = new TreeSet<>();
	public String prn() {
		return "prn()";
	}
%>
<%  // 스크립트릿
	while(lotto.size() < 6) {
		// lotto.add((int)(Math.random() * 45 + 1));
		lotto.add(new java.util.Random().nextInt(45) + 1);
	}
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로또번호 추천 JSP</title>
</head>
<body>
	<h1>오늘의 로또번호</h1>
	<h2><%= lotto %></h2> <!-- 익스프레션(표현식) -->
	<h2><%= prn() %></h2>
</body>
</html>