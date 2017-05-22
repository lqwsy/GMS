package com.gms.dao;

import java.util.List;

import com.gms.po.Userinfo;

public interface IUserinfo {
	public Integer save(Userinfo userinfo);
	public void delete(Userinfo userinfo);
	public void update(Userinfo userinfo);
	public List<Userinfo> findAllUser();
	Userinfo get(Integer iUserId);
}
