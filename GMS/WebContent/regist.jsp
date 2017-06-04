<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>体育馆管理系统注册页面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/signin.css" rel="stylesheet">
</head>
    <div class="container" style="width:600px;">
      <form id="regist_form" class="form-signin" action="regist.action">
        <h2 class="form-signin-heading">体育馆管理系统注册</h2>
        <%-- <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">用户名</span>
		  <input type="text" class="form-control" placeholder="用户名" aria-describedby="basic-addon1" name="user.vuserName">
		</div> --%>
		
        <label for="rvUserName" >用户名</label>
        <input type="text" id="rvUserName" class="form-control" placeholder="用户名" name="user.vuserName">
        <br>
        <label for="rvPassword1" >密码</label>
        <input type="password" id="rvPassword1" class="form-control" placeholder="密码" name="vpassward1">
        <br>
        <label for="rvPassword2" >确认密码</label>
        <input type="password" id="rvPassword2" class="form-control" placeholder="确认密码" name="user.vpassward">
        <br>
        <label for="vEmail" >Email</label>
        <input type="text" id="vEmail" class="form-control" placeholder="Email" name="user.vemail">
        <br>
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="注册" />
        <a href="login.jsp" id="register_btn" class="">返回</a>
        <p><span id="login-tips-span">${str_result}</span></p> 
      </form>
    </div>
    
    <script src="js/jquery-2.2.1.min.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/login.js"></script>  
</body>
</html>
