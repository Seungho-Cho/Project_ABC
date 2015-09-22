<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 추가</title>

<%@ page import="com.projectabc.member.Member"%>

<%
	Member member = (Member)session.getAttribute("MEMBER");
 %>
 
</head>
<body>
	<p align=center>
		<form action="addStorageBoard.do" method="post" enctype="multipart/form-data">
			제목 : <input type="text" name="title" size="50"/><br/>
			<textarea name="content" rows="5" cols="50"></textarea><br/>
			<input type="file" name="file"/><br/>
			<input type="hidden" name="memid" value="<%=member.getId() %>" />
			<input type="submit" value="확인"/>
			<input type="reset" value="취소"/>
		</form>
</body>
</html>