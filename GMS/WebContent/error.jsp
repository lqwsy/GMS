
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isErrorPage="true" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Exception</title>
</head>
<body>
  <%
      if(exception!=null) {  //这里的exception是内置对象，需要设置该页面为异常页面方可生效。
    	  out.println("错误信息：");
    	  out.println(exception.getMessage());
      }
  %>
</body>
</html>