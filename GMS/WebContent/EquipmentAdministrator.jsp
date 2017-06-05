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
              <a  href="EquipmentAdministrator.jsp" class="list-group-item active" >
                器材查询
              </a>
              <a  href="EquipmentAdd.jsp" class="list-group-item" >添加器材</a>
              <a  href="EquipmentAudit.jsp" class="list-group-item" >器材审核</a>
              <a  href="EquipmentMaintain.jsp" class="list-group-item" >器材报修状态更改</a>
              <a  href="EquipmentNoReturn.jsp" class="list-group-item" >未归还器材</a>
            </div>
        </div>
      
            <div class="col-sm-6" >
                <div class="input-group">
                
                    <input type="text" class="form-control" placeholder="请输入要查询的器材" id="vequipmentName" name="equipment.vequipmentName">
                    <span class="input-group-btn">
                        <input class="btn btn-default" type="submit" value="查询" onclick="JumpToQueryResult()"/>
                    </span>

                </div><!-- /input-group -->

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
