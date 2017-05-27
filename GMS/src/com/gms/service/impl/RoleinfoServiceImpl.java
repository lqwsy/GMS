package com.gms.service.impl;

import java.util.List;

import com.gms.dao.IRoleinfoDao;
import com.gms.po.Roleinfo;
import com.gms.service.IRoleinfoService;

public class RoleinfoServiceImpl implements IRoleinfoService{

	private IRoleinfoDao roleinfodao;

	public IRoleinfoDao getRoleinfodao() {
		return roleinfodao;
	}

	public void setRoleinfodao(IRoleinfoDao roleinfodao) {
		this.roleinfodao = roleinfodao;
	}

	@Override
	public Roleinfo getRoleinfoById(Integer iRoleId) {
		return roleinfodao.get(iRoleId);
	}

	@Override
	public List<Roleinfo> getAllRoleinfo() {
		return roleinfodao.findAllRole();
	}
	
}
