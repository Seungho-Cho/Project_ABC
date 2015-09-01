<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<%@ page import="com.projectabc.project.Project"%>
<%@ page import="com.projectabc.member.Member"%>
<%@ page import="com.projectabc.todo.Todo"%>
<%@ page import="com.projectabc.todo.TodoList"%>
<%@ page import="java.util.List"%>

<%
	Project proj = (Project)request.getAttribute("PROJECT");
	List<Member> memList = (List<Member>)request.getAttribute("MEM_LIST");
	List<List<Todo>> todo = (List<List<Todo>>)request.getAttribute("TODO");
	List<TodoList> todoList = (List<TodoList>)request.getAttribute("TODO_LIST");
	Member loginmember = (Member) session.getAttribute("MEMBER");
%>

<style>
		header { background:yellow; border:2px solid blue;position:relative;
			margin-bottom:10px;}
		nav { background:lime; border:1px solid red;position:absolute;
			right:5px;bottom:2px;width:300px; }
		section { padding:10px;maring:10px;border:1px solid black;
			background:lightgray;width:70%; height:100%}
		article { padding:20px;margin:10px;border:1px solid black;
			border-radius:8px;background:beige; }
		aside { float:right;width:20%;background:orange;padding:10px; }
		footer { background:yellow; border:1px solid blue;margin-top:10px;}

	</style>
	<script>
	</script>
	

</head>
<body>
<header> 
	<h2>
		<form action="-----Todo 검색 -----.do" method="post" >
			<input type="text" name="searchKeyword" size="50"/>           
			<input type="hidden" name="projno" value=<%=proj.getProjno() %> />
			<input type="submit" value="검색"/>
			</form>
	</h2>
		<nav> 
			<%=loginmember.getName()%>(<%=loginmember.getId() %>)
			<button id="button_logout">로그아웃</button>
			<%
			////////////////////////////////////////
				//버튼 클릭시 
				//session.invalidate();
				//response.sendRedirect("login.jsp");
				//수행
			///////////////////////////////////////
			%>
			<input type="button" value="새 메세지" onclick="window.open('/message/showMessageList.jsp','window팝업','width=600, height=600, menubar=no, status=no, toolbar=no');">
		</nav>
	</header>
	
	<aside> 
		<% 
		for(int i=0; i<memList.size(); i++)
		{
		%>		
			<article><a href="멤버정보?.do"><%=memList.get(i).getName()%>(<%=memList.get(i).getId() %>)</a></article>
		<%
		}
		 %>
		<article> 
			<form action="addProjectMember.do" method="post" >
			<input type="text" name="memberid" size="10"/>
			<input type="hidden" name="projno" value=<%=proj.getProjno() %> />
			<input type="submit" value="추가"/>
			</form>
		</article>
	</aside>
	
	
	<section>
		<table align="center" border="1">
		<tr>
		<% 
		for(int i=0; i<todoList.size(); i++)
		{
		%>			
	 		<td>
	 			<%= todoList.get(i).getListname() %>	
	 		</td>
	 	<%
		}
		 %>
	 		<td>
	 			<form action="addProjectTodoList.do" method="post" >
					<input type="text" name="listname" size="10"/>           
					<input type="hidden" name="projno" value=<%=proj.getProjno() %> />
					<input type="submit" value="추가"/>
				</form>
			</td>
	 	</tr>
	 	<tr>
	 		<% 
			for(int i=0; i<todo.size(); i++)
			{
			%>			
	 		<td>
	 			<table>
				 		<% 
						for(int j=0; j<todo.get(i).size(); j++)
						{
						%>
		 				<tr>
		 					<td>
		 						<%=todo.get(i).get(j).getTodoname() %>
		 					</td>
						</tr>
	 					<%
						}
						%>
					<tr>
						<td>
				 			<form action="addProjectTodo.do" method="post" >
								<input type="text" name="todoname" size="10"/>           
								<input type="hidden" name="listno" value=<%=todoList.get(i).getListno() %> />
								<input type="hidden" name="projno" value=<%=todoList.get(i).getProjno() %> />
								<input type="submit" value="추가"/>
							</form>
						</td>
	 				</tr>
	 			</table>	
	 		</td>
		 	<%
			}
			%>
	 	</tr>
	 	</table>
	</section>
	<footer> 꼬리말</footer>

 
</body>
</html>