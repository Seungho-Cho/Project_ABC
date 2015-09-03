<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
	<link rel="stylesheet" type="text/css" href="/Project_ABC/example/csh/test/1/style.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="/Project_ABC/example/csh/test/devheart-examples.css" media="screen" />
	
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
	
	String todoString = (String)request.getAttribute("TODO_STRING");
%>

</head>
<body>
<body class="dhe-body">
	<div id="center-wrapper">
		<div class="dhe-example-section-content">
			<div id="todoList">
			</div>

			<!-- END: XHTML for example 1.3 -->
			<p>
			<input type="submit" class="input-button" id="btn-load-example" value="Insert List" /> &nbsp; 
			

		</div>
	</div>


<!-- Example JavaScript files -->
<script type="text/javascript" src="/Project_ABC/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/Project_ABC/js/jquery-ui-1.8.custom.min.js"></script>

<!-- Example jQuery code (JavaScript)  -->
<script type="text/javascript">

$(document).ready(function(){
	
	renderItems('<%=todoString%>');
	
	$('#todoList .sortable-list').sortable({
		connectWith: '#todoList .sortable-list',
		placeholder: 'placeholder',
	});
	
	

});

function renderItems(items)
{
	var html = '';

	var columns = items.split('|');
	
	for ( var c in columns )
	{
		html += '<div class="column left';

		if ( c == 0 )
		{
			html += ' first';
		}

		html += '"><ul class="sortable-list">';

		if ( columns[c] != '' )
		{
			var items = columns[c].split(',');

			for ( var i in items )
			{
				var itemColumns = items[i].split('@');
				html += '<li class="sortable-item" id="' + itemColumns[0] + 
				'"> <a href="showTodo.do?todono='+ itemColumns[0] +'">' + 
				itemColumns[1] + '</a></li>';
			}
		}

		html += '</ul></div>';
	}
	html += '<br>';

	$('#todoList').html(html);
}

$('#btn-load-example').click(function(){
	alert('<%=todoString%>');
});

</script>
 
</body>
</html>