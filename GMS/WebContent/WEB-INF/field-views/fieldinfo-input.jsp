<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>场地添加</title>

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
            <div class="page-header"><!-- 包含标题-->
              <h1>场地 <small>信息填写</small></h1>
            </div>
           <form id="field-input-form" class="form-horizontal" method="post" action="Fieldinfo-addFieldinfo.action"><!--包含内容-->
              <div class="form-group form-group-sm">
                <label class="col-sm-1 control-label" for="fieldName">场地名称</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="fieldName" value="${fieldinfo.fieldName }" name="fieldinfo.fieldName" placeholder="场地名">
                  <%-- <s:textfield class="form-control" id="fieldName" name="fieldinfo.fieldName"></s:textfield> --%>
                </div>
                <label class="col-sm-2 control-label" for="location">场地地址</label>
                <div class="col-sm-5">
                  <input class="form-control" type="text" id="location" value="${ fieldinfo.location}" name="fieldinfo.location" placeholder="地址位置">
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-1 control-label" for="fieldtype">所属类型</label>
                <div class="col-sm-4">
                   <%-- <select class="form-control" id="fieldtype" name="fieldinfo.fieldtype.fieldtypeId">
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
					  </select>  --%>
				  <s:select class="form-control" id="fieldtype" list="#request.fieldtypes" listKey="fieldtypeId"
				   listValue="fieldtypeName" name="fieldinfo.fieldtype.fieldtypeId"></s:select>
                </div>
                <label class="col-sm-2 control-label" for="size">场地大小/平方米</label>
                <div class="col-sm-5">
                  <input class="form-control" type="text" id="size" value="${ fieldinfo.size}" name="fieldinfo.size" placeholder="场地大小">
                </div>
              </div>
              <div class="form-group form-group-sm">
                <label class="col-sm-1 control-label" for="people">可供人数</label>
                <div class="col-sm-4">
                  <input class="form-control" type="text" id="people" value="${ fieldinfo.people}" name="fieldinfo.people" placeholder="可供人数">
                </div>
                <label class="col-sm-2 control-label" for="rentH">租金(元/每节)</label>
                <div class="col-sm-5">
                  <input class="form-control" type="text" id="rentH" value="${ fieldinfo.rentH}" name="fieldinfo.rentH" placeholder="￥">
                </div>
              </div>
              <input type="hidden" value="${fieldinfo.fieldId }" name="fieldinfo.fieldId"/>
              <div class="form-group">
                <div class="col-sm-offset-1 col-sm-1">
                  <button type="submit" class="btn btn-primary btn-block">提交</button>
                </div>
              </div>
            </form>
        </div>
    </div>
    
    <!-- jsp包含页面脚部 -->
    <jsp:include page="/common_footer.jsp"/>
</div>

<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/field-input.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $("#field-input-form").validate({  
        rules: {  
            'fieldinfo.fieldName': {
            	required: true
            },  
            'fieldinfo.location': {
            	required: true 
            },
            'fieldinfo.size': {
            	required: true,
            	min:0
            },
            'fieldinfo.people': {
            	required: true,
             	min:0
            },
            'fieldinfo.rentH': {
            	required: true,
            	min:0
            }
        },  
        messages: {  
        	'fieldinfo.fieldName': {
            	required: "请输入场地名"
            },  
            'fieldinfo.location': {
            	required: "请输入场地位置" 
            },
            'fieldinfo.size': {
            	required: "请输入场地大小",
            	min:"值必须大于或等于0"
            },
            'fieldinfo.people': {
            	required: "请输入容纳人数",
             	min: "值必须大于或等于0"
            },
            'fieldinfo.rentH': {
            	required: "请输入租用费用",
            	min: "值必须大于或等于0"
            }
        }  
    });  
});  
</script>
<s:if test='#request.repeat == true'>
	<script type="text/javascript">
		alert("场地名已存在，操作失败!");
	</script>
</s:if>

</body>
</html>
