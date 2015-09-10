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
        width: 60%;
        height:auto;
        padding: 20px;
        margin-bottom: 20px;
        float: left;
        border: 1px solid #bcbcbc;
      }
      #jb-sidebar {
        width: 20%;
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
      

<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<div id="jb-container">
<div id="jb-header">
<span id="todoName"><%=todo.getTodoname()%></span>
</div>
<div id="jb-content"><%=todo.getTodocont()%></div>
<div id="jb-sidebar">
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

</div>

  <div id="jb-footer"></div>

</div>
</body>
</html>