<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>我的场地租用记录</title>

<link rel="stylesheet" href="css/bootstrap.min.css"/>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
              <h1><small>我的--</small>场地租用记录</h1>
            </div>
	           <table class="table table-bordered table-striped text-center">
					<tr class="info">
						<td>序号</td>
						<td>场地名</td>
						<td>地址</td>
						<td>租用日期</td>
						<td>租用时间</td>
						<td>租金/元</td>
						<td>退租【仅次日往后的预定可退租】</td>
					</tr>
					<s:iterator value="#request.fieldrentinfos" status="status">
					<tr>
						<td><s:property value="#status.index+1"/></td>
						<td><s:property value="fieldinfo.fieldName"/></td>
						<td>${fieldinfo.location }</td>
						<td>
							<s:date name="rentDate" format="yyyy-MM-dd"></s:date>
						</td>
						<td>${rentTime}</td>
						<td>${rent }元</td>
						<%
							Date nowDate = new Date();
							Date date = (Date)request.getAttribute("rentDate");
							pageContext.setAttribute("nowDate", nowDate.getTime());
							pageContext.setAttribute("date", date.getTime());
							
						%>
						<td>
							<s:if test="#attr.date > #attr.nowDate"> <!-- ONGL里面page值域只能这样取值 -->
								<button type="button" class="btn btn-primary btn-sm no-rent-btn">
									  退租
								</button>
								<input type="hidden" value="${fieldrentId}"  /> <!-- 隐藏域 -->
								<input type="hidden" value="${fieldinfo.fieldName }" />
								<input type="hidden" value="${rentDate} " />
								<input type="hidden" value="${rentTime} " />
								<input type="hidden" value="${rent} " />
							</s:if>
							<s:else>
								<mark>订单已生效，不可退租</mark>
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
							        <h4 class="modal-title" id="myModalLabel">确定要退租吗?</h4>
							      </div>
							      <div class="modal-body">
							        <p class="FN"></p>
							        <p class="RD"></p>
							        <p class="RT"></p>
							        <p class="R"></p>
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							        <button type="button" class="btn btn-primary post-no-rent">确定</button>
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
	 $(".no-rent-btn").click(function(){
		$this = $(this);
		var fieldrentId = $this.next().val();
		var fieldName = $this.next().next().val();
		var rentTime = $this.next().next().next().val();
		var rentDate = $this.next().next().next().next().val();
		var rent = $this.next().next().next().next().next().val();
		$(".FN").html("场地名：" + fieldName); //给bootstrap的弹出框填充内容 
		$(".RD").html("租用日期：" + rentDate);
		$(".RT").html("租用时间：" + rentTime.substring(0, 10)); //这里日期显示要转换
		$(".R").html("费用：" + rent + "元");
		
		$('#myModal').modal('show');
		$(".post-no-rent").click(function() {
			var url = "http://localhost:8080/GMS/Fieldrent-delete.action";
			var args = {"fieldrentId":fieldrentId};
			 $.post(url,args,function(data) {	
				//若返回data为1，删除成功，删除当前行
				if(data == 1) {
					$('#myModal').modal('hide');
					alert("退租成功 ！");
					var tr = $this.parent().parent();
					tr.remove();
				}else { //若返回data为0，删除失败 
					alert("退租失败!");
				}
			}); 
		});	
	}); 

</script>
</body>
</html>
