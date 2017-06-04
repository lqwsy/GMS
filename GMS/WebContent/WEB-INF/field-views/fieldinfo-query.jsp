<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>场地查询</title>

<link rel="stylesheet" href="css/bootstrap.min.css"/>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.gms.po.Fieldtype" %>
<%@ page import="java.util.*" %>
<%@ page import="com.gms.util.DateUtil" %>
</head>

<body>


<!-- jsp包含头部-->
<jsp:include page="/common_header.jsp"/>
<div class="container">
	<div class="row">
    
    	<!--jsp包含导航栏-->
    	<jsp:include page="/common_navi.jsp"/>
        <div class="col-sm-10">
        	<div class="page-header"><!-- 包含标题-->
              <h1>查询场地 <small>信息填写</small></h1>
            </div>
           <form class="form-horizontal" method="post" action="Fieldinfo-queryFieldinfo.action" onsubmit="return checkQuery()">
              <div class="form-group form-group-sm">
                <label class="col-sm-1 control-label" for="rentDate">租用日期</label>
                <div class="col-sm-2">
                	<select class="form-control" id="rentDate" name="rentDate"> 
                		<%
                			String day = DateUtil.getSpecifiedDayAfter(new Date(), 0);
                			String day1 = DateUtil.getSpecifiedDayAfter(new Date(),1);
                			String day2 = DateUtil.getSpecifiedDayAfter(new Date(),2);
                			String day3 = DateUtil.getSpecifiedDayAfter(new Date(),3);
                			String day4 = DateUtil.getSpecifiedDayAfter(new Date(),4);
                			String day5 = DateUtil.getSpecifiedDayAfter(new Date(),5);
                			String day6 = DateUtil.getSpecifiedDayAfter(new Date(),6);
                		%>
                		<option value="">--请选择--</option>
                		<option value="<%=day%>"><%=day%></option>
                		<option value="<%=day1%>"><%=day1%></option>
                		<option value="<%=day2%>"><%=day2%></option>
                		<option value="<%=day3%>"><%=day3%></option>
                		<option value="<%=day4%>"><%=day4%></option>
                		<option value="<%=day5%>"><%=day5%></option>
                		<option value="<%=day6%>"><%=day6%></option>
                	</select>
                </div>
                <label class="col-sm-2 control-label" for="fieldtypeId">场地类型</label>
                <div class="col-sm-2">
                <!-- 用s：iterator或c：forEach也可以实现select -->
                  <select class="form-control" id="fieldtypeId" name="fieldtypeId">
                  <option value="">--请选择--</option>
					  <%
					  	boolean flag = false;
					  	List<Fieldtype> fieldtypes = (List<Fieldtype>)request.getAttribute("fieldtypes");
                		Iterator<Fieldtype> it = fieldtypes.iterator();
                		while(it.hasNext()) {
                			flag = true;
                			Fieldtype fieldtype = it.next();
                			out.print("<option value="+fieldtype.getFieldtypeId()+">");
                			out.print(fieldtype.getFieldtypeName());
                			out.println("</option>");
                		}
                		if(flag == false) {
                			out.println("<option>未定义</option>");
                		}
					  %>
				  </select>
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-1 control-label" for="rentTime">租用时间</label>
                <div class="col-sm-2">
                	<select class="form-control" id="rentTime" name="rentTime"> 
                		<option value="">--请选择--</option>
                		<option value="第一，二节课">第一，二节课</option>
                		<option value="第三，四节课">第三，四节课</option>
                		<option value="第五，六节课">第五，六节课</option>
                		<option value="第七，八节课">第七，八节课</option>
                		<option value="一整天">一整天</option>
                	</select>
                </div>
                <label class="col-sm-2 control-label" for="display">显示类型</label>
                <div class="col-sm-2">
                	<select class="form-control" id="display" name="display"> 
                		<option value="all">全部显示</option>
                		<option value="enable">仅可租用</option>
                	</select>
                </div>
                <div class="col-sm-offset-1 col-sm-2">
                  <button type="submit" class="btn btn-success">查询</button>
                </div>
              </div>
            </form>
	           <table class="table table-bordered table-striped text-center">
					<tr class="info">
						<td>序号</td>
						<td>场地名</td>
						<td>地址</td>
						<td>大小/平方米</td>
						<td>可供人数</td>
						<td>租金(元/每节课)</td>
						<s:if test='#request.display == "enable" && #session.cur_user.iuserId != null'>
							<td>租用</td>
						</s:if>
						<td>修改</td>
						<td>删除</td>
					</tr>
					<s:iterator value="#request.fieldinfos" status="status">
					<tr>
						<td><s:property value="#status.index+1"/></td>
						<td>${fieldName }</td>
						<td>${location }</td>
						<td>${size }</td>
						<td>${people}</td>
						<td>${rentH }元</td>
						<s:if test='#request.display == "enable" && #session.cur_user.iuserId != null'>
						<td>
							<!-- <button type="button" class="btn btn-primary rent-btn">租借</button> -->
							<button type="button" class="btn btn-primary rent-btn btn-sm" >
								  租用
							</button>
							<input type="hidden" value="${fieldId }"  /> <!-- 隐藏域 -->
							<input type="hidden" value="${rentH }" />
							<input type="hidden" value="${fieldName }" />
						</td>
						</s:if>
						<td>
							<a href="Fieldinfo-input.action?fieldId=${fieldId }" class="btn btn-warning btn-sm" role="button">修改</a>
						</td>
						<td>
							<a href="Fieldinfo-delete.action?fieldId=${fieldId }" class="btn btn-danger delete-btn btn-sm" role="button">删除</a>
							<input type="hidden" value="${fieldName }" />
						</td>
					</tr>
					</s:iterator>
				</table>
				<input type="hidden" value="${rentTime }" id="rentTime-hidden" />
				<input type="hidden" value="${rentDate }" id="rentDate-hidden" />
				<input type="hidden" value="${session.cur_user.iuserId }" id="userId-hidden"/>
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title" id="myModalLabel">您确定要租用如下场地吗?</h4>
							      </div>
							      <div class="modal-body">
							        <p class="FN"></p>
							        <p class="RD"></p>
							        <p class="RT"></p>
							        <p class="R"></p>
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							        <button type="button" class="btn btn-primary post-rent">确定</button>
							      </div>
							    </div>
							  </div>
					</div>
        </div>
    </div>
    
    <!-- jsp包含页面脚部 -->
    <jsp:include page="/common_footer.jsp"/>
