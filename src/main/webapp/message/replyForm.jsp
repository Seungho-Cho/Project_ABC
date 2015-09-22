<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@ page import="com.projectabc.message.Message"%>
<%@ page import="com.projectabc.member.Member"%>


<%
	Message mes = (Message)request.getAttribute("MESSAGE");
	Member member = (Member)session.getAttribute("MEMBER");
 %>
</head>
<body>

<p align=center>
		<form action="sendMessage.do" method="post" >
			제목 <input type="text" name="mesgtitle" size="50"/><br/>
			내용 <textarea name="mesgcont" rows="5" cols="50"></textarea><br/>
			<input type="hidden" name="sendid" value="<%=member.getId() %>" />
			<input type="hidden" name="recvid" value="<%=mes.getRecvid()%>"/>
			<input type="submit" value="확인"/>
			<input type="reset" value="취소"/>
		</form>
	</p>
</body>
</html>