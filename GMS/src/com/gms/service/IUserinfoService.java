package com.gms.service;

import java.util.List;

import com.gms.po.Userinfo;

public interface IUserinfoService {
	Userinfo getUserinfoById(Integer iUserId);
	Userinfo getUserinfoByUserName(String vUserName);
	List<Userinfo> getAllUserinfo();
	Integer addUserinfo(Userinfo userinfo);
	void delUserinfo(Integer iUserId);
	void verifyUserinfo(Integer iUserId);
	void updateUserinfo(Userinfo userinfo);
}
