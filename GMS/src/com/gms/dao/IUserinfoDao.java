package com.gms.dao;

import java.util.List;

import com.gms.po.Userinfo;

public interface IUserinfoDao {
	public Integer save(Userinfo userinfo);
	public void delete(Userinfo userinfo);
	public void update(Userinfo userinfo);
	public List<Userinfo> findAllUser();
	public List<Userinfo> findByName(String vRealName);
	Userinfo get(Integer iUserId);
}
