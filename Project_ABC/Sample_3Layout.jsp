<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>3Layout Sample Page입니당</title>
</head>
<style>
      #jb-container {
        width: 940px;
        margin: 0px auto;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }
      #jb-header {
        padding: 20px;
        margin-bottom: 20px;
        border: 1px solid #bcbcbc;
      }
      #jb-sidebar-left {
        width: 160px;
        padding: 20px;
        margin-right: 20px;
        margin-bottom: 20px;
        float: left;
        border: 1px solid #bcbcbc;
      }
      #jb-content {
        width: 450px;
        padding: 20px;
        margin-bottom: 20px;
        float: left;
        border: 1px solid #bcbcbc;
      }
      #jb-sidebar-right {
        width: 160px;
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
        <h1>상단헤더임</h1>
      </div>
      <div id="jb-sidebar-left">
        <h2>사이드바임</h2>
        <ul>
          <li>사</li>
          <li>이</li>
          <li>드</li>
          <li>바</li>
        </ul>
      </div>
      <div id="jb-content">
        <h2>Main Box</h2>
        <p>Main Contents자리</p>
        <p>Project_ABC의 Sample Page임</p>
      </div>
      <div id="jb-sidebar-right">
        <h2>역시사이드바</h2>
        <ul>
          <li>여기도</li>
          <li>사</li>
          <li>이</li>
          <li>드</li>
          <li>바</li>
        </ul>
      </div>
      <div id="jb-footer">
        <p>여기는풋터자리</p>
      </div>
    </div>
</body>
</html>