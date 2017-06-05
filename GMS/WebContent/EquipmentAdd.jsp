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
              <a  href="EquipmentAdministrator.jsp" class="list-group-item" >器材查询</a>
              <a  href="EquipmentAdd.jsp" class="list-group-item active" >添加器材</a>
              <a  href="EquipmentAudit.jsp" class="list-group-item" >器材审核</a>
              <a  href="EquipmentMaintain.jsp" class="list-group-item" >器材报修状态更改</a>
              <a  href="EquipmentNoReturn.jsp" class="list-group-item" >未归还器材</a>
            </div>
        </div>
     <div class="col-sm-7" >
		    <div class="form-group">
    	    <label for="name">器材名称</label>
    	    <input type="text" class="form-control" id="name" placeholder="请输入器材名称" name="equipment.vequipmentName">
  	 </div>
     <div class="form-group">
     		<label for="name">器材种类</label>
     		<div class="btn-group">
	<button type="button" class="btn btn-default dropdown-toggle" 
			data-toggle="dropdown">
		小型 <span class="caret"></span>
	</button>
	<ul class="dropdown-menu" role="menu">
		<li><a href="#">中型</a></li>
		<li><a href="#">大型</a></li>
	</ul>
</div>
     </div>
     <div class="form-group">
     		<label for="name">器材价格</label>
     		<input type="text" class="form-control" id="name" placeholder="请输入器材价格" name="equipment.icompensate">
     </div>
      <div class="form-group">
     		     <div class="form-group">
     		<label for="name">是否需要维修</label>
     		<div class="btn-group">
	<button type="button" class="btn btn-default dropdown-toggle" 
			data-toggle="dropdown">
		否 <span class="caret"></span>
	</button>
	<ul class="dropdown-menu" role="menu">
		<li><a href="#">是</a></li>
	</ul>
</div>
     </div>
     </div>
     <div class="form-group">
          		     <div class="form-group">
     		<label for="name">维修状态</label>
     		<div class="btn-group">
	<button type="button" class="btn btn-default dropdown-toggle" 
			data-toggle="dropdown">
		未维修 <span class="caret"></span>
	</button>
	<ul class="dropdown-menu" role="menu">
		<li><a href="#">正在维修</a></li>
	</ul>
</div>
     </div>
  	 </div>
  			<input type="submit" class="btn btn-default" id="a" value="添加" onclick="displayContent();">
            </div>
        </div>


<div>
<form>

</form>
</div>
    </div>
    
    
    <!--jsp 包含页面脚部 -->
    <jsp:include page="common_footer.jsp"/>
</div><!--/.container-->
<script>
    document.getElementById('a').onclick = function(){
        alert("添加成功");
    }
</script>
<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
