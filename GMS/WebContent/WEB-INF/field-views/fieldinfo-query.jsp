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
<%@ page import="com.gms.po.Fieldinfo" %>
<%@ page import="java.util.*" %>
</head>

<body>


<!-- jsp包含头部-->
<jsp:include page="/common_header.jsp"/>
<div class="container">
	<div class="row">
    
    	<!--jsp包含导航栏-->
    	<jsp:include page="/common_navi.jsp"/>
        <div class="col-sm-10">
           <form class="form-horizontal" method="post" action="Fieldinfo-queryFieldinfo.action"><!--包含内容-->
              <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="rentDate">租用日期</label>
                <div class="col-sm-2">
                	<select class="form-control" id="rentDate" name="rentDate"> 
                		<option value="今天">今天</option>
                		<option value="明天">明天</option>
                	</select>
                </div>
                <label class="col-sm-2 control-label" for="fieldtypeId">场地类型</label>
                <div class="col-sm-2">
                  <select class="form-control" id="fieldtypeId" name="fieldtypeId">
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
                <label class="col-sm-2 control-label" for="rentTime">租用时间</label>
                <div class="col-sm-2">
                	<select class="form-control" id="rentTime" name="rentTime"> 
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
                		<option value="enable">仅可租用</option>
                		<option value="all">全部显示</option>
                	</select>
                </div>
                <div class="col-sm-offset-1 col-sm-2">
                  <button type="submit" class="btn btn-success">查询</button>
                </div>
              </div>
            </form>
            	<br/>
	           <table class="table table-bordered table-striped text-center">
					<h4 class="text-center">场地查询结果</h4>
					<tr class="info">
						<td>场地名</td>
						<td>地址</td>
						<td>大小/平方米</td>
						<td>可供人数</td>
						<td>租金(元/每节)</td>
						<td>租借</td>
						<td>修改</td>
						<td>删除</td>
					</tr>
					<s:iterator value="#request.fieldinfos">
					<tr>
						<td>${fieldName }</td>
						<td>${location }</td>
						<td>${size }</td>
						<td>${people}</td>
						<td>${rentH }</td>
						<td>
							<button type="button" class="btn btn-primary rent-btn" href="Fieldrent-request.action">租借</button>
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
				</table>
				<input type="hidden" value="${rentTime }" id="rentTime-hidden" />
				<input type="hidden" value="${rentDate }" id="rentDate-hidden" />
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
		var rent = 0;  /*租金*/
		if(rentTime == "一整天") {	//如果是租用一整天，租金6倍 
			rent = rentH*6;
		}else {
			rent = rentH;
		}
		var flag = confirm("租用信息如下: \r\n 场地名：" + fieldName 
				  + "\r\n 租用日期：" + rentDate
				  + "\r\n 租用时间：" + rentTime
				  + "\r\n 费用：" + rent
				  + "\r\n您确定要租用吗？");
		if(flag) {
			alert("确定");
		}
		return false;
	});
</script>
</body>
</html>
