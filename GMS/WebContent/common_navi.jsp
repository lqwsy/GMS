<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<style type="text/css">
	.list-group{margin:0;border-bottom:solid 2px #FFF;}
</style>
</head>

<body>
<div class="col-sm-2">
    <div class="list-group">
	  <a href="#" class="list-group-item active" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
	    	个人中心
	  </a>
	  <ul class="list-group collapse" id="collapseExample" >
		  <li class="list-group-item">Cras justo odio</li>
		  <li class="list-group-item">Dapibus ac facilisis in</li>
		  <li class="list-group-item">Morbi leo risus</li>
		  <li class="list-group-item">Porta ac consectetur ac</li>
		  <li class="list-group-item">Vestibulum at eros</li>
		</ul>
	</div>
    <div class="list-group">
	  <a href="#" class="list-group-item active" type="button" data-toggle="collapse" data-target="#collapseExample1" aria-expanded="false" aria-controls="collapseExample1">
	    	赛事中心
	  </a>
	  <div class="list-group collapse" id="collapseExample1" >
		  <a href="addCompetition.action" class="list-group-item">申请赛事</a></li>
		  <a href="liveComeptitions.action" class="list-group-item">查看直播</a>
		  <a href="searchCompetitions.action" class="list-group-item">搜索赛事</a>
		  <a href="myCompetitions.action" class="list-group-item">我的赛事</a>
		  <s:if test="#session.cur_user_roleid=='1'">
		  	<a href="verifyCompetition.action" class="list-group-item">赛事审核</a>
		  </s:if>
		</div>
	</div>
    <div class="list-group">
	  <a href="#" class="list-group-item active" type="button" data-toggle="collapse" data-target="#collapseExample2" aria-expanded="false" aria-controls="collapseExample2">
	    	场地中心
	  </a>
	  <div class="list-group collapse" id="collapseExample2" >
		  <a href="Fieldinfo-input.action" class="list-group-item">添加场地</a>
		  <a href="Fieldtype-input.action" class="list-group-item">添加场地类型</a>
		  <a href="FieldinfoQ-query.action" class="list-group-item">查询场地</a>
		  <a href="Fieldrent-query.action" class="list-group-item">我的租用记录</a>
		  <a href="Fieldrent-lookup.action" class="list-group-item">管理租用记录</a>
	  </div>
	</div>
    <div class="list-group">
	  <a href="#" class="list-group-item active" type="button" data-toggle="collapse" data-target="#collapseExample3" aria-expanded="false" aria-controls="collapseExample3">
	    	器材中心
	  </a>
	  <ul class="list-group collapse" id="collapseExample3" >
		  <li class="list-group-item">Cras justo odio</li>
		  <li class="list-group-item">Dapibus ac facilisis in</li>
		  <li class="list-group-item">Morbi leo risus</li>
		  <li class="list-group-item">Porta ac consectetur ac</li>
		  <li class="list-group-item">Vestibulum at eros</li>
		</ul>
	</div>
    <div class="list-group">
	  <a href="#" class="list-group-item active" type="button" data-toggle="collapse" data-target="#collapseExample4" aria-expanded="false" aria-controls="collapseExample4">
	    	公告中心
	  </a>
	  <ul class="list-group collapse" id="collapseExample4" >
		  <li class="list-group-item">Cras justo odio</li>
		  <li class="list-group-item">Dapibus ac facilisis in</li>
		  <li class="list-group-item">Morbi leo risus</li>
		  <li class="list-group-item">Porta ac consectetur ac</li>
		  <li class="list-group-item">Vestibulum at eros</li>
		</ul>
	</div>
</div>
</body>
</html>
