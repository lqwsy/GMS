<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>赛事列表</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>

<body>

<jsp:include page="common_header.jsp"/>
<div class="container">
	<div class="row">
	
		<jsp:include page="common_navi.jsp"/>
        <div class="col-sm-10">
        	<div class="page-header">
              <h1>
              	<s:if test="actionName=='my'">我的赛事</s:if>
              	<s:elseif test="actionName=='verify'">赛事审核</s:elseif>
              	<s:elseif test="actionName=='live'">正在直播</s:elseif>
              	<s:elseif test="actionName=='search'||actionName=='searchAll'">
              		<s:if test="keyword==null">
              			赛事搜索
              		</s:if>
              		<s:else>
              			"<s:property value='keyword'/>" 搜索结果
              		</s:else>
              	 </s:elseif>
              	<s:if test="keyword==null&&actionName=='search'"><small>条件输入</small></s:if>
              	<s:if test="actionName=='searchAll'"><small>所有赛事</small></s:if>
              	<s:else><small>赛事列表</small></s:else>
              </h1>
            </div>
            <s:if test="actionName=='search'||actionName=='searchAll'">
            <div class="row">
            	<div class="col-sm-12 text-right">
	            	<form class="form-inline" action="searchCompetitions.action">
					  <div class="form-group">
					    <div class="input-group">
					      <input type="text" class="form-control" placeholder="关键字" name="keyword">
					    </div>
					  </div>
					  <button type="submit" class="btn btn-primary">搜索</button>
					  <a class="btn btn-default" href="searchAllCompetitions.action" role="button">显示所有</a>
					</form>
				</div>
			</div>
            </s:if>
            <div class="row">&nbsp;</div>
            <table class="table table-hover comp-list-tab">
              <tr>
              	<th>#</th>
              	<th>比赛A方</th>
              	<th>比赛B方</th>
                <th>赛事类型</th>
                <th>比赛时间</th>
                <th>主办单位</th>
                <th>赛事状态</th>
                <th>操作</th>
              </tr>
              <s:iterator value="competitions" id="competition" status="status">
              <tr>
              	<td><s:property value="#status.count"/></td>
              	<s:iterator value="#competition.competitionresults" id="result">
              		<td><s:property value="#result.vcompetitorUnit"/></td>
              	</s:iterator>
                <td><s:property value="#competition.competitiontype.vcompetitionName"/></td>
                <td><s:property value="#competition.dcompetitionDate.toString().substring(0,16)"/></td>
                <td><s:property value="#competition.vmainUnit"/></td>
                <td>
        			<s:if test="#competition.vcompetitionState=='0000'">
        				待审核
        			</s:if>
        			<s:elseif test="#competition.vcompetitionState=='0001'">
        				未开始
        			</s:elseif>
        			<s:elseif test="#competition.vcompetitionState=='0010'">
        				直播中
        			</s:elseif>
        			<s:elseif test="#competition.vcompetitionState=='0011'">
        				已结束
        			</s:elseif>
        			<s:elseif test="#competition.vcompetitionState=='0100'">
        				已取消
        			</s:elseif>       
               </td>
                <td>
                	<div class="dropdown">
                      <a id="dLabel" data-target="#" href="#" data-toggle="dropdown" 
                      	role="button" aria-haspopup="true" aria-expanded="false">
                        更多
                        <span class="caret"></span>
                      </a>
                    
                      <ul class="dropdown-menu" aria-labelledby="dLabel">
                        <li>
                        	<a href="competitionDetails.action?ci=<s:property value='#competition.bcompetitionId'/>">
                        		查看详情
                        	</a>
                        </li>
            			<s:if test="#competition.vcompetitionState=='0000'&&actionName=='my'">
        					<li><a class="cancel-comp-btn" id="comp-cancel-<s:property value='#competition.bcompetitionId'/>" href="javascript:void(0);">取消赛事</a></li>
                        </s:if>
                        <s:elseif test="#competition.vcompetitionState=='0010'||actionName=='live'">
                        	<li><a href="competitionLive.action?ci=<s:property value='#competition.bcompetitionId'/>">查看直播</a></li>
                        </s:elseif>
                        <s:if test="#competition.vcompetitionState!='0100'&&actionName=='my'">
                        	<li><a href="updateCompetition.action?ci=<s:property value='#competition.bcompetitionId'/>">更新赛事</a></li>
                        </s:if>
                      </ul>
                    </div>
                </td>
              </tr>
               </s:iterator>
            </table>
            <s:if test="actionName=='searchAll'">
            	<div><ul class="pages-ul pagination"></ul></div>
            </s:if>
            <span class="hidden" id="cur-page-span"><s:property value="page"/></span>
        </div>
    </div>
    <jsp:include page="competition_operation_tips.jsp"/>
    <jsp:include page="common_footer.jsp"/>
</div>
<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/competition_list.js"></script>
</body>
</html>
