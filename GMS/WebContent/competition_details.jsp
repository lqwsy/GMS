<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>赛事详情</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>

<jsp:include page="common_header.jsp"/>
<div class="container">
	<form class="hidden" id="comment-form">
        <input id="ci" name="ci" value="<s:property value='competition.bcompetitionId'/>">
		<input id="comment" name="comment.vcommentDetails" >
	</form>
	<form class="hidden" id="reply-form">
		<input id="commentid" name="commentId">
		<input id="reply" name="reply.vreplyContents">
	</form>
	<div class="row">
		<jsp:include page="common_navi.jsp"/>
        <div class="col-sm-10">
            <div class="page-header">
              <h1>赛事详情</h1>
            </div>
            <div class="row">
            	<label class="col-sm-2">申请人:</label>
                <span class="col-sm-10"><strong><a href="#"><s:property value="competition.userinfo.vuserName"/></a></strong></span>
            </div>
            <div class="row">
            	<s:iterator value="competition.competitionresults" id="result" status="status">
            		<s:if test="#status.index==0">
            			<label class="col-sm-2">比赛A方:</label>
                		<span class="col-sm-4"><s:property value="#result.vcompetitorUnit"/></span>
            		</s:if>
            		<s:elseif test="#status.index==1">
            			<label class="col-sm-2">比赛B方:</label>
                	<span class="col-sm-4"><s:property value="#result.vcompetitorUnit"/></span>
            		</s:elseif>
            	</s:iterator>
                
            </div>
            <div class="row">
            	<s:iterator value="competition.competitionresults" id="result" status="status">
            		<s:if test="#status.index==0">
            			<label class="col-sm-2">A方得分:</label>
                		<span class="col-sm-4"><s:property value="#result.iscores"/></span>
            		</s:if>
            		<s:elseif test="#status.index==1">
            			<label class="col-sm-2">B方得分:</label>
                	<span class="col-sm-4"><s:property value="#result.iscores"/></span>
            		</s:elseif>
            	</s:iterator>
            </div>
            <div class="row">
            	<label class="col-sm-2">赛事类型:</label>
                <span class="col-sm-4">
                	<s:property value="competition.competitiontype.vcompetitionName"/>
                </span>
                <label class="col-sm-2">比赛时间:</label>
                <span class="col-sm-4">
                	<s:property value="competition.dcompetitionDate.toString().substring(0,16)"/>
                </span>
            </div>
            <div class="row">
            	<label class="col-sm-2">赛事详情:</label>
                <p class="col-sm-10">
                	<s:property value="competition.vcompetitionDetails"/>
                </p>
            </div>
            <!-- 以下内容普通用户无法查看 -->
            <!-- start -->
            <s:if test="#session.cur_user_roleid=='1'||#session.cur_user.iuserId==competition.userinfo.iuserId">
	            <div class="row">
	            	<label class="col-sm-2">联系人:</label>
	                <span class="col-sm-4">
	                	<s:property value="competition.vlinkMan"/>
	                </span>
	            	<label class="col-sm-2">联系电话:</label>
	                <span class="col-sm-4">
	                	<s:property value="competition.vphoneNumber"/>
	                </span>
	            </div><!-- end -->
            </s:if>
            <div class="row">
            	<label class="col-sm-2">主办单位:</label>
                <span class="col-sm-10">
                	<s:property value="competition.vmainUnit"/>
                </span>
            </div>
            <div class="row">
            	<label class="col-sm-2">单位地址:</label>
                <span class="col-sm-10">
                	<s:property value="competition.vunitAddress"/>
                </span>
            </div>
            <div class="row">
            	<label class="col-sm-2">赛事状态</label>
                <span class="col-sm-10 text-info">
                	<s:if test="competition.vcompetitionState=='0000'">
        				待审核
        			</s:if>
        			<s:elseif test="competition.vcompetitionState=='0001'">
        				未开始
        			</s:elseif>
        			<s:elseif test="competition.vcompetitionState=='0010'">
        				直播中
        			</s:elseif>
        			<s:elseif test="competition.vcompetitionState=='0011'">
        				已结束
        			</s:elseif>
        			<s:elseif test="competition.vcompetitionState=='0100'">
        				已取消
        			</s:elseif>  
                </span>
            </div>
            <hr/><!--分割线-->
            <!-- 以下内容普通用户无法查看 -->
            <!-- start -->
            <s:if test="#session.cur_user_roleid=='1'||#session.cur_user.iuserId==competition.userinfo.iuserId">
	            <div class="row">
	            	<label class="col-sm-2">场地类型:</label>
	                <span class="col-sm-4"></span>
	            	<label class="col-sm-2">场地名称:</label>
	                <span class="col-sm-4"></span>
	            </div>
	            <div class="row">
	            	<label class="col-sm-2">器材名称:</label>
	                <span class="col-sm-4"></span>
	            	<label class="col-sm-2">器材数量:</label>
	                <span class="col-sm-4"></span>
	            </div>
	        </s:if>
            <!-- end -->
            <hr/>
            <div class="row text-right">
            	<div class="col-sm-12">
            		<s:if test="competition.vcompetitionState=='0000'&&#session.cur_user_roleid==2">
	                    <button type="button" class="btn btn-primary pass-btn">通过</button>
	                    <button type="button" class="btn btn-primary unpass-btn">不通过</button>
                    </s:if>
                    <a class="btn btn-info show-comments-btn" role="button" data-toggle="collapse" href="#competition-comments-module" aria-expanded="false" 
                        aria-controls="competition-comments-module">
                      查看评论
                    </a>
                </div>
            </div>
            
            <jsp:include page="competition_comment_module.jsp"/>
		</div>
    </div>
    <jsp:include page="competition_operation_tips.jsp"/>
    <jsp:include page="common_footer.jsp"/>
</div>
<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/competition_details.js"></script>
<script type="text/javascript" src="js/competition_comment_module.js"></script>
</body>
</html>
