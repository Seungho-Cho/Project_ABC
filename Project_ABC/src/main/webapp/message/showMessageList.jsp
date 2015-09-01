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
	List<Message> mesList=(List)request.getAttribute("MESSAGE_LIST");
	Member loginMember = (Member)session.getAttribute("MEMBER");

%>

</head>
<body>
 <table align="center" border="1">
	 	<tr>
	 		<td width="50">보내는 사람</td>
	 		<td width="300">내용</td>
	 		<td>날짜</td>
	 	</tr>
		<% 
			for(int i=0;i<mesList.size();i++){
			Message mes=mesList.get(i);
		%>
		<tr>
			<td><%= mes.getSendid()%></td>
			<td><%=mes.getMesgcont() %></a></td>
			<td><%= mes.getSenddate()%></td>		
		</tr>
		<%}	%>
		<tr>
			<td></td>
			<td><p align="center"><a href="sendMessageForm.do">메세지 보내기</a></td>
		</tr>
	 </table>
	 
</body>
</html>