</div>

<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	 $(".rent-btn").click(function(){
		$this = $(this);
		var fieldId = $this.next().val();
		var rentH = $this.next().next().val();
		var fieldName = $this.next().next().next().val();
		var rentDate = $("#rentDate-hidden").val();
		var rentTime = $("#rentTime-hidden").val();
		var userId = $("#userId-hidden").val();
		var rent = 0;  //租金
		if(rentTime == "一整天") {	//如果是租用一整天，租金6倍 
			rent = rentH*4;
		}else {
			rent = rentH;
		}
		$(".FN").html("场地名：" + fieldName); //给bootstrap的弹出框填充内容 
		$(".RD").html("租用日期：" + rentDate);
		$(".RT").html("租用时间：" + rentTime);
		$(".R").html("费用：" + rent + "元");
		 /* var flag = confirm("租用信息如下: \r\n 场地名：" + fieldName 
				  + "\r\n 租用日期：" + rentDate
				  + "\r\n 租用时间：" + rentTime
				  + "\r\n 费用：" + rent
				  + "\r\n您确定要租用吗？");  */
		$('#myModal').modal('show');
		$(".post-rent").click(function() {
			var url = "http://localhost:8080/GMS/Fieldrent-add.action";
			var args = {"fieldrentinfo.fieldinfo.fieldId":fieldId,
					"rentDate":rentDate,
					"fieldrentinfo.rentTime":rentTime,
					"fieldrentinfo.rent":rent,
					"fieldrentinfo.userinfo.iuserId":userId};
			 $.post(url,args,function(data) {	
				//若返回data为1，删除成功，删除当前行
				if(data == 1) {
					$('#myModal').modal('hide');
					alert("租用成功 ！");
					var tr = $this.parent().parent();
					tr.remove();
				}else { //若返回data为0，删除失败 
					$('#myModal').modal('hide');
					alert("租用失败!");
				}
			}); 
		});	
	}); 

	function checkQuery() {
		if($("#fieldtypeId").val() == "") {
			alert("请选择场地类型");
			return false;
		} else if($("#display").val() == "all") {
			return true;
		} else if($("#rentDate").val() == "" || $("#rentTime").val() == "") {
			alert("请选择租用日期和租用时间");
			return false;
		} else 
			return true;
	}

	$(".delete-btn").click(function() {
		//var fieldName = $(this).next(":input").val(); :input的作用是查找所有的input元素： input, textarea, select 和 button 元素。
		var fieldName = $(this).next(":hidden").val(); //这句效果在这里等同上面
		var flag = confirm("您确定要删除场地：“"+ fieldName +"”吗?");
		if(flag) {
			var tr = $(this).parent().parent();	//获取当前tr标签
			var url = this.href;  //http://localhost:8080/GMS/emp-list?id=x
			//var url = $(this).attr("href");  只有 emp-list?id=x
			var args = {};

			$.post(url,args,function(data) {	
				//若返回data为1，删除成功，删除当前行
				if(data == 1) {
					alert("删除成功！");
					tr.remove();
				}else { //若返回data为0，删除失败 
					alert("场地租借中，删除失败!");
					return false;
				}
			});
		}
		return false; //这里返回false，可以确保get请求不会发出。
	}); 
	
	/* $(".delete-btn").click(function() {
		var fieldName = $(this).next(":hidden").val(); //这句效果在这里等同上面
		var url = this.href;
		var tr = $(this).parent().parent();	//获取当前tr标签
		$(".FN").html("确定要删除场地【" + fieldName + "】吗？");
		$('#myModal').modal('show');
		$(".post-rent").click(function() {
			var args = {};
			$.post(url,args,function(data) {	
				//若返回data为1，删除成功，删除当前行
				if(data == 1) {
					$('#myModal').modal('hide');
					alert("删除成功！");
					tr.remove();
				}else { //若返回data为0，删除失败 
					$('#myModal').modal('hide');
					alert("场地租借中，删除失败!");
				}
			});
		});	
		return false; //这里返回false，可以确保get请求不会发出。
	}); */
	
</script>
</body>
</html>
