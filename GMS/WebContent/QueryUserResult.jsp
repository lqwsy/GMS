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
        <div class="col-sm-8 hidden-xs" >
      
    <table class="table" >
    <caption class="text-center">用户器材查询（租借）界面</caption>
    <thead>
    <tr>
    <th>器材编号</th>
    <th>器材名称</th>
    <th>所属种类</th>
    <th>赔偿价格</th>
    <th>是否需要维修</th>
    <th>维修状态</th>
    <th>是否已被租借</th>
  </tr>
</thead>
<tbody id="hide9">
<tr>
<td>00001</td>
<td>哑铃</td>
<td>小型</td>
<td>50</td>
<td>否</td>
<td>未维修</td>
<td>否</td>
<td><input type="submit" class="btn btn-default" id="hide8" value="租借" ></td>
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