<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>赛事申请</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>
<!-- jsp包含头部-->
<jsp:include page="common_header.jsp"/>
<div class="container">
	<div class="row">
    
    	<!--jsp包含导航栏-->
    	<jsp:include page="common_navi.jsp"/>
        <div class="col-sm-10">
            <div class="page-header"><!-- 包含标题-->
              <h1>赛事申请 <small>信息填写</small></h1>
            </div>
           <form class="form-horizontal"><!--包含内容-->
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="formGroupInputSmall">Small label</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall" placeholder="Small input">
                </div>
                <label class="col-sm-2 control-label" for="formGroupInputSmall">Small label</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall2" placeholder="Small input">
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="formGroupInputSmall">Small label</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall3" placeholder="Small input">
                </div>
                <label class="col-sm-2 control-label" for="formGroupInputSmall">Small label</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall4" placeholder="Small input">
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="formGroupInputLarge">Large label</label>
                <div class="col-sm-10">
                  <input class="form-control" type="text" id="formGroupInputLarge" placeholder="Large input">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                  <button type="submit" class="btn btn-default">申请</button>
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