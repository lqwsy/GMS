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
      <li role="presentation" class="active" ><a href="#">用户中心</a></li>
      <li role="presentation" id="userinfo"><a href="#">个人资料</a></li>
      <li role="presentation" id="changepass"><a href="#">更改密码</a></li>
      <s:if test="#session.cur_user.roleinfo.iroleId==1">
      	<li role="presentation" id="usermanger"><a href="#">管理用户</a></li>
      	<li role="presentation" id="adduser"><a href="#">添加用户</a></li>
      </s:if>     
    </ul>
</div>
</body>
</html>
