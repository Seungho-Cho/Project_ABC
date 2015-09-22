<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.projectabc.storage.StorageBoard"%>
<%
	List<StorageBoard> storageBoardList=(List)request.getAttribute("STORAGEBOARD_LIST");
	String pageLink=(String)request.getAttribute("PAGE_LINK");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자료실</title>
</head>
<p align="right">
 검색하기
	<form action="searchStorageBoardList.do" method="post">
		<select name="keyword">
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="memid">작성자</option>
			<option value="filename">첨부파일이름</option>
		</select>
		<input type="text" name="search"/>
		<input type="submit" value="검색"/>
	</form>
</p>
<body>
<table align="center" border="1">
	 	<tr>
	 		<td width="35">번호</td>
	 		<td width="350">제목</td>
	 		<td>첨부파일명</td>
	 	</tr>
		<% for(int i=0;i<storageBoardList.size();i++){
			StorageBoard storageboard=storageBoardList.get(i);
		%>
		<tr>
			<td><%=storageboard.getBoardno()%></td>
			<td><a href="viewStorageBoard.do?num=<%=storageboard.getBoardno()%>"><%=storageboard.getTitle()%></a></td>
			<td><% if(storageboard.getFilename()!=null) {%>
				<%=storageboard.getFilename()%> <%} %></td>			
		</tr>
		<%}	%>	 	
	 </table>
	 <p align="center"><%=pageLink %></p>	 
	 <p align="center"><a href="addStorageBoardForm.do">게시물 추가</a>
</body>
</html>