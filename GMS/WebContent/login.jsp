<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>体育馆管理系统登录页面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/signin.css" rel="stylesheet">
</head>
  <body>
    <div class="container">
      <form id="login_form" class="form-signin" action="login.action" method="post">
        <h2 class="form-signin-heading">体育馆管理系统</h2>
        <label for="vUserName" class="sr-only" >用户名</label>
        <input type="text" id="vUserName" class="form-control" placeholder="用户名" name="user.vuserName">
		<label for="vPassword" class="sr-only">密码</label>        
        <input type="password" id="vPassword" class="form-control" placeholder="密码" name="user.vpassward">
        </br>
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="登录" />
		<a href="regist.jsp" id="register_btn" class="">注册一个账号</a>
		<p><span id="login-tips-span">${str_result}</span></p>
      </form>
    </div> 
    
    <script src="js/jquery-2.2.1.min.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/login.js"></script>  
</body>
</html>
