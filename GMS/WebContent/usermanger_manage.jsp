<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>体育馆管理系统/用户中心/管理用户</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>
<s:action name="searchuser"/>
<!-- jsp包含头部-->
<jsp:include page="common_header.jsp"/>
<div class="container">
	<div class="row">
    	<!--jsp包含用户管理左侧导航栏-->
    	<jsp:include page="usermanger_navi.jsp"/>
        
        <!-- 用户管理模块-->
        <div class="col-sm-10" >
            <div class="page-header"><!-- 包含标题-->
              <h1>用户中心 <small>管理用户</small></h1>
            </div>
            <form class="navbar-form navbar-left" action="searchuser.action">
        		<div class="form-group">
          			<input type="text" class="form-control" placeholder="请输入姓名" name="searchname" >
        		</div>
        		<button type="submit" class="btn btn-primary">搜索</button>
      		</form>
      		
      		<div >
      			<h1 class="text-left"> <small>查询结果</small></h1>
      			<table class="table table-bordered table-striped text-center">
					<tr class="info">
						<td>序号</td>
						<td>用户名</td>
						<td>姓名</td>
						<td>联系方式</td>
						<td>邮箱</td>
						<td>身份证号码</td>
						<td>查看</td>
						<td>删除</td>
					</tr>
					<s:if test="#session.all_users!=null">
						<s:iterator value="#session.all_users">
						<tr>
							<td>${iuserId }</td>
							<td>${vuserName }</td>
							<td>${vrealName }</td>
							<td>${vtelephone }</td>
							<td>${vemail }</td>
							<td>${videntifierCode }</td>
<%-- 							<td>
								<button type="button" class="btn btn-primary rent-btn" href="Fieldrent-request.action">查看</button>
								<input type="hidden" value="${fieldId }"  /> <!-- 隐藏域 -->
								<input type="hidden" value="${rentH }" />
								<input type="hidden" value="${fieldName }" />
							</td> --%>
							<td>
								<button type="button" class="btn btn-primary">查看</button>
							</td>
							<td>
								<button type="button" class="btn btn-primary">删除</button>
							</td>
						</tr>
						</s:iterator>
					</s:if>
					<s:elseif test="#session.search_users!=null">
						<s:iterator value="#session.search_users">
						<tr>
							<td>${iuserId }</td>
							<td>${vuserName }</td>
							<td>${vrealName }</td>
							<td>${vtelephone }</td>
							<td>${vemail }</td>
							<td>${videntifierCode }</td>
							<td>
								<button type="button" class="btn btn-primary rent-btn" href="Fieldrent-request.action">查看</button>
								<input type="hidden" value="${fieldId }"  /> <!-- 隐藏域 -->
								<input type="hidden" value="${rentH }" />
								<input type="hidden" value="${fieldName }" />
							</td>
							<td>
								<button type="button" class="btn btn-primary">修改</button>
							</td>
							<td>
								<button type="button" class="btn btn-primary">删除</button>
							</td>
						</tr>
						</s:iterator>
					</s:elseif>
				</table>
      		</div>
        </div>
        
    </div>
    <!-- jsp包含页面脚部 -->
    <jsp:include page="common_footer.jsp"/>
</div>

<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/usermanger.js"></script>
</body>
</html>
