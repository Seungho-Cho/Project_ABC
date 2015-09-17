<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
	<link rel="stylesheet" type="text/css" href="/Project_ABC/project/dragStyle.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="/Project_ABC/project/devheart-examples.css" media="screen" />
	<link type="text/css" rel="stylesheet" href="/Project_ABC/css/style.css" />
	
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
	String position = (String)session.getAttribute("POSITION");
	
	String todoString = (String)request.getAttribute("TODO_STRING");
	String todoListString = (String)request.getAttribute("TODO_LIST_STRING");
	
%>

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
        width: 80%;
        padding: 20px;
        margin-bottom: 20px;
        float: left;
        border: 1px solid #bcbcbc;
      }
      #jb-sidebar {
        width: 10%;
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


</head>
<body>
<div id="jb-container">
	<div id="jb-header">
		<h2>
			<form action="-----Todo 검색 -----.do" method="post" >
				<input type="text" name="searchKeyword" size="50"/>           
				<input type="hidden" name="projno" value=<%=proj.getProjno() %> />
				<input type="submit" value="검색"/>
			</form>
		</h2>
		<a href='calendar.do?projno=<%=proj.getProjno()%>'>달력</a>
		<div> 
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
		</div>
	</div>
		
	<div id="jb-sidebar">  
		<% 
		for(int i=0; i<memList.size(); i++)
		{
		%>		
			<div><a href="멤버정보?.do"><%=memList.get(i).getName()%>(<%=memList.get(i).getId() %>)</a></div>
		<%
		}
		 %>
		 
		<%if("0".equals(position))
		{
		%>
		<div> 
			<form action="addProjectMember.do" method="post" >
			<input type="text" name="memberid" size="5"/>
			<input type="hidden" name="projno" value=<%=proj.getProjno() %> />
			<input type="submit" value="추가"/>
			</form>
		</div>
		<%
		} 
		%>
	</div>
		
		
	<div id="jb-content">
		<div id="center-wrapper" style="overflow:scroll; white-space:nowrap;">
		</div>
	</div>
	
	<div id="jb-footer">
	</div>
	
</div>
 
<!-- Example JavaScript files -->
<script type="text/javascript" src="/Project_ABC/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/Project_ABC/js/jquery-ui-1.8.custom.min.js"></script>

<!-- Example jQuery code (JavaScript)  -->
<script type="text/javascript">

$(document).ready(function(){
	
	//TodoString 가져와서 동적 생성
	renderItems('<%=todoString%>');		
	
	// todoList 찾아서 드래그앤 드랍 설정
	$('#center-wrapper .sortable-list').sortable({
		connectWith: '#center-wrapper .sortable-list',
		placeholder: 'placeholder',
		
		//항목 이동시 작동
		update: function(){
			updateTodo(getItems('#center-wrapper'));
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
				'"onClick="window.open(\'showTodo.do?todono='+itemColumns[0]+'\',\'window팝업\',\'width=600, height=600, menubar=no, status=no, toolbar=no\');">' + 
				itemColumns[1] + '</li>';
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
		
	$('#center-wrapper').html(html);
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