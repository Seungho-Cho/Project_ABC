<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<p align="center">Login!</p>
	<!--로그인하기전 화면은 tryLogin.jsp-->
	
	<p align=center>
		<form action="tryLogin.do" method="post" enctype="multipart/form-data">
			ID <input type="text" name="id" size="50"/><br/>
			PASSWORD <input type="password" name="password" size="50"/><br/>
			<input type="submit" value="로그인"/>
			<input type="reset" value="취소"/>
		</form>
	<p align="center"><a href="signup.do">회원가입</a></p>

 
</form>
</body>
</html>