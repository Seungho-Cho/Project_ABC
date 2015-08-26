<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@ page import="com.projectabc.project.Project"%>
<%@ page import="com.projectabc.member.Member"%>


<%
	Member temp_member = new Member();

	temp_member.setId("user1");
	temp_member.setName("username");
	temp_member.setPassword("password");
	temp_member.setMailaddress("user1@email.com");

    %>
</head>
<body>

<p align=center>
		<form action="makeProject.do" method="post" >
			프로젝트 이름 <input type="text" name="projname" size="50"/><br/>
			프로젝트 설명 <textarea name="projcont" rows="5" cols="50"></textarea><br/>
			<input type="hidden" name="managerid" value=<%=temp_member.getId() %> />			
			<input type="submit" value="확인"/>
			<input type="reset" value="취소"/>
		</form>
	</p>
	
		<p align="center"><a href="signup.do">회원 가입</a>
	
</body>
</html>