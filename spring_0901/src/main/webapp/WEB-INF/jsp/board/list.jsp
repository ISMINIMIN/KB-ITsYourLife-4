<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>�� �Խ��� ���</title>
</head>
<body>
	<table>
		<tr>
			<th>��ȣ</th>
			<th>����</th>
			<th>�ۼ���</th>
		</tr>
		<c:forEach items="${board_list}" var="b">
		<tr>
			<td>${b.no}</td>
			<td>${b.title}</td>
			<td>${b.writer}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>