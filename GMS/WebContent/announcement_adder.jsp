<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>体育馆管理系统/公告中心/添加公告</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>
<!-- jsp包含头部-->
<jsp:include page="common_header.jsp"/>
<div class="container">
	<div class="row">
    	<!--jsp包含公告管理左侧导航栏-->
    	<jsp:include page="announcement_navi.jsp"/>
    	
    	<!-- 个添加公告模块-->
        <div class="col-sm-10">
            <div class="page-header"><!-- 包含标题-->
              <h1>公告中心 <small>添加公告</small></h1>
            </div>
           <form class="form-horizontal" id="anncouncementform" action="addannouncement.action"><!--包含内容-->
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label uneditable-input" for="formGroupInputTitle">公告标题</label>
                <div class="col-sm-10">
                  <input class="form-control" type="text" id="formGroupInputTitle"  placeholder="请输入公告标题，4-50个字" name="announcement.vannouncementTitle">
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="formGroupInputDetails">公告详情</label>
                <div class="col-sm-10">
                  <textarea class="form-control" id="formGroupInputDetails" rows="15" placeholder="请输入公告详情，20-500个字" name="announcement.vannouncementDetails"></textarea>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5" >
                  <button type="submit" class="btn btn-primary" >添加</button>
                </div>
              </div>
              <div class="form-group">
              	<div class="col-sm-offset-2 col-sm-5" id="changeinfo">
            	<p><span id="login-tips-span">${ann_result}</span></p>
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
<script src="js/announcememt.js"></script>
</body>
</html>
