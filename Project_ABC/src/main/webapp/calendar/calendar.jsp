<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력</title>
<link href='/Project_ABC/css/fullcalendar.css' rel='stylesheet' />
<link href='/Project_ABC/css/fullcalendar.print.css' rel='stylesheet' media='print' />

<%@ page import="com.projectabc.todo.Todo"%>
<%@ page import="java.util.List"%>
<%
	List<Todo> todoList=(List<Todo>)request.getAttribute("TODO_LIST");
%>

<script src='/Project_ABC/js/moment.js'></script>
<script src='/Project_ABC/js/jquery-1.7.1.min.js'></script>
<script src='/Project_ABC/js/fullcalendar.min.js'></script>
<script>

	$(document).ready(function() {

		$('#calendar').fullCalendar({
			eventLimit: true, // allow "more" link when too many events
			events: [
			    <%
			    if(todoList!=null) {
				    for(Todo todo:todoList) {
				    	//Todo todo=todoList.get(i);
				    	if(todo.getStartdate()!=null) {
				    %>
					{
						title: '<%=todo.getTodoname()%>',
						allDay: true,
						color: '#f00',
						start: '<%=todo.getStartdate()%>'
						<%
							if(!todo.getStartdate().equals(todo.getEnddate())) {
						%>
						, end: '<%=todo.getEnddate()%>'
						<%
							}
						%>
					},
				<% }}}%>
			]
		});
		
	});

</script>
<style>

	body {
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}

</style>
</head>
<body>

	<div id='calendar'></div>

</body>
</html>
