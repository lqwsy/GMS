<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>体育馆管理系统/用户中心/添加用户</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>
<!-- jsp包含头部-->
<jsp:include page="common_header.jsp"/>
<div class="container">
	<div class="row">
    	<!--jsp包含用户管理左侧导航栏-->
    	<jsp:include page="usermanger_navi.jsp"/>
        
        <!-- 添加用户模块-->
        <div class="col-sm-10" >
            <div class="page-header"><!-- 包含标题-->
              <h1>用户中心 <small>添加管理员</small></h1>
            </div>
           <form class="form-horizontal" id="adduserform" action="adduser.action"><!--包含内容-->
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label uneditable-input" for="newusername">用户名</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="newusername" name="newusername">
                </div>
              </div>
              
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label uneditable-input" for="newuserpassword1">密码</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="newuserpassword1" name="newuserpassword1" >
                </div>
              </div>
              
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label uneditable-input" for="newuserpassword">确认密码</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="newuserpassword" name="newuserpassword">
                </div>
              </div>
              
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="roleId">用户类型</label>
                <div class="col-sm-5">
                    <select class="form-control" name="roleId">
					  	<option value="1">超级管理员</option>
					  	<option value="2">赛事管理员</option>
					  	<option value="3">场地管理员</option>
					  	<option value="4">器材管理员</option>
					</select>
                </div>
              </div>
              
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5" id="surecancel">
                  <button type="submit" class="btn btn-primary" >添加</button>
                </div>
              </div>
              
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                	<p><span id="login-tips-span">${str_result}</span></p>
                </div>
              </div>
            </form>
        </div>
        
    </div>
    <!-- jsp包含页面脚部 -->
    <jsp:include page="common_footer.jsp"/>
</div>

<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/usermanger.js"></script>
</body>
</html>
