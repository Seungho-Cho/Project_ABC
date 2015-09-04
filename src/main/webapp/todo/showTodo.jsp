<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 	
<%@ page import="com.projectabc.project.Project"%>
<%@ page import="com.projectabc.member.Member"%>
<%@ page import="com.projectabc.todo.Todo"%>
<%@ page import="com.projectabc.todo.TodoComment"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>

<%
	Project proj = (Project)request.getAttribute("PROJECT");
	List<Member> todoMemList = (List<Member>)request.getAttribute("TODO_MEM_LIST");
	Todo todo = (Todo)request.getAttribute("TODO");
	List<TodoComment> commList = (List<TodoComment>)request.getAttribute("COMM_LIST");
	Member loginmember = (Member) session.getAttribute("MEMBER");	
%>

<style>
		header { background:yellow; border:2px solid blue;position:relative;
			margin-bottom:10px;}
		nav { background:lime; border:1px solid red;position:absolute;
			right:5px;bottom:2px;width:300px; }
		section { padding:10px;maring:10px;border:1px solid black;
			background:lightgray;width:80%; height:100%}
		article { padding:20px;margin:10px;border:1px solid black;
			border-radius:8px;background:beige; }
		aside { float:right;width:20%;background:orange;padding:10px; }
		footer { background:yellow; border:1px solid blue;margin-top:10px;}
</style>

</head>
<body>
<aside>  
		<% 
		for(int i=0; i<todoMemList.size(); i++)
		{
		%>		
			<article><a href="멤버정보?.do"><%=todoMemList.get(i).getName()%>(<%=todoMemList.get(i).getId() %>)</a></article>
		<%
		}
		 %>
	<article> 
		<form action="addTodoMember.do" method="post" >
		<input type="text" name="memberid" size="10"/>
		<input type="hidden" name="todono" value=<%=todo.getTodono()%> />
		<input type="submit" value="추가"/>
		</form>
	</article>
</aside>
 
</body>
</html>