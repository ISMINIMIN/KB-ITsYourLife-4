<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>���ڸ��߱���� for REST</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#f1").submit(function(evt){
				//�ڵ鷯�޼��尡 false ��ȯ�� �����ൿ�� ���ϰ� ���°�
				// evt.preventDefault()
				sendNumber()
				return false // ���� ��� ���
			})
		})
		function sendNumber(){
			var n1 = $("#n1").val() //�Է��� ����
			var options = {
				url : "check_number.ng?no="+n1,
				success : function(data){
					$("#msg").html(data.msg)
				},
				error : function(){}
			}
			$.ajax(options)
		}
	</script>
	
</head>
<body>
	<h1>���ڸ��߱� ����</h1>
	<h3>1~100���� ���ڸ� ���� ������~</h3>
	<form action="" id="f1">
		<fieldset>
			<legend>�����Է�</legend>
			<label>
				���� : <input id="n1" type="number" placeholder="1~100">
				<input type="submit" value="����Ȯ��">
			</label>
		</fieldset>
	</form>
	<div id="msg"></div>
</body>

</html>