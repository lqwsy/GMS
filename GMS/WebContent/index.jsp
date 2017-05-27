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
        	<div class="col-sm-4 col-xs-6">
                <div class="thumbnail">
                  <img src="..." alt="...">
                  <div class="caption">
                    <h3>Thumbnail label</h3>
                    <p>...</p>
                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                  </div>
                </div>
           </div>
        	<div class="col-sm-4 col-xs-6">
                <div class="thumbnail">
                  <img src="..." alt="...">
                  <div class="caption">
                    <h3>Thumbnail label</h3>
                    <p>...</p>
                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                  </div>
                </div>
           </div>
        	<div class="col-sm-4 col-xs-6">
                <div class="thumbnail">
                  <img src="..." alt="...">
                  <div class="caption">
                    <h3>Thumbnail label</h3>
                    <p>...</p>
                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                  </div>
                </div>
           </div>
        	<div class="col-sm-4 col-xs-6">
                <div class="thumbnail">
                  <img src="..." alt="...">
                  <div class="caption">
                    <h3>Thumbnail label</h3>
                    <p>...</p>
                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                  </div>
                </div>
           </div>
        	<div class="col-sm-4 col-xs-6">
                <div class="thumbnail">
                  <img src="..." alt="...">
                  <div class="caption">
                    <h3>Thumbnail label</h3>
                    <p>...</p>
                    <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                  </div>
                </div>
           </div>
        </div>
        <div class="col-sm-3 hidden-xs">
        	<div class="list-group">
              <a href="#" class="list-group-item active">
                Cras justo odio
              </a>
              <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
              <a href="#" class="list-group-item">Morbi leo risus</a>
              <a href="#" class="list-group-item">Porta ac consectetur ac</a>
              <a href="#" class="list-group-item">Vestibulum at eros</a>
            </div>
        </div>
    </div>
    <!--jsp 包含页面脚部 -->
    <jsp:include page="common_footer.jsp"/>
</div><!--/.container-->

<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>