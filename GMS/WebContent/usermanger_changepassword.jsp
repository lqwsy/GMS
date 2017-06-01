<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>体育馆管理系统/用户中心/更改密码</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>
<!-- jsp包含头部-->
<jsp:include page="common_header.jsp"/>
<div class="container">
	<div class="row">
    	<!--jsp包含用户管理左侧导航栏-->
    	<jsp:include page="usermanger_navi.jsp"/>
    	
        <!-- 更改密码模块-->
        <div class="col-sm-10" >
            <div class="page-header"><!-- 包含标题-->
              <h1>用户中心 <small>更改密码</small></h1>
            </div>
            <form class="form-horizontal" id="changepasswordform" action="updatepassword.action"><!--包含内容-->
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label uneditable-input" for="formGroupInputSmall12">输入新密码</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall12" name="formGroupInputSmall12" >
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="formGroupInputSmall13">确认密码</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall13" name="user.vpassward" >
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                  <button type="submit" class="btn btn-primary">确定</button>
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
