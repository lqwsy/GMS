package com.gms.service.impl;

import java.util.List;

import com.gms.dao.IRoleinfoDao;
import com.gms.po.Roleinfo;
import com.gms.service.IRoleinfoService;

public class RoleinfoServiceImpl implements IRoleinfoService{

	private IRoleinfoDao roledao;
	
	public IRoleinfoDao getRoledao() {
		return roledao;
	}

	public void setRoledao(IRoleinfoDao roledao) {
		this.roledao = roledao;
	}

	@Override
	public Roleinfo getRoleinfoById(Integer iRoleId) {
		return roledao.get(iRoleId);
	}

	@Override
	public List<Roleinfo> getAllRoleinfo() {
		return roledao.findAllRole();
	}
	
}
