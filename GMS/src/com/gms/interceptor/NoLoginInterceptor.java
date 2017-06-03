package com.gms.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class NoLoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		if(arg0.getInvocationContext().getSession().get("cur_user")==null){
			HttpServletRequest request=ServletActionContext.getRequest();
			String reqType = request.getHeader("X-Requested-With");
			if("XMLHttpRequest".equalsIgnoreCase(reqType)){
				PrintWriter printWriter = ServletActionContext.getResponse().getWriter();  
                printWriter.print("-1");  
                printWriter.flush();  
                printWriter.close();  

                return null; 
			}
			return Action.LOGIN;
		}
		return arg0.invoke();
	}

}
