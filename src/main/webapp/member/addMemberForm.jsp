<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="ko" >

<script type="text/javascript" 
 src="<%=getServletContext().getContextPath()%>/js/jquery-1.11.3.js"></script>
<script>
$(document).ready(function() {
	$("#id").on("change",function(){
		$.ajax({
			url:"/Project_ABC/idcheck.do",
			type:"post",
			dataType:"text",
			data:{id:$("#id").val()},
			success:function(data){
				$("#idresult").html(data);
			}
		});
    });
 });
</script>

</head>
<body>
	<form 
	   action="addMember.do" method="post">
			<p>
				이름
				<input id="name" name="name" type="text">
			</p>
			<p>
				아이디
				<input id="id" name="id" type="text"/>
				<span id="idresult"></span>
			</p>		
			<p>
				비밀번호
				<input id="password" name="password" type="password"/>
			</p>
			<p>
				메일주소
				<input id="mailaddress" name="mailaddress" type="text"/>
			</p>
			<p>
				<input class="submit" type="submit" value="가입하기">
			</p>		
	</form>
</body>
</html>
