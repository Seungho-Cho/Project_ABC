<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
	<title>jQuery: Customizable layout using drag and drop (examples) - 1. Getting started with sortable lists</title>
	<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="../devheart-examples.css" media="screen" />
	
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
</head>
<body class="dhe-body">

<div id="center-wrapper">
	<div class="dhe-example-section-content">
			<div id="example-1-3">
				<div class="column left first">
					<ul class="sortable-list">
						<li class="sortable-item"><a href="#">Sortable item A</a></li>
						<li class="sortable-item">Sortable item A</li>
						<li class="sortable-item">Sortable item A</li>
						<li class="sortable-item">Sortable item A</li>
						<li class="sortable-item">Sortable item B</li>
					</ul>
				</div>
				<div class="column left">
					<ul class="sortable-list">
						<li class="sortable-item">Sortable item C</li>
						<li class="sortable-item">Sortable item D</li>
					</ul>
				</div>
				<div class="column left">
					<ul class="sortable-list">
						<li class="sortable-item">Sortable item E</li>
					</ul>
				</div>
				<div class="clearer">&nbsp;</div>
			</div>

			<!-- END: XHTML for example 1.3 -->
			<p>
			<input type="submit" class="input-button" id="btn-load-example" value="Insert List" /> &nbsp; 
			

		</div>
	</div>
</div>

<!-- Example JavaScript files -->
<script type="text/javascript" src="jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="jquery-ui-1.8.custom.min.js"></script>

<!-- Example jQuery code (JavaScript)  -->
<script type="text/javascript">

$(document).ready(function(){

	// Example 1.1: A single sortable list
	$('#example-1-1 .sortable-list').sortable();

	// Example 1.2: Sortable and connectable lists
	$('#example-1-2 .sortable-list').sortable({
		connectWith: '#example-1-2 .sortable-list'
	});

	// Example 1.3: Sortable and connectable lists with visual helper
	$('#example-1-3 .sortable-list').sortable({
		connectWith: '#example-1-3 .sortable-list',
		placeholder: 'placeholder',
	});

	// Example 1.4: Sortable and connectable lists (within containment)
	$('#example-1-4 .sortable-list').sortable({
		connectWith: '#example-1-4 .sortable-list',
		containment: '#containment'
	});

});

</script>

</body>
</html>