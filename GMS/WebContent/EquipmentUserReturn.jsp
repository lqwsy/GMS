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
              <a  href="EquipmentUser.jsp" class="list-group-item" >
                器材查询(租借)
              </a>
              <a  href="EquipmentUserReturn.jsp" class="list-group-item active" >需归还器材</a>
            </div>
        </div>
      
            <div class="col-sm-6" >
<table class="table" >
    <thead>
    <tr>
    <th>器材编号</th>
    <th>器材名称</th>
    <th>所属种类</th>
    <th>赔偿价格</th>
    <th>归还日期</th>

  </tr>
</thead>
<tbody id="hide2">
<tr>
<td>00001</td>
<td>哑铃</td>
<td>小型</td>
<td>50</td>
<td>2017/7/6</td>
</tr>

    	
    <!--jsp 包含页面脚部 -->
</table>

            </div><!-- /.col-lg-6 -->
    </div>
    
    
    <!--jsp 包含页面脚部 -->
    <jsp:include page="common_footer.jsp"/>
</div><!--/.container-->

<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/Equipment.js"></script>
</body>
</html>
