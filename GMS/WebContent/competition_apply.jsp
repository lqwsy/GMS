<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>赛事申请</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css"/>
<link rel="stylesheet" href="css/competition_apply.css"/>
</head>

<body>
<!-- jsp包含头部-->
<jsp:include page="common_header.jsp"/>
<div class="container">
	<div class="row">
    	<!--jsp包含导航栏-->
    	<jsp:include page="common_navi.jsp"/>
        <div class="col-sm-10">
            <div class="page-header"><!-- 包含标题-->
              <h1>赛事申请 <small>信息填写</small></h1>
            </div>
           <form class="form-horizontal" id="compeition-apply-form"><!--包含内容-->
           	<div class="row all-page">
           	<div class="col-sm-12 first-page">
              <div class="form-group form-group-sm">
                <label class="col-sm-1 control-label" for="playerAInput">比赛A方</label>
                <div class="col-sm-5">
                  <input class="form-control" type="text" id="playerAInput" label="比赛A方"
                   name="competitionresults.makeNew[0].vcompetitorUnit">
                </div>
                <label class="col-sm-1 control-label" for="playerBInput">比赛B方</label>
                <div class="col-sm-5">
                  <input class="form-control" type="text" id="playerBInput" label="比赛B方"
                  name="competitionresults.makeNew[1].vcompetitorUnit">
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-1 control-label" for="competitionTypeInput">赛事类型</label>
                <div class="col-sm-5">
                  <select class="form-control" name="competition.competitiontype.icompetitionType">
					  <s:iterator value="competitionTypes" id="competitionType">
					  	<option value="<s:property value='#competitionType.icompetitionType'/>">
					  		<s:property value="#competitionType.vcompetitionName"/>
					  	</option>
					  </s:iterator>
					</select>
                </div>
                <label class="col-sm-1 control-label" for="competitionTimeInput">比赛时间</label>
                <div class="col-sm-5">
                <div class="input-group date form_datetime" data-date="2017-01-01T00:00:07Z" data-date-format="yyyy-mm-dd hh:ii" data-link-field="dtp_input1">
                    <input class="form-control" size="16" type="text" name="competition.dcompetitionDate" label="比赛时间"  readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
 				<input type="hidden" id="dtp_input1" value="" /><br/>
                </div>
              </div>
              <div></div>
              <div class="form-group form-group-sm">
                <label class="col-sm-1 control-label" for="competitionDetailsInput">赛事详情</label>
                <div class="col-sm-11">
                  <textarea class="form-control" rows="5" id="competitionDetailsInput" label="赛事详情"
                   name="competition.vcompetitionDetails"></textarea>
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-1 control-label" for="linkManInput">联系人</label>
                <div class="col-sm-5">
                  <input class="form-control" type="text" id="linkManInput" label="联系人"
                   name="competition.vlinkMan">
                </div>
                <label class="col-sm-1 control-label" for="linkPhoneInput">联系电话</label>
                <div class="col-sm-5">
                  <input class="form-control" type="tel" id="linkPhoneInput" label="联系电话"
                   name="competition.vphoneNumber">
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-1 control-label" for="mainUnitInput">主办单位</label>
                <div class="col-sm-11">
                  <input class="form-control" type="text" id="mainUnitInput" label="主办单位"
                   name="competition.vmainUnit">
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-1 control-label" for="mainUnitAddrInput">单位地址</label>
                <div class="col-sm-11">
                  <input class="form-control" type="text" id="mainUnitAddrInput" label="单位地址"
                   name="competition.vunitAddress">
                </div>
              </div>
              
              <div class="form-group">
                <div class="col-sm-offset-1 col-sm-5">
                  <button type="button" class="btn btn-default next-page-btn">下一步</button>
                </div>
              </div>
              </div><!-- col-sm-12 第一页-->
              <div class="col-sm-12 second-page">
              		<div class="alert alert-info" role="alert">以下内容提交后将不可更改！</div>
              		<div class="form-group form-group-sm">
		                <label class="col-sm-1 control-label" for="competitionTypeInput">场地类型</label>
		                <div class="col-sm-5">
		                  <select class="form-control" id="field-type-select" >
							 <s:iterator value="fieldTypes" id="type" status="status">
							 	<option value="<s:property value='#type.fieldtypeId'/>" <s:if test='#status.index==0'>selected='selected'</s:if>>
									<s:property value='#type.fieldtypeName'/>
						 		</option>
							 </s:iterator>
							</select>
		                </div>
		                <label class="col-sm-1 control-label" for="competitionInput">选择场地</label>
		                <div class="col-sm-5">
		                  <select class="form-control" id="field-info-select" name="spacesuse.fieldinfo.fieldId">
							</select>
		                </div>
             		</div>
              		<div class="form-group form-group-sm">
		                <label class="col-sm-1 control-label" for="equitmentTypeInput">器材类型</label>
		                <div class="col-sm-3">
		                  <select class="form-control" name="">
							  
							</select>
		                </div>
		                <label class="col-sm-1 control-label" for="equitmentInput">选择器材</label>
		                <div class="col-sm-3">
		                  <select class="form-control" name="">
							  
							</select>
		                </div>
		                <label class="col-sm-1 control-label" for="competitionQuantityInput">器材数量</label>
		                <div class="col-sm-3">
		                	<input class="form-control" type="number" id="competitionQuantityInput" name="" >
		                </div>
             		</div>
             		<div class="form-group">
		                <div class="col-sm-offset-1 col-sm-5">
		                  <button type="button" class="btn btn-default last-page-btn">上一步</button>
		                  <button type="button" class="btn btn-default apply-btn">提交申请</button>
		                </div>
              		</div>
              </div>
              <div class="col-sm-12 tips-page">
              		<p class="text-success"></p>
              </div>
              </div>
            </form>
        </div>
    </div>
    <jsp:include page="competition_operation_tips.jsp"/>
    <!-- jsp包含页面脚部 -->
    <jsp:include page="common_footer.jsp"/>
</div>

<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/competition_apply.js"></script>
<script type="text/javascript" src="js/competition_comment_module.js"></script>
</body>
</html>