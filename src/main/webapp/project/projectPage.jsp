<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
	<link rel="stylesheet" type="text/css" href="/Project_ABC/project/style.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="/Project_ABC/project/devheart-examples.css" media="screen" />
	
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
	String todoListString = (String)request.getAttribute("TODO_LIST_STRING");
	
%>

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

</head>
<body class="dhe-body">
<header> 
	<h2>
		<form action="-----Todo 검색 -----.do" method="post" >
			<input type="text" name="searchKeyword" size="50"/>           
			<input type="hidden" name="projno" value=<%=proj.getProjno() %> />
			<input type="submit" value="검색"/>
			</form>
	</h2>
		<nav> 
			<!-- 멤버 메뉴 -->
			<%=loginmember.getName()%>(<%=loginmember.getId() %>)
			<button id="button_logout" onclick="location.href='tryLogout.do'">로그아웃</button>
			<%
			////////////////////////////////////////
				//버튼 클릭시 
				//session.invalidate();
				//response.sendRedirect("login.jsp");
				//수행
			///////////////////////////////////////
			%>
			<input type="button" value="새 메세지" onclick="window.open('showMessageList.do','window팝업','width=600, height=600, menubar=no, status=no, toolbar=no');">
		</nav>
	</header>
	
	<aside>  
		<!-- 참여 멤버 목록 -->
		<% 
		for(int i=0; i<memList.size(); i++)
		{
		%>		
			<article><a href="멤버정보?.do"><%=memList.get(i).getName()%>(<%=memList.get(i).getId() %>)</a></article>
		<%
		}
		 %>
		
		<% %>
		<article> 
			<form action="addProjectMember.do" method="post" >
			<input type="text" name="memberid" size="8"/>
			<input type="hidden" name="projno" value=<%=proj.getProjno() %> />
			<input type="submit" value="추가"/>
			</form>
		</article>
	</aside>
	
	
	<section>
		<div id="center-wrapper">
			<div class="dhe-example-section-content">
				<div id="todoList">
				</div>
				<p>
			</div>
		</div>
	</section>
	
	<footer> 
	</footer>

 
<!-- Example JavaScript files -->
<script type="text/javascript" src="/Project_ABC/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/Project_ABC/js/jquery-ui-1.8.custom.min.js"></script>

<!-- Example jQuery code (JavaScript)  -->
<script type="text/javascript">

$(document).ready(function(){
	
	//TodoString 가져와서 동적 생성
	renderItems('<%=todoString%>');		
	
	// todoList 찾아서 드래그앤 드랍 설정
	$('#todoList .sortable-list').sortable({
		connectWith: '#todoList .sortable-list',
		placeholder: 'placeholder',
		
		//항목 이동시 작동
		update: function(){
			updateTodo(getItems('#todoList'));
			//alert(getItems('#todoList'));
		}
	});

});


// Todo 항목들 가져와서 동적 추가
function renderItems(items)
{
	var html = '';

	var columns = items.split(':'); // List로 쪼개기
	
	///////////////////////////////////
	var temp = '<%=todoListString%>';
	var lists = temp.split(',');
	/////////////////////////////////////////
	
	for ( var c in columns )
	{
		var listClass = lists[c].split('@');
		var listno = listClass[0];
		var listname = listClass[1];
		html += '<div class="column left';

		if ( c == 0 )
		{
			html += ' first';
		}

		html += '">'
				+'<a>'+listname+'</a>'
				+'<ul class="sortable-list">';

		if ( columns[c] != '' )
		{
			var items = columns[c].split(','); // Todo로 쪼개기

			for ( var i in items )
			{
				var itemColumns = items[i].split('@'); // Todono, Todoname 쪼개기
				html += '<li class="sortable-item" id="' + itemColumns[0] + 
				'"onclick="window.open(\'showTodo.do?todono='+itemColumns[0]+'\',\'window팝업\',\'width=600, height=600, menubar=no, status=no, toolbar=no\');">' + 
				itemColumns[1]+'</li>';
			}
		}	
		html +='</ul>';
		html +='<form action="addProjectTodo.do" method="post" >'
			+'<input type="text" name="todoname" size="10"/>'
			+'<input type="hidden" name="listno" value='+listno+' />'
			+'<input type="hidden" name="projno" value='+<%=proj.getProjno()%>+' />'
			+'<input type="submit" value="추가"/>'
			+'</form>';
		html +='</div>';
	}
	html += '<br>';
	html +='<td>'
		+'<form action="addProjectTodoList.do" method="post" >'
		+'<input type="text" name="listname" size="10"/>'           
		+'<input type="hidden" name="projno" value='+<%=proj.getProjno() %>+' />'
		+'<input type="submit" value="추가"/>'
		+'</form>'
		+'</td>';
		
	$('#todoList').html(html);
}

//Get items
function getItems(exampleNr)
{
	var columns = [];

	$(exampleNr + ' ul.sortable-list').each(function(){
		columns.push($(this).sortable('toArray').join(','));				
	});

	return columns.join(':');
}

// Todo 업데이트 Post
function updateTodo(items){
	$.ajax({
		url: "updateTodo.do",
		data: {
			todoString: items,
			projno: <%=proj.getProjno()%>
		},
		dataType:"text",
		type:"POST",
		success:function(){
		},
		error:function() {
		}
	})
}

$('#btn-load-example').click(function(){
	alert('<%=todoString%>');
});

</script>
</body>
</html>