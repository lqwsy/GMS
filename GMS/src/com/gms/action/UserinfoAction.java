package com.gms.action;

import java.sql.SQLException;

import com.gms.po.Userinfo;
import com.gms.service.impl.UserinfoServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserinfoAction extends ActionSupport{

	private String vUserName;
	private String vPassword;
	private Userinfo user;
	private UserinfoServiceImpl userservice;
	
	public String getvUserName() {
		return vUserName;
	}
	public void setvUserName(String vUserName) {
		this.vUserName = vUserName;
	}
	public String getvPassword() {
		return vPassword;
	}
	public void setvPassword(String vPassword) {
		this.vPassword = vPassword;
	}
	public Userinfo getUser() {
		return user;
	}
	public void setUser(Userinfo user) {
		this.user = user;
	}
	public UserinfoServiceImpl getUserservice() {
		return userservice;
	}
	public void setUserservice(UserinfoServiceImpl userservice) {
		this.userservice = userservice;
	}

/*	//用户登录
	public String login(){
		if(this.user==null){
			return INPUT;
		}
		String password = userservice.getUserByUserName(user.getVuserName()).getVpassward();
		if(user.getVpassward().equals(password)){
			return SUCCESS;
		}else{
			return ERROR;
		}
		return ERROR;
	}
	
	//用户注册
	public String regist(){
		if(this.user==null){
			return INPUT;
		}
		if(isUserNameExistent(user.getVuserName())){
			userservice.addUserinfo(user);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	//用户名是否已存在
	public boolean isUserNameExistent(String vUserName){
		if(userservice.getUserByUserName(vUserName)==null){
			return false;
		}else{
			return true;
		}
	}*/
}
