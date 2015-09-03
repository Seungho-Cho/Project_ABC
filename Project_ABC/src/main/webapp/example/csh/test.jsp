<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<script src="/Project_ABC/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/Project_ABC/js/jquery.blockUI.js"></script>
</head>
<body>

	<input type="button" id="btn" value="DoModal"/>
	<div id="question" style="display:none; cursor:pointer;">
	<h1>모달창확인</h1>
	<input type="button" id="closebtn" value="닫기" />	
	</div>
	
	<script>
		$(function(){
			$("#btn").click(function(){
				$.blockUI({
					message: //MESSAGE HERE!!!
					,css:{
						width:'300px'
					}
					,onOverlayClick:$.unblockUI
				});
			})
			$("#closebtn").click(function(){
				$.unblockUI();
			})
		});
	</script>
	
</body>
</html>