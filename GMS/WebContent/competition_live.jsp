<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>赛事直播</title>
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
		<input class="hidden" id="ci" value="<s:property value='competition.bcompetitionId'/>"> 
		<div class="col-sm-12">
        	<div class="jumbotron"><!-- 巨幕 -->
        	<h2>
        		赛事直播
       		</h2>
              <div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">
                    	<s:iterator value="competitionResults" id="result" status="status">
		        			<strong><s:property value="#result.vcompetitorUnit"/></strong>
		        			<s:if test="#status.index==0">
		        				vs<input id="left-comp" class="hidden" value="<s:property value='#result.bcompetitionResultId'/>">
		        			</s:if>
		        			<s:else>
		        				<input id="right-comp" class="hidden" value="<s:property value='#result.bcompetitionResultId'/>">
		        			</s:else>
		        		</s:iterator>
                    	<s:if test="competition.vcompetitionState=='0001'">
        				未开始
	        			</s:if>
	        			<s:elseif test="competition.vcompetitionState=='0010'">
	        				直播中
	        			</s:elseif>
	        			<s:elseif test="competition.vcompetitionState=='0011'">
	        				已结束
	        			</s:elseif> 
                    </h3>
                  </div>
                  <div class="panel-body">
                    <div class="row">
                    	<div class=" col-sm-2"></div>
                        <div class="col-sm-8">
                        	<div class="row text-center">
                            	<div class="col-sm-4"><!-- A方得分 -->
                                	<div class="row text-info" style="font-size:36px; font-weight:bolder;">
                                	<s:if test="competition.vcompetitionState=='0010'&&#session.cur_user_roleid==2">
                                    	<div class="col-sm-12">
                                        	<div class="row">
                                        		<a class="btn btn-default btn-xs col-sm-offset-8 col-sm-4 left-add" href="#" role="button">
                                        			+
                                       			</a>
                                            </div>
                                        </div>
                                    </s:if>
                                    	<div class="col-sm-12">
                                        	<div class="row">
                                        		<span class="col-sm-offset-8 col-sm-4 left-scores">
                                        			<s:iterator value="competitionResults" id="result" status="status">
									        			<s:if test="#status.index==0">
									        				<s:property value="#result.iscores"/>
									        			</s:if>
									        		</s:iterator>
                                        		</span>
                                            </div>
                                        </div>
                                    <s:if test="competition.vcompetitionState=='0010'&&#session.cur_user_roleid==2">
                                    	<div class="col-sm-12">
                                        	<div class="row">
                                        		<a class="btn btn-default btn-xs col-sm-offset-8 col-sm-4 left-sub" href="#" role="button">
                                        			-
                                       			</a>
                                            </div>
                                        </div>
                                   </s:if>
                                    </div>
                                </div>
                            	<div class="col-sm-4"><!-- :(vs) -->
                                	<div class="row" style="font-size:36px; font-weight:bolder;">
                                		:
                               		</div>
                                </div>
                            	<div class="col-sm-4"><!-- B方得分 -->
                                	<div class="row text-info"  style="font-size:36px; font-weight:bolder;">
                                	<s:if test="competition.vcompetitionState=='0010'&&#session.cur_user_roleid==2">
                                    	<div class="col-sm-12">
                                        	<div class="row">
                                        		<a class="btn btn-default btn-xs col-sm-4 right-add" href="#" role="button">
                                        			+
                                       			</a>
                                            </div>
                                        </div>
                                    </s:if>
                                    	<div class="col-sm-12">
                                        	<div class="row">
                                        		<span class="col-sm-4 right-scores">
                                        			<s:iterator value="competitionResults" id="result" status="status">
									        			<s:if test="#status.index==1">
									        				<s:property value="#result.iscores"/>
									        			</s:if>
									        		</s:iterator>
                                        		</span>
                                            </div>
                                        </div>
                                    <s:if test="competition.vcompetitionState=='0010'&&#session.cur_user_roleid==2">
                                    	<div class="col-sm-12">
                                        	<div class="row">
                                        		<a class="btn btn-default btn-xs col-sm-4 right-sub" href="#" role="button">
                                        			-
                                       			</a>
                                            </div>
                                        </div>
                                    </s:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-2"></div>
                    </div>
                    <div class="row text-right">
                    	<s:if test="competition.vcompetitionState=='0001'&&#session.cur_user_roleid==2">
                    		<a class="btn btn-primary start-btn" href="#" role="button">开始比赛</a> 
	        			</s:if>
	        			<s:elseif test="competition.vcompetitionState=='0010'#session.cur_user_roleid==2">
	        				<a class="btn btn-primary end-btn" href="#" role="button">结束比赛</a> 
	        			</s:elseif>
                    	<a class="btn btn-info" href="competitionDetails.action?ci=<s:property value='competition.bcompetitionId'/>" role="button">更多详情</a> 
                    	<span>&nbsp;</span>
                    </div>
                  </div>
                </div>
            </div>
        </div>
    </div>
    
    <hr/>
    <div class="row text-right">
    	<div class=" col-sm-12">
            <a class="btn btn-info show-comments-btn" role="button" data-toggle="collapse" href="#competition-comments-module" aria-expanded="false" 
                aria-controls="competition-comments-module">
              查看评论
            </a>
        </div>
    </div>
   
    <!-- 引入评论模块 -->
    <jsp:include page="competition_comment_module.jsp"/>
    <jsp:include page="common_footer.jsp"/>
</div>

<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/competition_comment_module.js"></script>
<script type="text/javascript" src="js/competition_live.js"></script>
</body>
</html>
