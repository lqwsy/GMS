package com.gms.service.impl;

import com.gms.dao.IEquitmentsUseDao;
import com.gms.po.Equitmentsuse;
import com.gms.service.IEquitmentsUseService;

public class EquitmentsUseServiceImpl implements IEquitmentsUseService{
	private IEquitmentsUseDao equitmentsUseDao;

	public void setEquitmentsUseDao(IEquitmentsUseDao equitmentsUseDao) {
		this.equitmentsUseDao = equitmentsUseDao;
	}
	@Override
	public Equitmentsuse getEquitmentsUseById(Long id) {
		// TODO Auto-generated method stub
		return equitmentsUseDao.get(id);
	}

}
