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
              <a  href="EquipmentAudit.jsp" class="list-group-item" >器材审核</a>
              <a  href="EquipmentMaintain.jsp" class="list-group-item " >器材报修状态更改</a>
              <a  href="EquipmentNoReturn.jsp" class="list-group-item active" >未归还器材</a>
            </div>
        </div>
      <div class="col-sm-8 hidden-xs" >
      
    <table class="table" >
    <caption class="text-center">器材报修界面</caption>
    <thead>
    <tr>
    <th>租用单号</th>
    <th>器材编号</th>
    <th>器材名称</th>
    <th>租用价格</th>
    <th>租用日期</th>
    <th>归还日期</th>
    <th>审阅人</th>
    <th>借用人</th>
    
  </tr>
</thead>
<tbody >
<tr id="hide6">
<td>00001</td>
<td>00001</td>
<td>哑铃</td>
<td>50</td>
<td>2017/6/6</td>
<td>2017/7/6</td>
<td>root</td>
<td>emmr</td>

</tr>

</tbody>
    	</div>
    
    
    <!--jsp 包含页面脚部 -->

</div><!--/.container-->
<script>
    document.getElementById('cuihuan').onclick = function(){
        alert("催还成功");
    }
</script>
<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/Equipment.js"></script>
</body>
</html>
