<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.projectabc.member.MemberDAO"%>
<%@ page import="com.projectabc.member.Member"%>
<%
	String id = (String)request.getAttribute("id");
	String pass = (String)request.getAttribute("password");
	MemberDAO memberDAO = new MemberDAO();
	Member loginMember =  null;
	
	try{
		loginMember = memberDAO.selectMemberById(id);
	}
	catch(Exception e) {
		%>
		<script>
		alert('입력하신 ID가 존재하지 않습니다.');
		history.go(-1);
		</script>
		<%
	}
	
	if(loginMember.getPassword().equals(pass))
	{
		session.setAttribute("MEMBER", loginMember);
		response.sendRedirect("showProjectList.do?id="+loginMember.getId());
	}else{
		%>
		<script>
			alert('입력하신 PASSWORD가 일치하지 않습니다.');
			history.go(-1);
		</script>
		<%
	}
	

%>