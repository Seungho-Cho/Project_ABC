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

<script src="/Project_ABC/js/jquery-1.11.3.js"></script>

<!-- bootstrap -->
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script> 
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>  

<!-- x-editable (bootstrap version) -->
<link href="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.4.6/bootstrap-editable/css/bootstrap-editable.css" rel="stylesheet"/>
<script src="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.4.6/bootstrap-editable/js/bootstrap-editable.min.js"></script>

<script>
    $(document).ready(function() {
        //toggle `popup` / `inline` mode
        $.fn.editable.defaults.mode = 'inline';     
        
        //make username editable
        $('#todoName').editable({
        	success: function(response, newValue) {
                postTest(newValue);
            }
        });
        
        //make status editable
        $('#todoCont').editable({
            type: 'textarea',
            success: function(response, newValue) {
                postTest(newValue);
            }
        });
    });
    
    
    function postTest(value)
    {
    	alert(value);
    }
</script>


<style type="text/css">
      #main {
        width: 800px;
      }
      p.editable, span.editable {
        background-color : #FFA;
        padding : 3px;
      }
      input.editable {
      }
      div {
        margin : 15px;
      }
</style>

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
        padding: 10px;
        margin-bottom: 10px;
        float: left;
        border: 1px solid #bcbcbc;
      }
      #jb-sidebar {
        width: 30%;
        padding: 5px;
        margin-bottom: 5px;
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
	<a href="#" id="todoName" data-type="text" data-placement="center" data-title="제목 변경"><%=todo.getTodoname()%></a>	     
</div>
<div id="jb-content">
	<a href="#" id="todoCont" data-type="textarea" data-placement="center" data-title="내용 변경"><%=todo.getTodocont()%></a>				        		
</div>
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
			<input type="hidden" name="todono" value=<%=todo.getTodono()%>/>
			<input type="submit" value="추가"/>
			</form>
		</article>
		<%
		} 
		%>

</div>

  <div id="jb-footer">
  	<table>
  	<% for(int i=0; i<commList.size(); i++)
	{
  		TodoComment comm = commList.get(i);
	%>
		<tr>
			<td><%= comm.getMemid() %></td>
			<td><%= comm.getCommdate() %></td>
			<td><%= comm.getComm() %></td>
		</tr>
	<%
	}
	%>
	<form action="addTodoComm.do" method="post" >
		<input type="text" name="comm" size="40"/>
		<input type="hidden" name="todono" value=<%=todo.getTodono()%> />
		<input type="hidden" name="memid" value=<%=loginmember.getId()%> />
		<input type="submit" value="추가"/>	
	</form>
  	</table>
 </div>

</div>
</body>
</html>