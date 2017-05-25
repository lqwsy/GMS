package com.gms.service.impl;

import com.gms.dao.ISpacesUseDao;
import com.gms.po.Spacesuse;
import com.gms.service.ISpacesUseService;

public class SpacesUseServiceImpl implements ISpacesUseService{
	private ISpacesUseDao spacesUseDao;
	
	public void setSpacesUseDao(ISpacesUseDao spacesUseDao) {
		this.spacesUseDao = spacesUseDao;
	}
	@Override
	public Spacesuse getSpacesUseById(Long id) {
		// TODO Auto-generated method stub
		return spacesUseDao.get(id);
	}
	
}
