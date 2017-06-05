<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>体育馆管理系统</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>
<s:action name="searchannouncements" namespace="/"></s:action>
<!--jsp 包含页面头部-->
<jsp:include page="common_header.jsp"/>
<div class="container">
	<div class="row">
    	<div class="col-sm-9">
        	<div class="col-sm-4 col-xs-6">
                <div class="thumbnail">
                  <img src="..." alt="...">
                  <div class="caption">
                    <h3>器材管理</h3>
                    <p>...</p>
                    <p><a href="EquipmentAdministrator.jsp" class="btn btn-primary" role="button">进入</a></p>
                  </div>
                </div>
           </div>
        	<div class="col-sm-4 col-xs-6">
                <div class="thumbnail">
                  <img src="..." alt="...">
                  <div class="caption">
                    <h3>场地租借</h3>
                    <p>...</p>
                    <p><a href="#" class="btn btn-primary" role="button">进入</a></p>
                  </div>
                </div>
           </div>
        	<div class="col-sm-4 col-xs-6">
                <div class="thumbnail">
                  <img src="..." alt="...">
                  <div class="caption">
                    <h3>赛事申请</h3>
                    <p>...</p>
                    <p><a href="addCompetition.action" class="btn btn-primary" role="button">进入</a></p>
                  </div>
                </div>
           </div>
        	<div class="col-sm-4 col-xs-6">
                <div class="thumbnail">
                  <img src="..." alt="...">
                  <div class="caption">
                    <h3>公告详情</h3>
                    <p>...</p>
                    <p><a href="#" class="btn btn-primary" role="button">进入</a></p>
                  </div>
                </div>
           </div>
        	<div class="col-sm-4 col-xs-6">
                <div class="thumbnail">
                  <img src="..." alt="...">
                  <div class="caption">
                    <h3>其他</h3>
                    <p>...</p>
                    <p><a href="#" class="btn btn-primary" role="button">进入</a></p>
                  </div>
                </div>
           </div>
        </div>
        <div class="col-sm-3 hidden-xs">
        	<div class="list-group"> 
              <a href="#" class="list-group-item active">
                	公告栏
              </a>
              <s:if test="#session.all_announcements!=null">
				  <s:iterator value="#session.all_announcements" id="curannouncement" status="status" >
				  	<s:if test="#status.count<5">
						<a href="announcement_apply.jsp" class="list-group-item"><p style="text-indent:2em;">${vannouncementTitle}</p></a>
			  		</s:if>
				  </s:iterator>
			  </s:if>
			  <s:else>
				  <a href="#" class="list-group-item">公告1</a>
	              <a href="#" class="list-group-item">公告2</a>
	              <a href="#" class="list-group-item">公告3</a>
	              <a href="#" class="list-group-item">公告4</a>		  	
			  </s:else>
            </div>
        </div>
    </div>
    <!--jsp 包含页面脚部 -->
    <jsp:include page="common_footer.jsp"/>
</div><!--/.container-->

<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
