<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="ko" >
<script type="text/javascript" src="/Project_ABC/js/jquery-1.11.3.js"></script>
<script>
$(document).ready(function() {
	$("#id").on("change",function(){
		$.ajax({
			url:"/Project_ABC/idcheck.do",
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
<link type="text/css" rel="stylesheet" href="/Project_ABC/member/addMemberFormStyle.css" />
</head>


	<!--여기부터바디다-->
	
    <body>
        <div class="container">
        <br><br><br><br>
 
                <span class="right">
                </span>
                <div class="clr"></div>

            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="addMember.do" method="post" autocomplete="on"> 
                                <h1>Project_ABC</h1> 
                                <p>
                                이름 ;
                                <input id="name" name="name" type="text" placeholder="Write Your Name."/>
                                </p>
                                <p>
                                아이디 ;
                                <input id="id" name="id" type="text" placeholder="Write Your Using ID."/>
                                <span id="idresult"></span>
                                </p>	
                                <p>
                                비밀번호 ;
                                <input id="password" name="password" type="password" placeholder="Write Your Using PWD."/>
                                </p>
                                <p>
                                메일주소 ;
                                <input id="mailaddress" name="mailaddress" type="text" placeholder="Write Your Using Mail Address."/>
                                </p>
                                <p>
                                <input class="submit" type="submit" value="회원가입">
                                </p>
                                <p>
								</p>
                                <p class="change_link">
									회원이시라면 로그인 해주세요
									<a href="#toregister" >LogIN</a>
								</p>
                            </form>
                        </div>				
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
