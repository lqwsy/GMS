package com.gms.dao;

import java.util.List;

import com.gms.po.Userinfo;

public interface IUserinfoDao {
	public Integer save(Userinfo userinfo);
	public void delete(Userinfo userinfo);
	public void update(Userinfo userinfo);
	public List findAllUser();
	public List findByName(String vRealName);
	public List findUserByUserName(String vUserName);
	Userinfo get(Integer iUserId);
}
