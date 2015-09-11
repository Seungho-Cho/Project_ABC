<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.projectabc.storage.StorageBoard" %>
<%@page import="com.projectabc.storage.StorageComment" %>
<%
	StorageBoard storageBoard=(StorageBoard)request.getAttribute("STORAGEBOARD");
	List<StorageComment>storageCommentList=(List)request.getAttribute("STORAGECOMMENT_LIST");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=storageBoard.getTitle() %></title>
</head>
<body>
	 <table align="center" border="1">
	 	<tr>
			<td width="20"><%=storageBoard.getBoardno() %></td>
			<td width="50"><%=storageBoard.getMemid() %></td>
			<td width="100"><%=storageBoard.getWritedate() %></td>
			<td width="350"><%=storageBoard.getTitle() %></td>
		</tr>
	</table>
	<p align="center"><textarea rows="5" cols="50" readonly="readonly"><%=storageBoard.getContent() %></textarea></p>
	<p align="center">첨부파일명:<% if(storageBoard.getFilename()!=null) {%>
					<%=storageBoard.getFilename()%>
					<form action="downloadStorageBoard.do"  method="post">
						<input type="hidden" name="num" value="<%=storageBoard.getBoardno() %>"/>
						<input type="submit" value="첨부파일다운로드"/>
					</form>					
				<%} %>
	</p>
	<br/>
	<table align="center" border="1">
	<%
		for(StorageComment storageComment:storageCommentList) {
			%>
			<tr>
				<td width="350"><%=storageComment.getComm() %></td>
				<td><%=storageComment.getWritedate() %></td>
				<td><%=storageComment.getMemid() %></td>
			</tr>
			<%
		}
	%>
	</table>
	<br/>
	<p align="center">
		<form action="addComment.do"  method="post">
			<textarea name="comm" rows="5" cols="80"></textarea>
			<input type="hidden"  name="num"  value="<%=storageBoard.getBoardno()%>"/>
			<input type="submit"  value="확인"/>
		</form>
	</p>
	
</body>
</html>