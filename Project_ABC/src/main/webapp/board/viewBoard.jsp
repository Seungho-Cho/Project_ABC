<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.bitacademy.board.Board"%>
<%@ page import="com.bitacademy.comment.Comment"%>
<%
	Board board=(Board)request.getAttribute("BOARD");
	List<Comment> commentList=(List)request.getAttribute("COMMENT_LIST");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=board.getTitle() %></title>
</head>
<body>
<%--
  request에서 BOARD 객체를 꺼내서
  게시물 번호/제목/내용/첨부파일 이름을 출력
 --%>
	 <table align="center" border="1">
	 	<tr>
			<td width="20"><%=board.getNum() %></td>
			<td width="350"><%=board.getTitle() %></td>
		</tr>
	</table>
	<p align="center"><textarea rows="5" cols="50" readonly="readonly"><%=board.getContent() %></textarea></p>
	<p align="center">첨부파일명:<% if(board.getFilename()!=null) {%>
					<%=board.getFilename()%>
					<form action="downloadBoard.do"  method="post">
						<input type="hidden" name="num" value="<%=board.getNum() %>"/>
						<input type="submit" value="첨부파일다운로드"/>
					</form>					
				<%} %>
	</p>
	<br/>
	<table align="center" border="1">
	<%
		for(Comment comment:commentList) {
			%>
			<tr>
				<td width="350"><%=comment.getComm() %></td>
				<td><%=comment.getWritedate() %></td>
				<td><%=comment.getWriteip() %></td>
			</tr>
			<%
		}
	%>
	</table>
	<br/>
	<p align="center">
		<form action="addComment.do"  method="post">
			<textarea name="comm" rows="5" cols="80"></textarea>
			<input type="hidden"  name="num"  value="<%=board.getNum() %>"/>
			<input type="submit"  value="확인"/>
		</form>
	</p>
	
</body>
</html>