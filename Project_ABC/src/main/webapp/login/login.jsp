<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<%
	//로그인이 안된 상태에서 아이디/암호를 넣고 project/abc일 경우
	//session에 loginId 에 로그인한 유저의 아이디를 저장하고 
	//로그인-로그인 이후의 화면:login2 
	//로그인 이후 화면에서 로그아웃 버튼을 누르면 session.invalidate()를
	//이용해서 세션 정보를 모두 없앰! 그후에 로그인 페이지로
	//돌아오면 원래 login 화면으로 돌아와요 근데 확인을 못해봤어요..톰캣을깔았는데
	//ㅂㅇ화벽을 없애도안돌아ㅏㄱ여..이미친컴퓨터..
	//login.jsp : 본화면
	//loginForm.jsp : 로그인 trigger: if-else
	//loginForm2.jsp : 로그인
	//loginForm3.jsp : 로그아웃
	//아모르겠다..
%>
</head>
<body>
<% 	String loginId = (String)session.getAttribute("loginId");
%>
<% 	if(loginId == null){	
%>
<p align="center">Login!</p>
	<!--로그인하기전 화면은 tryLogin.jsp-->
	
	<p align=center>
		<form action="tryLogin.jsp" method="post" enctype="multipart/form-data">
			ID <input type="text" name="id" size="50"/><br/>
			PASSWORD <input type="password" name="password" size="50"/><br/>
			<input type="submit" value="로그인"/>
			<input type="reset" value="취소"/>
		</form>
	<p align="center"><a href="signup.do">회원가입</a></p>

<% }else { %>
<hr>


<form action="tryLogout.jsp" method="post" enctype="multipart/form-data">	<!--  로그인된화면:그러니까logout을 누르기전 -->
	
	<br>
	<p align=right>
	(<%=loginId %>)님, 환영합니다</p>
	<br/>
	<br><input type="submit" value="로그아웃"><br/>
		<br>(<%=loginId %>)님 <br/>
		<br>회원정보수정<br/>
		
<% }%>
</form>
</body>
</html>