<%@page import="board.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardDto> list = (List)request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board List</title>
	<style>
		table, tr, th, td {
			border: 1px solid black;
			border-collapse : collapse;
			text-align: center;
		}
		
		table {
			width: 80%;
		}
		
		table a {
			text-decoration: none;
			color: black;
			
		}
		
		table a:hover {
			text-decoration: underline;
			color: grey;
		}
	</style>
</head>
<body>
	<h1>게시물 목록</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<%
			for(BoardDto dto : list) {
		%>
		<tr>
			<td><%= dto.getNo() %></td>
			<td><a href="board?command=detail&no=<%= dto.getNo() %>"><%= dto.getTitle() %></td>
			<td><%= dto.getWriter() %></td>
			<td><%= dto.getRegdate() %></td>
		</tr>
		<%
			}
		%>
	</table>
	<hr>
	<a href="/web0818_cp/">메인페이지</a>
</body>
</html>