<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ page import="com.projectabc.message.Message"%>
<%@ page import="com.projectabc.member.Member"%>
<%@ page import="java.util.List"%>

<%
	Message mes = (Message)request.getAttribute("MESSAGE");
	Member loginMember = (Member)session.getAttribute("MEMBER");
%>

</head>
<body>
 <table align="center" border="1">
 	 	<tr>
	 		<td>보낸사람</td>
	 		<td><%=mes.getSendid() %></td>
	 	</tr>
	 	<tr>
	 		<td>제목</td>
	 		<td><%=mes.getMesgtitle() %></td>
	 	</tr>
	 	<tr>	
	 		<td>내용</td>
	 		<td><%=mes.getMesgcont() %></td>
	 	</tr>
	 </table>
	 <a href="replyForm.do?mesgno=<%=mes.getMesgno()%>">답장 보내기</a>
</body>
</html>