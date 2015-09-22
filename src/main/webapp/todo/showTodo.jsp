<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 	
<%@ page import="com.projectabc.project.Project"%>
<%@ page import="com.projectabc.member.Member"%>
<%@ page import="com.projectabc.todo.Todo"%>
<%@ page import="com.projectabc.todo.TodoComment"%>
<%@ page import="java.util.List"%>

<%
	//Project proj = (Project)request.getAttribute("PROJECT");
	List<Member> memList = (List<Member>)request.getAttribute("TODO_MEM_LIST");
	List<TodoComment> commList = (List<TodoComment>)request.getAttribute("TODO_COMM_LIST");
	Todo todo = (Todo)request.getAttribute("TODO");
	Member loginmember = (Member) session.getAttribute("MEMBER");
	String position = (String)session.getAttribute("POSITION");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap -->
<link href="/Project_ABC/todo/bootstrap-combined.min.css" rel="stylesheet">
<script src="/Project_ABC/js/jquery-2.0.3.min.js"></script> 
<script src="/Project_ABC/js/bootstrap.min.js"></script>  

<!-- x-editable (bootstrap version) -->
<link href="/Project_ABC/todo/bootstrap-editable.css" rel="stylesheet"/>
<script src="/Project_ABC/js/bootstrap-editable.min.js"></script>

<script src="/Project_ABC/js/moment-with-locales.js"></script>



 <!-- color picker -->
  <link rel="stylesheet" href="/Project_ABC/css/bootstrap.css">
  <link rel="stylesheet" href="/Project_ABC/css/font-awesome.css">
  <link rel="stylesheet" href="/Project_ABC/css/jquery.simplecolorpicker.css">
  <link rel="stylesheet" href="/Project_ABC/css/jquery.simplecolorpicker-regularfont.css">
  <link rel="stylesheet" href="/Project_ABC/css/jquery.simplecolorpicker-glyphicons.css">
  <link rel="stylesheet" href="/Project_ABC/css/jquery.simplecolorpicker-fontawesome.css">

<script src="/Project_ABC/js/jquery.simplecolorpicker.js"></script>

<!-- Example jQuery code (JavaScript)  -->
<script>

    $(document).ready(function() {
        //toggle `popup` / `inline` mode
        
        $.fn.editable.defaults.mode = 'popup';   
        moment.locale('ko-KO');
        
        //make username editable
        $('#todoName').editable({
        	success: function(response, newValue) {
        		updateTodoElement('name',newValue);
            }
        });
        
        //make status editable
        $('#todoCont').editable({
            type: 'textarea',
            success: function(response, newValue) {
            	updateTodoElement('cont',newValue);
            }
        });
        
        $('#startDate').editable({
            format: 'YYYY-MM-DD',    
            viewformat: 'YYYY-MM-DD',    
            template: 'YYYY / MMMM / D',    
            combodate: {
                    minYear: 2000,
                    maxYear: 2020,
                    minuteStep: 1
               },
            success: function(response, newValue) {
            	var input = newValue.format('YYYY-MM-DD');
            	updateTodoElement('start',input);
            }
        });
        
        $('#endDate').editable({
            format: 'YYYY-MM-DD',    
            viewformat: 'YYYY-MM-DD',    
            template: 'YYYY / MMMM / D',    
            combodate: {
                    minYear: 2000,
                    maxYear: 2020,
                    minuteStep: 1
               },
	        success: function(response, newValue) {
	        	var input = newValue.format('YYYY-MM-DD');
            	updateTodoElement('end',input);
	        }
        });
        
        $('select[name="colorpicker-picker-longlist"]').simplecolorpicker({
  		  picker: true,
  		  theme: 'glyphicons'
  		}).on('change', function() {
  			var color = $('select[name="colorpicker-picker-longlist"]').val();
  		  alert(color);
  		  
  		});
    });

</script>  

<!-- Example jQuery code (JavaScript)  -->
<script type="text/javascript">
function updateTodoElement(e,val){
	
	switch(e)
	{

	case 'name':
    	$.ajax({
    		url: "changeTodo.do",
    		data: {
    			todono: <%=todo.getTodono()%>,
    			todoname: val
    		},
    		dataType:"text",
    		type:"POST",
    		success:function(){
    		},
    		error:function() {
    		}
    	})
    	break;
    	
	case 'cont':
    	$.ajax({
    		url: "changeTodo.do",
    		data: {
    			todono: <%=todo.getTodono()%>,
    			todocont: val
    		},
    		dataType:"text",
    		type:"POST",
    		success:function(){
    		},
    		error:function() {
    		}
    	})
    	break;
    	
	case 'start':
    	$.ajax({
    		url: "changeTodo.do",
    		data: {
    			todono: <%=todo.getTodono()%>,
    			startdate: val
    		},
    		dataType:"text",
    		type:"POST",
    		success:function(){
    		},
    		error:function() {
    		}
    	})
    	break;
    	
	case 'end':
    	$.ajax({
    		url: "changeTodo.do",
    		data: {
    			todono: <%=todo.getTodono()%>,
    			enddate: val
    		},
    		dataType:"text",
    		type:"POST",
    		success:function(){
    		},
    		error:function() {
    		}
    	})
    	break;
	
	}
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
        bo
        rder: 1px solid #bcbcbc;
      }
      #jb-header {
        padding: 20px;
        margin-bottom: 20px;
        border: 1px solid #bcbcbc;
      }
      #jb-content {
        width: 40%;
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
	<form action="deleteTodo.do" method="post" >
		<input type="hidden" name="todono" value=<%=todo.getTodono()%> />
		<input type="submit" value="삭제"/>
	</form>
	<br>
	<a href="#" id="startDate" data-type="combodate" data-pk="1" data-value=<%=todo.getStartdate()%> data-title="Select date"></a>
	<span> ~ </span><a href="#" id="endDate" data-type="combodate" data-pk="1" data-value=<%=todo.getEnddate()%> data-title="Select date"></a>
			
	<select name="colorpicker-picker-longlist">
	  <option value="#ac725e">#ac725e</option>
	  <option value="#d06b64">#d06b64</option>
	  <option value="#f83a22">#f83a22</option>
	  <option value="#fa573c">#fa573c</option>
	  <option value="#ff7537">#ff7537</option>
	  <option value="#ffad46">#ffad46</option>
	  <option value="#42d692">#42d692</option>
	  <option value="#16a765">#16a765</option>
	  <option value="#7bd148">#7bd148</option>
	  <option value="#b3dc6c">#b3dc6c</option>
	  <option value="#fbe983">#fbe983</option>
	  <option value="#fad165">#fad165</option>
	  <option value="#92e1c0">#92e1c0</option>
	  <option value="#9fe1e7">#9fe1e7</option>
	  <option value="#9fc6e7">#9fc6e7</option>
	  <option value="#4986e7">#4986e7</option>
	  <option value="#9a9cff">#9a9cff</option>
	  <option value="#b99aff">#b99aff</option>
	  <option value="#c2c2c2">#c2c2c2</option>
	  <option value="#cabdbf">#cabdbf</option>
	  <option value="#cca6ac">#cca6ac</option>
	  <option value="#f691b2">#f691b2</option>
	  <option value="#cd74e6">#cd74e6</option>
	  <option value="#a47ae2">#a47ae2</option>
	</select>

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
			<input type="text" name="id" size="5"/>
			<input type="hidden" name="todono" value=<%=todo.getTodono()%> />
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