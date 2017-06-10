<%@page import="freemarker.template.SimpleDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>场地租用记录管理</title>

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
    	<%
    		String status = (String)request.getAttribute("status");
    		pageContext.setAttribute("mstatus", status);
    	%>
    	<!--jsp包含导航栏-->
    	<jsp:include page="/common_navi.jsp"/>
        <div class="col-sm-10">
        	<div class="page-header"><!-- 包含标题-->
              <h1>查询场地租用记录 <small>信息填写</small></h1>
            </div>
            <form class="form-horizontal" method="post" action="Fieldrent-queryFieldrent.action" onsubmit="return checkForm()">
            <div class="form-group form-group-sm">
            	<label class="col-sm-1 control-label" for="rentDate">租用日期</label>
                <div class="col-sm-2">
                	<select class="form-control" id="rentYear" name="rentYear">
                  		<option value="">--请选择--</option>
                  		<%
		            		int year = Calendar.getInstance().get(Calendar.YEAR);
		            		for(int i = 0; i < 7; i++) {
		            			out.print("<option value=" + (year-i) + ">");	
		            			out.println((year-i) + "年</option>");
		            		} 
		            		out.println(year);
		                %>
                  	</select>
                </div>
                <div class="col-sm-2">
                	<select class="form-control" id="rentMonth" name="rentMonth">
                  		<option value="">--请选择--</option>
                  		<%
		            		for(int i = 1; i <= 12; i++) {
		            			String a;
		            			if(i <= 9) {
		            				a = "0"+i;
		            			}else {
		            				a = String.valueOf(i);
		            			}
		            			out.print("<option value=" + a + ">");	
		            			out.println(a + "月</option>");
		            		} 
		                %>
                  	</select>
                </div>
                <div class="col-sm-2">
                	<select class="form-control" id="rentDay" name="rentDay">
                  		<option value="">--请选择--</option>
                  		<%
		            		for(int i = 1; i <= 31; i++) {
		            			String a;
		            			if(i <= 9) {
		            				a = "0"+i;
		            			}else {
		            				a = String.valueOf(i);	
		            			}
		            			out.print("<option value=" + a + ">");	
		            			out.println(a + "日</option>");
		            		} 
		                %>
                  	</select>
                </div>
                <%-- <label class="col-sm-2 control-label" for="fieldName">场地名称</label>
                <div class="col-sm-2">
                	<select class="form-control" id="fieldName" name="fieldName"">
                  		<option value="">--请选择--</option>
                  	</select>
                </div> --%>
                <label class="col-sm-2 control-label" for="status">订单状态</label>
                <div class="col-sm-2">
                	<select class="form-control" id="status" name="status"> 
                		<option value="true">有效</option>
                		<option value="false">无效/过期</option>
                	</select>
                </div>
            </div>
            <div class="form-group form-group-sm">
            	<label class="col-sm-1 control-label" for="fieldtypeId">场地类型</label>
                <div class="col-sm-2">
                <!-- 用s：iterator或c：forEach也可以实现select -->
                  <select class="form-control" id="fieldtypeId" name="fieldtypeId" onchange="loadFieldName()">
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
                <label class="col-sm-2 control-label" for="fieldId">场地名称</label>
                <div class="col-sm-2">
                <select class="form-control" id="fieldId" name="fieldId"> <!-- 二级联动 -->
                	<option value="">--请选择--</option>
                </select>
                </div>
                <label class="col-sm-2 control-label" for="userName">用户名</label>
                <div class="col-sm-2">
                  <input class="form-control" type="text" id="userName" name="userName" placeholder="租用用户">
                </div>
                <div class="col-sm-1">
                  <button type="submit" class="btn btn-success">查询</button>
                </div>
            </div>
            </form>
	           <table class="table table-bordered table-hover text-center">
					<tr class="info" style="font-weight: bold;">
						<td>序号</td>
						<td>场地名</td>
						<td>地址</td>
						<td>租用用户名</td>
						<td>租用日期</td>
						<td>租用时间</td>
						<td>租金/元</td>
						<td>订单状态</td>
						<td>删除(有效订单不可删除)</td>
					</tr>
					<s:iterator value="#request.fieldrents" id="frs" status="st">
					<tr>
						<td><s:property value="#st.index+1"/></td>
						<td><s:property value="fieldinfo.fieldName"/></td>
						<td>${fieldinfo.location }</td>
						<td>${userinfo.vuserName }</td>
						<td>
							<s:date name="rentDate" format="yyyy-MM-dd"></s:date>
						</td>
						<td>${rentTime}</td>
						<td>${rent }元</td>
						<td>
							<s:if test='#attr.mstatus == "false"'>
								<p style="color: red;">无效/过期</p>
							</s:if>
							<s:else>
								有效
							</s:else>
						</td>
						<td>
							<s:if test='#attr.mstatus == "false"'>
								<button type="button" class="btn btn-danger delete-btn btn-sm">
									  彻底删除 
								</button>
								<input type="hidden" value="${fieldrentId}"  /> <!-- 隐藏域 -->
								<input type="hidden" value="${fieldinfo.fieldName }" />
								<input type="hidden" value="${userinfo.vuserName }" />
								<input type="hidden" value="${rentDate} " />
								<input type="hidden" value="${rentTime} " />
								<input type="hidden" value="${rent} " />
							</s:if>
							<s:else>
								<mark>订单为有效状态，不可删除 </mark>
							</s:else>
						</td>
					</tr>
					</s:iterator>
				</table>
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title" id="myModalLabel">确定要彻底删除该记录吗?</h4>
							      </div>
							      <div class="modal-body">
							        <p class="UN"></p>
							        <p class="FN"></p>
							        <p class="RD"></p>
							        <p class="RT"></p>
							        <p class="R"></p>
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							        <button type="button" class="btn btn-primary post-delete">确定</button>
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

	function checkForm() {
		var rentYear = $("#rentYear").val();
		var rentMonth = $("#rentMonth").val();
		var rentDay = $("#rentDay").val();
		if((rentYear != "" || rentMonth != "" || rentDay != "") &&
			!(rentYear != "" && rentMonth != "" && rentDay != "")) {
			alert("租用日期不能够仅选择部分!");
			return false;
		}
		return true;
	}

	function loadFieldName() {
		var fieldtypeId = document.getElementById("fieldtypeId").value;
		var fieldId = document.getElementById("fieldId");
		fieldId.options.length = 0;  //每次调用load加载选项之前，都清零！
		$.ajax({
			url:"Fieldrent-ejldAjax.action",
			type:"POST",
			data:{
				"fieldtypeId":fieldtypeId
			},
			success:function(data){
				for(var i in data){
					fieldId.options.add(new Option(data[i].fieldName,data[i].fieldId));
				}
			}
		});
	}

	 $(".delete-btn").click(function(){
		$this = $(this);
		var fieldrentId = $this.next().val();
		var fieldName = $this.next().next().val();
		var userName = $this.next().next().next().val();
		var rentTime = $this.next().next().next().next().val();
		var rentDate = $this.next().next().next().next().next().val();
		var rent = $this.next().next().next().next().next().next().val();
		$(".UN").html("租用用户：" + userName);
		$(".FN").html("场地名：" + fieldName); //给bootstrap的弹出框填充内容 
		$(".RD").html("租用日期：" + rentDate);
		$(".RT").html("租用时间：" + rentTime.substring(0, 10)); //这里日期显示要转换
		$(".R").html("费用：" + rent + "元");
		
		$('#myModal').modal('show');
		$(".post-delete").click(function() {
			var url = "http://localhost:8080/GMS/Fieldrent-realDelete.action";
			var args = {"fieldrentId":fieldrentId};
			$.post(url,args,function(data) {	
				//若返回data为1，删除成功，删除当前行
				if(data == 1) {
					$('#myModal').modal('hide');
					alert("彻底删除成功 ！");
					var tr = $this.parent().parent();
					tr.remove();
				}else { //若返回data为0，删除失败 
					alert("彻底删除失败!");
				}
			}); 
		});	
	}); 

</script>
</body>
</html>
