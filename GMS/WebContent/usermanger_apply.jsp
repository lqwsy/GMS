<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>体育馆管理系统/用户中心</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>
<!-- jsp包含头部-->
<jsp:include page="common_header.jsp"/>
<div class="container">
	<div class="row">
    
    	<!--jsp包含用户管理左侧导航栏-->
    	<jsp:include page="usermanger_navi.jsp"/>
        <div class="col-sm-10">
            <div class="page-header"><!-- 包含标题-->
              <h1>用户中心 <small>个人资料</small></h1>
            </div>
           <form class="form-horizontal"><!--包含内容-->
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="formGroupInputSmall">用户名</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall" placeholder="${session.cur_user.vuserName}">
                </div>
                <label class="col-sm-2 control-label" for="formGroupInputSmall">真实姓名</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall2" placeholder="${session.cur_user.vrealName}">
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="formGroupInputSmall">电话号码</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall3" placeholder="${session.cur_user.vtelephone}">
                </div>
                <label class="col-sm-2 control-label" for="formGroupInputSmall">电子邮箱</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall4" placeholder="${session.cur_user.vemail}">
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="formGroupInputLarge">联系地址</label>
                <div class="col-sm-10">
                  <input class="form-control" type="text" id="formGroupInputLarge" placeholder="${session.cur_user.vaddress}">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                  <button type="submit" class="btn btn-default">确定</button>
                  <button type="submit" class="btn btn-default">取消</button>
                </div>
              </div>
            </form>
        </div>
    </div>
    <!-- jsp包含页面脚部 -->
    <jsp:include page="common_footer.jsp"/>
</div>

<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
