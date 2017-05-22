package com.gms.service;

import java.util.List;

import com.gms.po.Roleinfo;

public interface IRoleinfoService {
	Roleinfo getRoleinfoById(Integer iRoleId);
	List<Roleinfo> getAllRoleinfo();
}
