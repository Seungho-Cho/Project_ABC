<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("ID");
	String pass = request.getParameter("PASSWORD");


	if(id.equals("project") && pass.equals("abc")){	
		session.setAttribute("loginId", "project");
		response.sendRedirect("login.jsp");
		//member가 id와 password를 입력
		//초기 id: project pw: abc
	
	
	}else{
		%>
			<script>
				alert('입력하신 ID나 PASSWORD가 일치하지 않습니다.낫매취');
				history.go(-1);
			</script>
		<%
	}
	//member가 입력한 정보와 check - if/else
%>