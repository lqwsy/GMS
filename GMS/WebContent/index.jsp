<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>开始页面</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/loginpage.css" rel="stylesheet" />
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>

<!--  
            基础知识：  
            网格系统:通过行和列布局  
            行必须放在container内  
            手机用col-xs-*  
            平板用col-sm-*  
            笔记本或普通台式电脑用col-md-*  
            大型设备台式电脑用col-lg-*  
            为了兼容多个设备，可以用多个col-*-*来控制；  
        --> 

<div class="container">  
        <div class="form row">  
            <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="login_form">  
                <h3 class="form-title">登录</h3>  
                <div class="col-sm-9 col-md-9">  
                    <div class="form-group">  
                        <i class="fa fa-user fa-lg"></i>  
                        <input class="form-control required" type="text" placeholder="Username" name="username" autofocus="autofocus" maxlength="20"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-lock fa-lg"></i>  
                            <input class="form-control required" type="password" placeholder="Password" name="password" maxlength="8"/>  
                    </div>  
                    <div class="form-group">  
                        <hr />  
                        <a href="javascript:;" id="register_btn" class="">创建一个账户</a>  
                    </div>  
                    <div class="form-group">  
                        <input type="submit" class="btn btn-success pull-right" value="Login "/>     
                    </div>  
                </div>  
            </form>  
        </div>  
  
        <div class="form row">  
            <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="register_form">  
                <h3 class="form-title">注册</h3>  
                <div class="col-sm-9 col-md-9">  
                    <div class="form-group">  
                        <i class="fa fa-user fa-lg"></i>  
                        <input class="form-control required" type="text" placeholder="Username" name="username" autofocus="autofocus"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-lock fa-lg"></i>  
                            <input class="form-control required" type="password" placeholder="Password" id="register_password" name="password"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-check fa-lg"></i>  
                            <input class="form-control required" type="password" placeholder="Re-type Your Password" name="rpassword"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-envelope fa-lg"></i>  
                            <input class="form-control eamil" type="text" placeholder="Email" name="email"/>  
                    </div>  
                    <div class="form-group">  
                        <input type="submit" class="btn btn-success pull-right" value="Sign Up "/>  
                        <input type="submit" class="btn btn-info pull-left" id="back_btn" value="Back"/>  
                    </div>  
                </div>  
            </form>  
        </div>  
</div> 


<script src="js/loginpage.js"></script>
</body>
</html>