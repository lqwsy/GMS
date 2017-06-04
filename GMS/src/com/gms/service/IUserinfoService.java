package com.gms.service;

import java.util.List;

import com.gms.po.Userinfo;

public interface IUserinfoService {
	Userinfo getUserinfoById(Integer iUserId);
	List getUserinfoByUserName(String vUserName);
	List getUserinfoByName(String vRealName);
	List getAllUserinfo();
	Integer addUserinfo(Userinfo userinfo);
	void delUserinfo(Integer iUserId);
	void verifyUserinfo(Integer iUserId);
	void updateUserinfo(Userinfo userinfo);
	void updatePassword(Userinfo userinfo,String newPassword);
}
