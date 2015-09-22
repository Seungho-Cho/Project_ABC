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
<style>
#a{
	
	
}
</style>
</head>
<body>
 <table id="a" align="center" border="1">
	 	<tr>
	 		<td width="150">보낸사람</td>
	 		<td width="350">제목</td>
	 		<td>날짜</td>
	 	</tr>
		<% 
			for(int i=0;i<mesList.size();i++){
			Message mes=mesList.get(i);
			if("0".equals(mes.getIsread())){
		%>
		
		<tr>
			<h1>
			<td><font color="red"><%= mes.getSendid()%></font></td>
			<td ><font color="red"><a href="messagePage.do?mesgno=<%=mes.getMesgno()%>"><%=mes.getMesgtitle()%></a></font></td>
			<td><font color="red"><%= mes.getSenddate() %></font></td>
			</h1>			
		</tr>
		<%} else {
			%>
		
		<tr style="color:black">
			<h2>
			<td><font color="black"><%= mes.getSendid()%></font></td>
			<td><font color="black"><a href="messagePage.do?mesgno=<%=mes.getMesgno()%>"><%=mes.getMesgtitle()%></a></font></td>
			<td><font color="black"><%= mes.getSenddate() %></font></td>
			</h2>			
		</tr>
			<%}	}%>
	 </table>
	 <a href="sendMessageForm.do">메세지 보내기</a>
</body>
</html>