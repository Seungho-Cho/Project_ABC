<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 	
<%@ page import="com.projectabc.project.Project"%>
<%@ page import="com.projectabc.member.Member"%>
<%@ page import="com.projectabc.todo.Todo"%>
<%@ page import="com.projectabc.todo.TodoComment"%>
<%@ page import="java.util.List"%>

<%
	Project proj = (Project)request.getAttribute("PROJECT");
	List<Member> memList = (List<Member>)request.getAttribute("TODO_MEM_LIST");
	List<TodoComment> commList = (List<TodoComment>)request.getAttribute("TODO_COMM_LIST");
	Todo todo = (Todo)request.getAttribute("TODO");
	Member loginmember = (Member) session.getAttribute("MEMBER");
	String position = (String)session.getAttribute("POSITION");
%>


<!DOCTYPE html>
<html>
<head>

<style>
		header { background:yellow; border:2px solid blue;position:relative;
			margin-bottom:10px;}
		nav { background:lime; border:1px solid red;position:absolute;
			right:5px;bottom:2px;width:300px; }
		section { padding:10px;maring:10px;border:1px solid black;
			background:lightgray;width:90%; height:100%}
		article { padding:10px;margin:5px;border:1px solid black;
			border-radius:8px;background:beige; }
		aside { float:right;width:10%;background:orange;padding:10px; }
		footer { background:yellow; border:1px solid blue;margin-top:10px;}
</style>

<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<header><%=todo.getTodoname()%>
<nav></nav>
<section><%=todo.getTodocont()%></section>
<aside>
		<% 
		for(int i=0; i<memList.size(); i++)
		{
		%>		
			<article><a href="멤버정보?.do"><%=memList.get(i).getName()%>(<%=memList.get(i).getId() %>)</a></article>
		<%
		}
		 %>
		 
		<%if("0".equals(position))
		{
		%>
		<article> 
			<form action="addTodoMember.do" method="post" >
			<input type="text" name="memberid" size="5"/>
			<input type="hidden" name="todono" value=<%=todo.getTodono() %> />
			<input type="submit" value="추가"/>
			</form>
		</article>
		<%
		} 
		%>

</aside>
</header>
<footer></footer>
</body>
</html>