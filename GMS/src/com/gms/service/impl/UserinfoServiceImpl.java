package com.gms.service.impl;

import java.util.List;

import com.gms.dao.IUserinfoDao;
import com.gms.po.Userinfo;
import com.gms.service.IUserinfoService;
import com.gms.util.UserinfoState;

public class UserinfoServiceImpl implements IUserinfoService{

	private IUserinfoDao userinfodao;
	
	public IUserinfoDao getUserinfodao() {
		return userinfodao;
	}

	public void setUserinfodao(IUserinfoDao userinfodao) {
		this.userinfodao = userinfodao;
	}
	
	@Override
	public Userinfo getUserinfoById(Integer iUserId) {
		return userinfodao.get(iUserId);
	}

	@Override
	public Integer addUserinfo(Userinfo userinfo) {
		userinfo.setIvstate(UserinfoState.TO_VERIFY);
		return userinfodao.save(userinfo);
	}

	@Override
	public void delUserinfo(Integer iUserId) {
		Userinfo userinfo = userinfodao.get(iUserId);
		userinfodao.delete(userinfo);
	}

	@Override
	public void verifyUserinfo(Integer iUserId) {
		Userinfo userinfo = userinfodao.get(iUserId);
		userinfo.setIvstate(UserinfoState.VERIFY);
		userinfodao.update(userinfo);
	}

	@Override
	public void updateUserinfo(Userinfo userinfo) {
		userinfodao.update(userinfo);
	}

	@Override
	public List<Userinfo> getAllUserinfo() {
		return userinfodao.findAllUser();
	}

}
