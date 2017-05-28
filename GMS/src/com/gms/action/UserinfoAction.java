package com.gms.action;

import java.util.List;
import java.util.Map;

import com.gms.po.Roleinfo;
import com.gms.po.Userinfo;
import com.gms.service.impl.UserinfoServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserinfoAction extends ActionSupport {

	private String vusername;
	private String vpassword;
	private Userinfo user;
	private String str_result;
	private UserinfoServiceImpl userinfoService;

	public String getStr_result() {
		return str_result;
	}

	public void setStr_result(String str_result) {
		this.str_result = str_result;
	}
	
	public UserinfoServiceImpl getUserinfoService() {
		return userinfoService;
	}

	public void setUserinfoService(UserinfoServiceImpl userinfoService) {
		this.userinfoService = userinfoService;
	}

	public String getvusername() {
		return vusername;
	}

	public void setvusername(String vusername) {
		this.vusername = vusername;
	}

	public String getvpassword() {
		return vpassword;
	}

	public void setvpassword(String vpassword) {
		this.vpassword = vpassword;
	}

	public Userinfo getUser() {
		return user;
	}

	public void setUser(Userinfo user) {
		this.user = user;
	}



	// 用户登录
	public String login() {
		if (this.user == null) {
			return INPUT;
		}
		if(userinfoService == null){
			return ERROR;
		}
		List<Userinfo> loginuser = userinfoService.getUserinfoByUserName(user.getVuserName());
		if(loginuser.isEmpty()){
			return ERROR;
		}
		if (user.getVpassward().equals(loginuser.get(0).getVpassward())) {
			Map<String,Object> map=ActionContext.getContext().getSession();
			map.put("cur_user", user.getIuserId());//向session存入登录标识ID,以供登录后检验使用
			return SUCCESS;
		} else {
			this.setStr_result("用户名与密码不匹配");
		}
		return ERROR;
	}

	// 用户注册
	public String regist() {
		if (this.user == null) {
			return INPUT;
		}
		if (!isUserNameExistent(user.getVuserName())) {
			Roleinfo role = new Roleinfo();
			role.setIroleId(5);
			user.setRoleinfo(role);
			userinfoService.addUserinfo(user);
			return SUCCESS;
		} else {
			System.out.println("用户是否已存在："+isUserNameExistent(user.getVuserName()));
			return ERROR;
		}
	}

	// 用户名是否已存在
	public boolean isUserNameExistent(String vusername) {
		if (userinfoService.getUserinfoByUserName(vusername).isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
