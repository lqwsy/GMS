<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>
<!--jsp 包含页面头部-->
<jsp:include page="common_header.jsp"/>
<div class="container">
	<div class="row">
    	<div class="col-sm-9">
<div class="container">
	<div class="row">

        <div class="col-sm-3 hidden-xs">
        	<div class="list-group">
              <a  href="EquipmentAdministrator.jsp" class="list-group-item" >
                器材查询
              </a>
              <a  href="EquipmentAdd.jsp" class="list-group-item" >添加器材</a>
              <a  href="EquipmentAudit.jsp" class="list-group-item active" >器材审核</a>
              <a  href="EquipmentMaintain.jsp" class="list-group-item" >器材报修状态更改</a>
              <a  href="EquipmentNoReturn.jsp" class="list-group-item" >未归还器材</a>
            </div>
        </div>
        
        <div class="col-sm-8 hidden-xs" >
      
    <table class="table" >
    <caption class="text-center">器材审核界面</caption>
    <thead>
    <tr>
    <th>器材编号</th>
    <th>器材名称</th>
    <th>所属种类</th>
    <th>赔偿价格</th>
    <th>是否需要维修</th>
    <th>维修状态</th>
    
  </tr>
</thead>
<tbody id="hide2">
<tr>
<td>00001</td>
<td>哑铃</td>
<td>小型</td>
<td>50</td>
<td>否</td>
<td>未维修</td>
<td><input type="submit" class="btn btn-default" id="hide" value="同意" ></input></td>
<td><input type="submit" class="btn btn-default" id="hide7" value="不同意"></input></td>
</tr>
</tbody>
    	
    <!--jsp 包含页面脚部 -->
</table></div>
</div><!--/.container-->

<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/Equipment.js"></script>
</body>
</html>
