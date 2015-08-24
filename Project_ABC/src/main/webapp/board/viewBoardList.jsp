<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.bitacademy.board.Board"%>
<%
	List<Board> boardList=(List)request.getAttribute("BOARD_LIST");
	String pageLink=(String)request.getAttribute("PAGE_LINK");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<p align="right"><a href="addCustomerForm.do">회원가입</a></p>
<p align="right">
 검색하기
	<form action="searchBoardList.do" method="post">
		<select name="keyword">
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="filename">첨부파일이름</option>
		</select>
		<input type="text" name="search"/>
		<input type="submit" value="검색"/>
	</form>
</p>
<body>
	<%--
	request에 저장된 BOARD_LIST를 꺼내서
	게시물의 번호/제목/첨부파일명을 출력
	게시물 제목에는
	<a href="viewBoard.do?num=게시물제목">으로 링크가 걸려있음
	request에 저장된 PAGE_LINK를 꺼내서 화면 아래에 출력
	 --%>
	 <table align="center" border="1">
	 	<tr>
	 		<td width="35">번호</td>
	 		<td width="350">제목</td>
	 		<td>첨부파일명</td>
	 	</tr>
		<% for(int i=0;i<boardList.size();i++){
			Board board=boardList.get(i);
		%>
		<tr>
			<td><%=board.getNum()%></td>
			<td><a href="viewBoard.do?num=<%=board.getNum()%>"><%=board.getTitle()%></a></td>
			<td><% if(board.getFilename()!=null) {%>
				<%=board.getFilename()%> <%} %></td>			
		</tr>
		<%}	%>	 	
	 </table>
	 <p align="center"><%=pageLink %></p>	 
	 <p align="center"><a href="addBoardForm.do">게시물 추가</a>
</body>
</html>