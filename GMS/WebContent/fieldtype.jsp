<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加场地类型</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>
<body>

<jsp:include page="common_header.jsp"></jsp:include>
<div class="container">
	<div class="row">
		<jsp:include page="common_navi.jsp"></jsp:include>
		 <div class="col-sm-10">
			<div class="page-header">
				<h1>添加场地类型<small>信息填写</small></h1>
			</div>
			
			<form class="form-horizontal" method="post" action="field/Fieldtype-addFieldtype.action">
			  <div class="form-group">
			    <label for="vFieldTypeName" class="col-sm-2 control-label">场地类型名:</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="vFieldTypeName" name="fieldtype.vFieldTypeName" placeholder="类型名">
				    </div>
				  
				    <div class="col-sm-offset-1 col-sm-4">
				      <button type="submit" class="btn btn-default">添加</button>
				    </div>
			   </div>
			</form>
		</div>
	</div>
</div>


<jsp:include page="common_footer.jsp"></jsp:include>
</body>
</html>