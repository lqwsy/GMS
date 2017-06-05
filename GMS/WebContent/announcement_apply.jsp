<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>体育馆管理系统/公告中心/查看公告</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>
<s:action name="searchannouncements" namespace="/"></s:action>
<!-- jsp包含头部-->
<jsp:include page="common_header.jsp"/>
<div class="container">
	<div class="row">
    	<!--jsp包含公告管理左侧导航栏-->
    	<jsp:include page="announcement_navi.jsp"/>
    	
    	<!-- 查看/修改公告模块-->
        <div class="col-sm-10">
            <div class="page-header"><!-- 包含标题-->
              <h1>公告中心 <small>查看公告</small></h1>
            </div>
	        <div class="form-group form-group-sm">
	             <s:if test="#session.all_announcements!=null">
					<s:iterator value="#session.all_announcements" id="curannouncement">
						<h3 class="text-center">${vannouncementTitle }</h3>
						<h6 class="text-right">${dannouncementTime }</h6>
						<p style="text-indent:2em;"><pre>${vannouncementDetails}</pre></p>
						<hr>
					</s:iterator>
				</s:if>
	        </div>
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
