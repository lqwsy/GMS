<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>

<body>
<div class="col-sm-2">
    <ul class="nav nav-pills nav-stacked">
      <li role="presentation" class="active" ><a href="#">公告中心</a></li>
      <li role="presentation" ><a href="announcement_apply.jsp">查看公告</a></li>
      <s:if test="#session.cur_user.roleinfo.iroleId==1">
      	<li role="presentation" ><a href="announcement_adder.jsp">添加公告</a></li>
      	<li role="presentation" ><a href="searchannouncements.action">公告管理</a></li>
      </s:if>     
    </ul>
</div>
</body>
</html>
