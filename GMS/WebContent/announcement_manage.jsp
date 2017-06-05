<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>体育馆管理系统/公告中心/公告管理</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>
<%-- <s:action name="searchannouncements" namespace="/"></s:action> --%>
<!-- jsp包含头部-->
<jsp:include page="common_header.jsp"/>
<div class="container">
	<div class="row">
    	<!--jsp包含公告管理左侧导航栏-->
    	<jsp:include page="announcement_navi.jsp"/>
        
        <!-- 公告管理模块-->
        <div class="col-sm-10" >
            <div class="page-header"><!-- 包含标题-->
              <h1>公告中心 <small>公告管理</small></h1>
            </div>
      		<div>
      			<h1 class="text-left"> <small>公告信息</small></h1>
      			<% int count = 0; %>
      			<table class="table table-bordered table-striped text-center">
					<tr class="info">
						<td>序号</td>
						<td>公告标题</td>
						<td>公告详情</td>
						<td>公告时间</td>
						<td>删除</td>
					</tr>
					<s:if test="announcements!=null">
						<s:iterator value="announcements" id="curannouncement">
						<tr>
							<td><%=++count%></td>
							<td>${vannouncementTitle }</td>
							<td>${vannouncementDetails }</td>
							<td>${dannouncementTime }</td>
							<td>
								<s:a href="deleteannouncement.action?announcement.bannouncementId=%{#curannouncement.bannouncementId}" class="btn btn-default">删除</s:a>
							</td>
						</tr>
						</s:iterator>
					</s:if>
				</table>
      		</div>
        </div>
        
    </div>
    <!-- jsp包含页面脚部 -->
    <jsp:include page="common_footer.jsp"/>
</div>

<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
