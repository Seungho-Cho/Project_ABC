<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>2Layout Sample Pageㅇ입니당</title>
</head>
<style>
      #jb-container {
        width: 900px;
        margin: 0px auto;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }
      #jb-header {
        padding: 20px;
        margin-bottom: 20px;
        border: 1px solid #bcbcbc;
      }
      #jb-content {
        width: 500px;
        padding: 20px;
        margin-bottom: 20px;
        float: left;
        border: 1px solid #bcbcbc;
      }
      #jb-sidebar {
        width: 260px;
        padding: 20px;
        margin-bottom: 20px;
        float: right;
        border: 1px solid #bcbcbc;
      }
      #jb-footer {
        clear: both;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }
    </style>
<body>
<div id="jb-container">
      <div id="jb-header">
      <div style="overflow:scroll; white-space:nowrap;">
        <h2>상단Header</h2>
        <p>상단헤더에 스크롤바 적용해보기</p>
        <p>가능한가여?</p>
        <p>가능하네여</p>
        <p>ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ이렇게 길게텍스트를쓰면 아마 스크롤바가 밑에도 생길듯</p>
      </div>
      </div>
      <div id="jb-content">
        <h1>Main Box</h1>
        <h2>Project_ABC의 Sample Page임</h2>
        <p>H1값/H2값/P값</p>
      </div>
      <div id="jb-sidebar">
        <h2>Sidebar</h2>
        <ul>
          <li>사이드바자리당</li>
          <p>li로 하면 앞에 점이생기고 p로하면그냥이렇게 텍스트</p>
        </ul>
      </div>
      <div id="jb-footer">
      <div style="overflow:scroll;">
        <h2>여기는풋터자리</h2>
        <p>지금 상단헤더하고 다른점이 뭐냐면</p>
        <p>ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ</p>
        <p>이렇게 길게 텍스트를 쳐도 밑에 스크롤바가 안생기고 텍스트가 그냥 다음 줄로 넘어가게 하는 방법이 있고 스크롤바가생겨서 옆으로 밀어서 보게하는게있나바여</p>
        <p>그러니까 창크기를 확대or축소 했을때 스크롤바를 어느걸 적용하냐에 따라 다르게 쓸수있을거같네여!</p>
      </div>
    </div>
    </div>
</body>
</html>