<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>�ζǹ�ȣ��õ for REST</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#f1").submit(function(evt){
				setNumber()
				return false
			})
		})
		
		function setNumber(){
			var options = {
				url : "today_lotto",
				success : function(data){
					$("#msg").html(data)
				},
				error : function(){}
			}
			$.ajax(options)
		}
	</script>
	
</head>
<body>
	<h1>�ζǹ�ȣ��õ</h1>
	<form action="" id="f1">
		<input type="submit" value="������ �ζǹ�ȣ">
	</form>
	<hr>
	<div id="msg"></div>
</body>

</html>