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
	private int newpaswordId;
	private String searchname;
	private Userinfo user;
	private String str_result;
	private String regist_result;
	private UserinfoServiceImpl userinfoService;
	private RoleinfoServiceImpl roleinfoService;
	private int roleId;
	private String newusername;
	private String newuserpassword;
	private int changeuserstate;
	private int changeuserrole;
	private int changeuserId;
	
	public int getNewpaswordId() {
		return newpaswordId;
	}

	public void setNewpaswordId(int newpaswordId) {
		this.newpaswordId = newpaswordId;
	}
	
	public int getChangeuserId() {
		return changeuserId;
	}

	public void setChangeuserId(int changeuserId) {
		this.changeuserId = changeuserId;
	}

	public int getChangeuserstate() {
		return changeuserstate;
	}

	public void setChangeuserstate(int changeuserstate) {
		this.changeuserstate = changeuserstate;
	}

	public int getChangeuserrole() {
		return changeuserrole;
	}

	public void setChangeuserrole(int changeuserrole) {
		this.changeuserrole = changeuserrole;
	}

	public String getNewusername() {
		return newusername;
	}

	public void setNewusername(String newusername) {
		this.newusername = newusername;
	}

	public String getNewuserpassword() {
		return newuserpassword;
	}

	public void setNewuserpassword(String newuserpassword) {
		this.newuserpassword = newuserpassword;
	}


	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

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
			this.setStr_result("用户不存在");
			return ERROR;
		}
		if (user.getVpassward().equals(loginuser.get(0).getVpassward())) {
			Map<String,Object> map=ActionContext.getContext().getSession();
			map.put("cur_user", loginuser.get(0));//向session存入登录标识ID,以供登录后检验使用
			map.put("cur_user_roleid", Integer.toString(loginuser.get(0).getRoleinfo().getIroleId()));//向session存入登录标识ID,以供登录后检验使用
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
		} else if(isUserNameExistent(user.getVuserName())){
			this.setRegist_result("注册失败,用户名已存在");
			System.out.println("用户是否已存在："+isUserNameExistent(user.getVuserName()));
			return ERROR;
		}else {
			return ERROR;
		}
	}

	//用户更改密码
	public String updatePassword(){
		if(newpasword!=null && newpaswordId!=0){
			Userinfo newpassworduser = userinfoService.getUserinfoById(newpaswordId);
			userinfoService.updatePassword(newpassworduser, newpasword);
			this.setStr_result("修改成功");
			return SUCCESS;
		}else {
			this.setStr_result("修改失败");
			return ERROR;
		}
	}
	
	//更新用户资料
	public String updateUser(){
		if(user==null){
			this.setStr_result("请重新操作");
			return INPUT;
		}
		Roleinfo role = roleinfoService.getRoleinfoById(user.getRoleinfo().getIroleId());
		user.setRoleinfo(role);
		userinfoService.updateUserinfo(user);
		Map<String,Object> map=ActionContext.getContext().getSession();
		map.remove("cur_user");
		map.put("cur_user", userinfoService.getUserinfoByUserName(user.getVuserName()).get(0));
		this.setStr_result("更新成功");
		return SUCCESS;
	}
	
	//修改用户状态和角色
	public String updateUserStateAndRole(){
		if(changeuserstate!=0 && changeuserrole!=0){
			Userinfo cuser = userinfoService.getUserinfoById(changeuserId);
			Roleinfo crole = new Roleinfo();
			crole.setIroleId(changeuserrole);
			cuser.setIvstate(changeuserstate);
			cuser.setRoleinfo(crole);
			userinfoService.updateUserinfo(cuser);
			Map<String,Object> map=ActionContext.getContext().getSession();
			map.remove("change_user");
			map.put("change_user", cuser);
			this.setStr_result("修改成功");
			return SUCCESS;
		}else{
			this.setStr_result("修改失败，用户状态必须为通过或不通过");
			return ERROR;
		}
		
		
	}
	
	//添加用户
	public String addUser(){
		if(newusername!=null && newuserpassword!=null && roleId!=0){
			if(isUserNameExistent(newusername)){
				this.setStr_result("用户名已存在");
				return INPUT;
			}
			Userinfo newuser = new Userinfo();
			Roleinfo newrole = new Roleinfo();
			newuser.setVuserName(newusername);
			newuser.setVpassward(newuserpassword);
			newuser.setIvstate(1);
			newrole.setIroleId(roleId);
			newuser.setRoleinfo(newrole);
			userinfoService.addUserinfo(newuser);
			this.setStr_result("添加成功");
			return SUCCESS;
		}else {
			this.setStr_result("添加失败");
			return ERROR;
		}
	}
	
	//修改用户
	public String changeUser(){
		if(user==null){
			this.setStr_result("请重新操作");
			return INPUT;
		}
		if(user.getIuserId()!=0){
			Userinfo change_user = userinfoService.getUserinfoById(user.getIuserId());
			Map<String,Object> map=ActionContext.getContext().getSession();
			map.remove("change_user");
			map.put("change_user", change_user);
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	//删除用户
	public String deleteUser(){
		if(user==null){
			return INPUT;
		}
		if(user.getIuserId()!=0){
			userinfoService.delUserinfo(user.getIuserId());
		}
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
	
	//用户退出
	public String exit(){
		Map<String,Object> map=ActionContext.getContext().getSession();
		map.remove("cur_user");
		map.remove("all_users");
		map.remove("cur_user_roleid");
		map.remove("change_user");
		map.remove("all_announcements");
		map.remove("search_users");
		return SUCCESS;
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
