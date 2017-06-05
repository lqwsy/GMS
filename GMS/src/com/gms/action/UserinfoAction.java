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

	// �û���¼
	public String login() {
		if (this.user == null) {
			return INPUT;
		}
		if(userinfoService == null){
			return ERROR;
		}
		List<Userinfo> loginuser = userinfoService.getUserinfoByUserName(user.getVuserName());
		if(loginuser.isEmpty()){
			this.setStr_result("�û�������");
			return ERROR;
		}
		if (user.getVpassward().equals(loginuser.get(0).getVpassward())) {
			Map<String,Object> map=ActionContext.getContext().getSession();
			map.put("cur_user", loginuser.get(0));//��session�����¼��ʶID,�Թ���¼�����ʹ��
			map.put("cur_user_roleid", Integer.toString(loginuser.get(0).getRoleinfo().getIroleId()));//��session�����¼��ʶID,�Թ���¼�����ʹ��
			return SUCCESS;
		} else {
			this.setStr_result("�û��������벻ƥ��");
		}
		return ERROR;
	}

	// �û�ע��
	public String regist() {
		if (this.user == null) {
			return INPUT;
		}
		if (!isUserNameExistent(user.getVuserName())) {
			Roleinfo role = new Roleinfo();
			role.setIroleId(5);
			user.setRoleinfo(role);
			userinfoService.addUserinfo(user);
			this.setRegist_result("ע��ɹ�,�����µ�¼");
			return SUCCESS;
		} else if(isUserNameExistent(user.getVuserName())){
			this.setRegist_result("ע��ʧ��,�û����Ѵ���");
			System.out.println("�û��Ƿ��Ѵ��ڣ�"+isUserNameExistent(user.getVuserName()));
			return ERROR;
		}else {
			return ERROR;
		}
	}

	//�û���������
	public String updatePassword(){
		if(newpasword!=null && newpaswordId!=0){
			Userinfo newpassworduser = userinfoService.getUserinfoById(newpaswordId);
			userinfoService.updatePassword(newpassworduser, newpasword);
			this.setStr_result("�޸ĳɹ�");
			return SUCCESS;
		}else {
			this.setStr_result("�޸�ʧ��");
			return ERROR;
		}
	}
	
	//�����û�����
	public String updateUser(){
		if(user==null){
			this.setStr_result("�����²���");
			return INPUT;
		}
		Roleinfo role = roleinfoService.getRoleinfoById(user.getRoleinfo().getIroleId());
		user.setRoleinfo(role);
		userinfoService.updateUserinfo(user);
		Map<String,Object> map=ActionContext.getContext().getSession();
		map.remove("cur_user");
		map.put("cur_user", userinfoService.getUserinfoByUserName(user.getVuserName()).get(0));
		this.setStr_result("���³ɹ�");
		return SUCCESS;
	}
	
	//�޸��û�״̬�ͽ�ɫ
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
			this.setStr_result("�޸ĳɹ�");
			return SUCCESS;
		}else{
			this.setStr_result("�޸�ʧ�ܣ��û�״̬����Ϊͨ����ͨ��");
			return ERROR;
		}
		
		
	}
	
	//����û�
	public String addUser(){
		if(newusername!=null && newuserpassword!=null && roleId!=0){
			if(isUserNameExistent(newusername)){
				this.setStr_result("�û����Ѵ���");
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
			this.setStr_result("��ӳɹ�");
			return SUCCESS;
		}else {
			this.setStr_result("���ʧ��");
			return ERROR;
		}
	}
	
	//�޸��û�
	public String changeUser(){
		if(user==null){
			this.setStr_result("�����²���");
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
	
	//ɾ���û�
	public String deleteUser(){
		if(user==null){
			return INPUT;
		}
		if(user.getIuserId()!=0){
			userinfoService.delUserinfo(user.getIuserId());
		}
		return SUCCESS;
	}
	
	//�����û�
	public String searchUser(){
		if(searchname==null){
			List<Userinfo> allusers = userinfoService.getAllUserinfo();
			System.out.println("all "+allusers.size()+" users");
			Map<String,Object> map=ActionContext.getContext().getSession();
			map.remove("search_users");
			map.remove("all_users");
			map.put("all_users", allusers);//��session���������û��Ķ���
			return SUCCESS;
		}else {
			List<Userinfo> searchusers = userinfoService.getUserinfoByName(searchname);
			System.out.println("searchname is:  "+searchname);
			System.out.println("search "+searchusers.size()+" user");
			Map<String,Object> map=ActionContext.getContext().getSession();
			map.remove("search_users");
			map.remove("all_users");
			map.put("search_users", searchusers);//��session�������������ѯ�������û��Ķ���
			return SUCCESS;
		}
	}
	
	//�û��˳�
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
	


	// �û����Ƿ��Ѵ���
	public boolean isUserNameExistent(String vusername) {
		if (userinfoService.getUserinfoByUserName(vusername).isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
