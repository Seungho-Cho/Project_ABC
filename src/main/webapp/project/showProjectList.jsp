<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ page import="com.projectabc.project.Project"%>
<%@ page import="com.projectabc.member.Member"%>
<%@ page import="java.util.List"%>

<%
	List<Project> projList=(List)request.getAttribute("PROJ_LIST");
	Member loginMember = (Member)session.getAttribute("MEMBER");

%>

</head>
<body>
 <table align="center" border="1">
	 	<tr>
	 		<td width="35">번호</td>
	 		<td width="350">프로젝트 이름</td>
	 		<td>생성일</td>
	 		<td>매니저</td>
	 	</tr>
		<% 
			for(int i=0;i<projList.size();i++){
			Project proj=projList.get(i);
		%>
		<tr>
			<td><%= proj.getProjno()%></td>
			<td><a href="projectPage.do?projno=<%=proj.getProjno()%>"><%=proj.getProjname()%></a></td>
			<td><%= proj.getMakedate() %></td>	
			<td><%= proj.getManagerid() %></td>			
		</tr>
		<%}	%>
		<tr>
			<td></td>
			<td><p align="center"><a href="makeProjectForm.do">프로젝트 생성</a></td>
		</tr>
	 </table>
	 <a href="listTest.do">List Test</a>
</body>
</html>