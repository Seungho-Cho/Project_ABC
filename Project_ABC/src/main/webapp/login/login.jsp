<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="UTF-8">
<title>Login</title>
<link type="text/css" rel="stylesheet"  href="style.css"/>

</head>
<body>

<div class="container">
<section id="content">
	<!--로그인하기전 화면은 tryLogin.jsp-->
	<!--placeholder는 네모틀안에 글씨를 넣어주는거예여! -->
	
	<form action="tryLogin.do" method="post" enctype="multipart/form-data">
			<h1>Project_ABC</h1>
				<div><input type="text" placeholder="USER_ID" id="userID"></div>
				<div><input type="password" placeholder="PASSWORD" id="password"></div>
				<div>
					<input type="submit" value="Login" />
					<a href="#">ID/PW찾기</a>
					<a href="signup.do">회원가입</a>
				</div>
		</form>
		</section>
		</div>
		</body>
</html>