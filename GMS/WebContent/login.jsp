<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Signin</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/signin.css" rel="stylesheet">
  </head>
                
  <body>
    <div class="container">
      <form class="form-signin">
        <h2 class="form-signin-heading">体育馆管理系统</h2>
        <label for="inputEmail" class="sr-only">UserName</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="UserName" name="user.vUserName">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="user.vPassword">
        </br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		<a href="#">创建一个账户</a>
      </form>
    </div> 
    <script src="js/jquery-2.2.1.min.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
