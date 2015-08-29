<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		
		session.invalidate();
		response.sendRedirect("login.jsp");
// 로그인 후 로그아웃 버튼을 눌렀을 경우 invalidate()를 해서 정보를 지워용
%>