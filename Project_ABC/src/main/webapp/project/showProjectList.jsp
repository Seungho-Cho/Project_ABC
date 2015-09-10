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
<link type="text/css" rel="stylesheet" href="/Project_ABC/css/style.css" />

<%
	List<Project> projList=(List)request.getAttribute("PROJ_LIST");
	Member loginMember = (Member)session.getAttribute("MEMBER");

%>

<style>
      #jb-container {
        width: 0px auto;
        margin: 0px auto;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }
      #jb-header {
        padding: 20px;
        margin-bottom: 20px;
        border: 1px solid #bcbcbc;
      }
      #jb-content {
        width: 80%;
        padding: 20px;
        margin-bottom: 20px;
        float: left;
        border: 1px solid #bcbcbc;
      }
      #jb-sidebar {
        width: 10%;
        padding: 20px;
        margin-bottom: 20px;
        float: right;
        border: 1px solid #bcbcbc;
      }
      #jb-footer {
        clear: both;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }
    </style>

</head>
<body>
<div id="jb-container">
      <div id="jb-header">
      </div>
      <div id="jb-content">
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
<<<<<<< HEAD
	 <br/>
	 <a href="#">파일 업로드</a>
	 <br/>
	 <a href="listTest.do">List Test</a>
=======
</div>
<div id="jb-sidebar"></div>
<div id="jb-footer"></div>
	 
</div>
>>>>>>> branch 'master' of https://github.com/Seungho-Cho/Project_ABC
</body>
</html>