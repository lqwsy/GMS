<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<%@ taglib prefix="s" uri="/struts-tags" %>
</head>

<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">体育馆管理系统</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">首页 <span class="sr-only">(current)</span></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">场地 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="Fieldinfo-input.action">添加场地</a></li>
            <li><a href="FieldinfoQ-query.action">查询场地</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="Fieldtype-input.action">添加场地类型</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="Fieldrent-query.action">我的租用记录</a></li>
            <li><a href="Fieldrent-lookup.action">管理租用记录</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">器材 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">赛事<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="addCompetition.action">申请赛事</a></li>
            <li><a href="liveComeptitions.action">查看直播</a></li>
            <li><a href="searchCompetitions.action">搜索赛事</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="myCompetitions.action">我的赛事</a></li>
            <s:if test="#session.cur_user_roleid==2">
            	<li><a href="verifyCompetition.action">赛事审核</a></li>
           	</s:if>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">公告<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="announcement_apply.jsp">查看公告</a></li>
            <s:if test="#session.cur_user.roleinfo.iroleId==1">
            	<li role="separator" class="divider"></li>
				<li><a href="announcement_adder.jsp">添加公告</a></li>
				<li><a href="searchannouncements.action">管理公告</a></li>
        	</s:if>
          </ul>
        </li>
        <s:if test="#session.cur_user.roleinfo.iroleId==1">
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户管理<span class="caret"></span></a>
	          <ul class="dropdown-menu">
					<li><a href="usermanger_adduser.jsp">添加用户</a></li>
					<li><a href="usermanger_manage.jsp">管理用户</a></li>
	          </ul>
	        </li>
        </s:if>
      </ul>
<!--       <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
      </form> -->
      <ul class="nav navbar-nav navbar-right">
        <s:if test="#session.cur_user==null">
			<li><a href="login.jsp">登录</a></li>
			<li><a href="regist.jsp">注册</a></li>
        </s:if>
        <s:else >
        	<li><a href="#">欢迎：${session.cur_user.vuserName}</a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">设置 <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="usermanger_apply.jsp">账户设置</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="exit.action">退出</a></li>
	          </ul>
	        </li>
        </s:else>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>
