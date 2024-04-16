<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board Delete Form</title>
</head>
<body>
	<form action="board" method="post">
		<h1>상세보기</h1>
		<p>번호 : ${dto.no}</p>
		<p>제목 : ${dto.title}</p>
		<p>작성자 : ${dto.writer}</p>
		<p>내용 : ${dto.content}</p>
		<p>작성일 : ${dto.regdate}</p>
		<hr>
		<p>게시물을 정말 삭제하시겠습니까?</p>
		<input type="hidden" name="command" value="delete_action">
		<input type="hidden" name="no" value="${dto.no}">
		<input type="submit" value="게시물 삭제">
		<a href="board?command=list">게시물 목록으로 돌아가기</a>
	</form>
</body>
</html>