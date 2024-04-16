<%@page import="board.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDto dto = (BoardDto)request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board Detail</title>
</head>
<body>
	<h1>상세보기</h1>
	<p>번호 : <%= dto.getNo() %></p>
	<p>제목 : <%= dto.getTitle() %></p>
	<p>작성자 : <%= dto.getWriter() %></p>
	<p>내용 : <%= dto.getContent() %></p>
	<p>작성일 : <%= dto.getRegdate() %></p>
	
	<a href="board?command=list">목록</a>
	<a href="board?command=update_form&no=${dto.no}">수정</a>
	<a href="board?command=delete_form&no=${dto.no}">삭제</a>
</body>
</html>