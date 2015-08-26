<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p align=center>
		<form action="tryLogin.do" method="post" enctype="multipart/form-data">
			ID <input type="text" name="id" size="50"/><br/>
			PW <input type="password" name="password" size="50"/><br/>
			<input type="submit" value="확인"/>
			<input type="reset" value="취소"/>
		</form>
	</p>
	
	<p align="center"><a href="signup.do">회원 가입</a>

</body>
</html>