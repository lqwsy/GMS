package com.gms.action;

import java.util.List;
import java.util.Map;

import com.gms.po.Roleinfo;
import com.gms.po.Userinfo;
import com.gms.service.impl.RoleinfoServiceImpl;
import com.gms.service.impl.UserinfoServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserinfoAction extends ActionSupport {

	private String vusername;
	private String vpassword;
	private String newpasword;
	private String searchname;
	private Userinfo user;
	private String str_result;
	private String regist_result;
	private UserinfoServiceImpl userinfoService;
	private RoleinfoServiceImpl roleinfoService;

	public String getRegist_result() {
		return regist_result;
	}

	public void setRegist_result(String regist_result) {
		this.regist_result = regist_result;
	}
	
	public RoleinfoServiceImpl getRoleinfoService() {
		return roleinfoService;
	}

	public void setRoleinfoService(RoleinfoServiceImpl roleinfoService) {
		this.roleinfoService = roleinfoService;
	}

	public String getSearchname() {
		return searchname;
	}

	public void setSearchname(String searchname) {
		this.searchname = searchname;
	}
	
	public String getNewpasword() {
		return newpasword;
	}

	public void setNewpasword(String newpasword) {
		this.newpasword = newpasword;
	}
	
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
			map.put("cur_user", loginuser.get(0));//向session存入登录标识ID,以供登录后检验使用
//			map.put("cur_userName", user.getVuserName());//向session存入用户名字,以供登录后检验使用
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
			this.setRegist_result("注册成功,请重新登录");
			return SUCCESS;
		} else {
			this.setRegist_result("注册失败");
			System.out.println("用户是否已存在："+isUserNameExistent(user.getVuserName()));
			return ERROR;
		}
	}

	//用户更改密码
	public String updatePassword(){
		if(user==null){
			return INPUT;
		}
//		if(user.getVpassward()){
		System.out.println("new password is: "+user.getVpassward());
//			userinfoService.updateUserinfo(user);
			return SUCCESS;
//		}
		
//		return ERROR;
	}
	
	//更新用户资料
	public String updateUser(){
		if(user==null){
			return INPUT;
		}
		Roleinfo role = roleinfoService.getRoleinfoById(user.getRoleinfo().getIroleId());
		user.setRoleinfo(role);
		System.out.println("realname: "+user.getVrealName());
		System.out.println("shenfenzhengdizhi: "+user.getVidentifierAddress());
		System.out.println("state: "+user.getIvstate());
		System.out.println("collage: "+user.getVcollege());
		System.out.println("lianxidizhi: "+user.getVaddress());
		System.out.println("jeseid: "+user.getRoleinfo().getVroleName());
		System.out.println("user: "+user.toString());
		
		userinfoService.updateUserinfo(user);
		return SUCCESS;
	}
	
	//用户退出
	public String exit(){
		Map<String,Object> map=ActionContext.getContext().getSession();
		map.remove("cur_user");
		map.remove("all_users");
		map.remove("search_users");
		return SUCCESS;
	}
	
	//查找用户
	public String searchUser(){
		if(searchname==null){
			List<Userinfo> allusers = userinfoService.getAllUserinfo();
			System.out.println("all "+allusers.size()+" users");
			Map<String,Object> map=ActionContext.getContext().getSession();
			map.remove("search_users");
			map.remove("all_users");
			map.put("all_users", allusers);//向session存入所有用户的对象集
			return SUCCESS;
		}else {
			List<Userinfo> searchusers = userinfoService.getUserinfoByName(searchname);
			System.out.println("searchname is:  "+searchname);
			System.out.println("search "+searchusers.size()+" user");
			Map<String,Object> map=ActionContext.getContext().getSession();
			map.remove("search_users");
			map.remove("all_users");
			map.put("search_users", searchusers);//向session存入根据姓名查询的所有用户的对象集
			return SUCCESS;
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
