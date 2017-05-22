package com.gms.dao;

import java.util.List;

import com.gms.po.Roleinfo;

public interface IRoleinfoDao {
//	public Integer save(Roleinfo roleinfo);
//	public void update(Roleinfo roleinfo);
//	public void delete(Roleinfo roleinfo);
	Roleinfo get(Integer iRoleId);
	public List<Roleinfo> findAllRole();
}
