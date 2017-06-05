<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>体育馆管理系统/用户中心/个人资料</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>
<!-- jsp包含头部-->
<jsp:include page="common_header.jsp"/>
<div class="container">
	<div class="row">
    	<!--jsp包含用户管理左侧导航栏-->
    	<jsp:include page="common_navi.jsp"/>
    	
    	<!-- 个人资料模块-->
        <div class="col-sm-10" id="userinfopage">
            <div class="page-header"><!-- 包含标题-->
              <h1>用户中心 <small>个人资料</small></h1>
            </div>
           <form class="form-horizontal" action="updateuser.action"><!--包含内容-->
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label uneditable-input" for="formGroupInputSmall1">用户名</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall1" value="${session.cur_user.vuserName}" name="user.vuserName" readonly>
                  <input type="hidden" value="${session.cur_user.iuserId}"  name="user.iuserId" />
                  <input type="hidden" value="${session.cur_user.vpassward}"  name="user.vpassward" />
                  <input type="hidden" value="${session.cur_user.roleinfo.iroleId}"  name="user.roleinfo.iroleId" />
                </div>
                <label class="col-sm-2 control-label" for="formGroupInputSmall2">真实姓名</label>
               <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall2" value="${session.cur_user.vrealName}" name="user.vrealName">
                </div>
             </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="formGroupInputSmall3">电话号码</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall3" value="${session.cur_user.vtelephone}" name="user.vtelephone">
                </div>
                <label class="col-sm-2 control-label" for="formGroupInputSmall4">电子邮箱</label>
              <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall4" value="${session.cur_user.vemail}" name="user.vemail">
                </div>
             </div>
              <div class="form-group form-group-sm">            	
                <label class="col-sm-2 control-label" for="formGroupInputSmall5">身份证号</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall5" value="${session.cur_user.videntifierCode}" name="user.videntifierCode">
                </div>
                <label class="col-sm-2 control-label" for="formGroupInputSmall6">身份证地址</label>
              	<div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall6" value="${session.cur_user.videntifierAddress}" name="user.videntifierAddress">
                </div>
              </div>
              <div class="form-group form-group-sm">            	
                <label class="col-sm-2 control-label" for="formGroupInputSmall7">出生日期</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall7" value="<s:property value='#session.cur_user.dbirthday.toString().substring(0,10)'/>
" name="user.dbirthday">
                </div>
                <label class="col-sm-2 control-label" for="formGroupInputSmall8">所在学校</label>
              	<div class="col-sm-4">
                  <input class="form-control" type="text" id="formGroupInputSmall8" value="${session.cur_user.vcollege}" name="user.vcollege">
                </div>
              </div>
              <div class="form-group form-group-sm">            	
                <label class="col-sm-2 control-label" for="formGroupInputSmall9">用户状态</label>
                <div class="col-sm-4">
                	<s:if test="#session.cur_user.ivstate==1">
	                  <input class="form-control input-xlarge uneditable-input" type="text" id="formGroupInputSmall9" value="未通过审核" readonly >
                	  <input type="hidden" value="${session.cur_user.ivstate}"  name="user.ivstate" />
                	</s:if>
                	<s:elseif test="#session.cur_user.ivstate==2">
	                  <input class="form-control input-xlarge uneditable-input" type="text" id="formGroupInputSmall10" value="已通过审核" readonly >
	                  <input type="hidden" value="${session.cur_user.ivstate}"  name="user.ivstate" />
                	</s:elseif>
                	<s:else>
	                  <input class="form-control input-xlarge uneditable-input" type="text" id="formGroupInputSmall20" value="未审核" readonly >
	                  <input type="hidden" value="${session.cur_user.ivstate}"  name="user.ivstate" />
                	</s:else>
                </div>
                <label class="col-sm-2 control-label" for="rolename">用户类型</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" name="rolename"  value="${session.cur_user.roleinfo.vroleName}" readonly>
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="formGroupInputLarge">联系地址</label>
                <div class="col-sm-10">
                  <input class="form-control" type="text" id="formGroupInputLarge" value="${session.cur_user.vaddress}" name="user.vaddress">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5" id="surecancel" style="display:none;">
                  <button type="submit" class="btn btn-primary" >确定</button>
                  <button type="button" class="btn btn-primary" id="cancelchange">取消</button>
                </div>
                <div class="col-sm-offset-2 col-sm-5" id="changeinfo">
                	<button type="button" class="btn btn-primary" id="changeuserinfo">修改</button>
                </div>
              </div>
              <div class="form-group">
              	<div class="col-sm-offset-2 col-sm-5" id="changeinfo">
            	<p><span id="login-tips-span">${str_result}</span></p>
                </div>
              </div>
            </form>
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
