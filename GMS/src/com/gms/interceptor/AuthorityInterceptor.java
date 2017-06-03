package com.gms.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor{
	private String role;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		String cur_role=(String)arg0.getInvocationContext().getSession().get("cur_user_roleid");
		if(!role.equals(cur_role)){
			HttpServletRequest request=ServletActionContext.getRequest();
			String reqType = request.getHeader("X-Requested-With");
			if("XMLHttpRequest".equalsIgnoreCase(reqType)){
				PrintWriter printWriter = ServletActionContext.getResponse().getWriter();  
                printWriter.print("-1");  
                printWriter.flush();  
                printWriter.close();  

                return null; 
			}
			return "noauthority";
		}
		return arg0.invoke();
	}

}
