<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="ko" >

<script type="text/javascript" 
 src="<%=getServletContext().getContextPath()%>/js/jquery-1.11.3.js"></script>
<script>
$(document).ready(function() {
   <%--4.1 단대를 클릭했을때 호출되는 메서드 
   ajax2.jsp 와 ajax3.jsp 참고해서 구현할것
   id 속성의 값이 colno인 객체를 선택했을 때 서버로 요청 전송되는 부분
   --%>
	$("#colno").on("change",function(){
		$("#deptno").empty();
		<%--
			AJAX로 자바클래스 호출
			A. url:/프로젝트명/viewDeptList.do
			B. data:{colno:id 속성의 값이 colno인 객체에서 선택한 값 $("#colno").val() }
			C. 요청 방식:post	
			E. 응답 데이터의 처리 (ajax3.jsp 를 참조해서 구현할것)
				i. 응답 데이터에서 "dept" 태그를 찾아서
				ii	deptno 태그의 값을 자바스크리트 변수에 저장
				iii dname 태그의 값을 자바스크립트 변수에 저장
					서버에서 전달된 데이터를 id 속성의 값이 deptno 인 객체에 추가한다
				ii. 추가할때는 <option value=ii변수>iii변수</option>으로 추가한다.
		--%>
		$.ajax({
			url:"/exam_20150817/viewDeptList.do",
			type:"post",
			data:{colno:$("#colno").val()},
			success:function(data){
				$(data).find("dept").each(
					function(){
						var dname=$(this).find("dname").text();
						var deptno=$(this).find("detpno").text();
						$("#deptno").append("<option value="+deptno+">"+dname+"</option>");
					});
				}		  
			}		 
		);
	});
   
	<%-- 
		5-1 아이디를 입력하고 다른 부분을 클릭했을때 호출되는 메서드
		입력한 아이디를 사용해도 되는지 
		아이디가 idresult인 객체에 출력
		ajax2.jsp 를 참조해서 작성할것
	--%>
	$("#id").on("change",function(){
    <%--   	  
		A. url:/프로젝트명/idcheck.do
		B. data:{id:id 속성의 값이 id인 객체에서 입력한 값 $("#id").val() }
		C. 요청 방식:post
		E. 응답 데이터의 처리
			i. 서버에서 전달된 데이터를 id 속성의 값이 idresult 인 객체에 출력한다
  				$("#idresult").html(서버에서 응답한 데이터);
	--%>
		$.ajax({
			url:"/exam_20150817/idcheck.do",
			type:"post",
			dataType:"text",
			data:{id:$("#id").val()},
			success:function(data){
				$("#idresult").html(data);
			}
		});
    });
  
 });
</script>

</head>
<body>
	<form 
	   action="addMember.do" method="post">
			<p>
				이름
				<input id="name" name="name" type="text">
			</p>
			<p>
				아이디
				<input id="id" name="id" type="text"/>
				<span id="idresult"></span>
			</p>		
			<p>
				비밀번호
				<input id="password" name="password" type="password"/>
			</p>
			<p>
				메일주소
				<input id="mailaddress" name="mailaddress" readonly="readonly"/>
			</p>
			<p>
				<input class="submit" type="submit" value="Submit">
			</p>		
	</form>
</body>
</html>
