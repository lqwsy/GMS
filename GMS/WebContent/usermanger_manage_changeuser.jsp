<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>体育馆管理系统/用户中心/管理用户/修改用户状态和类型</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>
<!-- jsp包含头部-->
<jsp:include page="common_header.jsp"/>
<div class="container">
	<div class="row">
		<!--jsp包含用户管理左侧导航栏-->
    	<jsp:include page="common_navi.jsp"/>
    	
    	<!-- 修改用户信息模块-->
        <div class="col-sm-10">
           <div class="page-header"><!-- 包含标题-->
              <h1>用户中心 <small>管理用户<small>/修改用户状态和类型</small></small></h1>
             </div>
           <form class="form-horizontal" action="updateuserstateandrole.action">
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label uneditable-input" for="changeuserinput1">用户名</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="changeuserinput1" value="${session.change_user.vuserName}"  readonly>
                  <input type="hidden" value="${session.change_user.iuserId}"  name="changeuserId" />
                </div>
                <label class="col-sm-2 control-label" for="changeuserinput2">真实姓名</label>
               <div class="col-sm-4">
                  <input class="form-control" type="text" id="changeuserinput2" value="${session.change_user.vrealName}" readonly>
                </div>
             </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="changeuserinput3">电话号码</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="changeuserinput3" value="${session.change_user.vtelephone}" readonly>
                </div>
                <label class="col-sm-2 control-label" for="changeuserinput4">电子邮箱</label>
              <div class="col-sm-4">
                  <input class="form-control" type="text" id="changeuserinput4" value="${session.change_user.vemail}" readonly>
                </div>
             </div>
              <div class="form-group form-group-sm">            	
                <label class="col-sm-2 control-label" for="changeuserinput5">身份证号</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="changeuserinput5" value="${session.change_user.videntifierCode}" readonly>
                </div>
                <label class="col-sm-2 control-label" for="changeuserinput6">身份证地址</label>
              	<div class="col-sm-4">
                  <input class="form-control" type="text" id="changeuserinput6" value="${session.change_user.videntifierAddress}" readonly>
                </div>
              </div>
              <div class="form-group form-group-sm">            	
                <label class="col-sm-2 control-label" for="changeuserinput7">出生日期</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="changeuserinput7" value="<s:property value='#session.change_user.dbirthday.toString().substring(0,10)'/>
" readonly>
                </div>
                <label class="col-sm-2 control-label" for="changeuserinput8">所在学校</label>
              	<div class="col-sm-4">
                  <input class="form-control" type="text" id="changeuserinput8" value="${session.change_user.vcollege}" readonly>
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="changeuserstate">审核状态</label>
                <div class="col-sm-4">
                    <select class="form-control" name="changeuserstate">
						<s:if test="#session.change_user.ivstate==1">
							<option value="0">未审核</option>
							<option value="1" selected="selected">不通过</option>
							<option value="2">通过</option>
                		</s:if>
						<s:elseif test="#session.change_user.ivstate==2">
							<option value="0">未审核</option>
							<option value="1">不通过</option>
							<option value="2" selected="selected">通过</option>
                		</s:elseif>
						<s:else>
							<option value="0" selected="selected">未审核</option>
							<option value="1">不通过</option>
							<option value="2">通过</option>
                		</s:else>
					</select>
                </div>
                <label class="col-sm-2 control-label" for="changeuserrole">用户类型</label>
                <div class="col-sm-4">
                    <select class="form-control" name="changeuserrole">
                    	<s:if test="#session.change_user.roleinfo.iroleId==1">
						  	<option value="1" selected="selected">超级管理员</option>
						  	<option value="2">赛事管理员</option>
						  	<option value="3">场地管理员</option>
						  	<option value="4">器材管理员</option>
						  	<option value="5">普通用户</option>
                		</s:if>
						<s:elseif test="#session.change_user.roleinfo.iroleId==2">
							<option value="1">超级管理员</option>
						  	<option value="2" selected="selected">赛事管理员</option>
						  	<option value="3">场地管理员</option>
						  	<option value="4">器材管理员</option>
						  	<option value="5">普通用户</option>
                		</s:elseif>
						<s:elseif test="#session.change_user.roleinfo.iroleId==3">
							<option value="1">超级管理员</option>
						  	<option value="2">赛事管理员</option>
						  	<option value="3" selected="selected">场地管理员</option>
						  	<option value="4">器材管理员</option>
						  	<option value="5">普通用户</option>
                		</s:elseif>
						<s:elseif test="#session.change_user.roleinfo.iroleId==4">
							<option value="1">超级管理员</option>
						  	<option value="2">赛事管理员</option>
						  	<option value="3">场地管理员</option>
						  	<option value="4"  selected="selected">器材管理员</option>
						  	<option value="5">普通用户</option>
                		</s:elseif>
						<s:elseif test="#session.change_user.roleinfo.iroleId==5">
							<option value="1">超级管理员</option>
						  	<option value="2">赛事管理员</option>
						  	<option value="3">场地管理员</option>
						  	<option value="4">器材管理员</option>
						  	<option value="5" selected="selected">普通用户</option>
                		</s:elseif>
					</select>
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="changeuserinput9">联系地址</label>
                <div class="col-sm-10">
                  <input class="form-control" type="text" id="changeuserinput9" value="${session.change_user.vaddress}" readonly>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                  <button type="submit" class="btn btn-primary" >确定</button>
                  <s:a href="usermanger_manage.jsp" class="btn btn-primary">返回</s:a>
                </div>
              </div>
              <div class="form-group">
              	<div class="col-sm-offset-2 col-sm-5">
            	<p><span id="login-tips-span">${str_result}</span></p>
                </div>
              </div>
            </form>
        </div>
        
    </div>
</div>

<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/usermanger.js"></script>
</body>
</html>
