<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>查询结果</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>
<div class="text-center">
        <div class="col-sm-9 hidden-xs" >
      
    <table class="table" >
    <caption class="text-center">器材查询界面</caption>
    <thead>
    <tr>
    <th>器材编号</th>
    <th>器材名称</th>
    <th>所属种类</th>
    <th>赔偿价格</th>
    <th>是否需要维修</th>
    <th>维修状态</th>
    <th>是否已被租借</th>
    <th>租用日期</th>
    <th>归还日期</th>
  </tr>
</thead>
<tbody >
<tr>
<td>00001</td>
<td>哑铃</td>
<td>小型</td>
<td>50</td>
<td>是</td>
<td>未维修</td>
<td>是</td>
<td>2017/6/5</td>
<td>2017/7/5</td>
</tr>

<tr>
<td>00002</td>
<td>跳绳</td>
<td>小型</td>
<td>50</td>
<td>是</td>
<td>未维修</td>
<td>否</td>
<td>----</td>
<td>----</td>
</tr>
</tbody>
    	
    <!--jsp 包含页面脚部 -->
</table></div>
</div>
<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/Equipment.js"></script>
</body>
</html>