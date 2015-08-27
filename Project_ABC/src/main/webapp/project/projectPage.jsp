<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<%@ page import="com.projectabc.project.Project"%>
<%@ page import="com.projectabc.member.Member"%>
<%@ page import="java.util.List"%>

<%
	//Project proj = (Project)request.getAttribute("PROJECT");
	//List<Member> memList = (List<Member>)request.getAttribute("MEM_LIST");
	Project proj = new Project();
	proj.setProjno("1");
%>

<style>
		header { background:yellow; border:2px solid blue;position:relative;
			margin-bottom:10px;}
		nav { background:lime; border:1px solid red;position:absolute;
			right:5px;bottom:2px;width:300px; }
		section { padding:10px;maring:10px;border:1px solid black;
			background:lightgray;width:70%; }
		article { padding:20px;margin:10px;border:1px solid black;
			border-radius:8px;background:beige; }
		aside { float:right;width:20%;background:orange;padding:10px; }
		footer { background:yellow; border:1px solid blue;margin-top:10px;}

	</style>
	

</head>
<body>
<header> 
	<h2>머리말입니다.</h2>
		<nav> 내비게이션 영역. 이전, 이후, 홈</nav>
	</header>
	
	<aside> 
		<article> 멤버1 </article>
		<article> 멤버2 </article>
		<article> 
			<form action="addProjectMember.do" method="post" >
			<input type="text" name="memberid" size="50"/><br/>
			<input type="hidden" name="projno" value=<%=proj.getProjno() %> />
			<input type="submit" value="추가"/>
			</form>
		</article>
	</aside>
	
	
	<section>
		<table align="center" border="1">
	 	<tr>
	 		<td>리스트1</td>
	 		<td>리스트2</td>
	 		<td><a href="addTodoListForm.do">추가</a></td>
	 	</tr>
	 	</table>
	</section>
	<footer> 꼬리말입니다. 회사 연락처 등</footer>

 
</body>
</html>