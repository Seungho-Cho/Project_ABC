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
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

 
</body>
</html>