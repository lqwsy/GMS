package com.gms.service.impl;

import java.util.List;

import com.gms.dao.IFieldinfoDao;
import com.gms.po.Fieldinfo;
import com.gms.service.IFieldinfoService;

public class FieldinfoServiceImpl implements IFieldinfoService {

	private Fieldinfo fieldinfo = null;
	private IFieldinfoDao fieldinfoDao;
	
	public void setFieldinfoDao(IFieldinfoDao fieldinfoDao) {
		this.fieldinfoDao = fieldinfoDao;
	}

	@Override
	public Fieldinfo getFieldinfoById(long fieldinfoId) {
		return fieldinfoDao.get(fieldinfoId);
	}

	@Override
	public List getAllFieldinfo() {
		return fieldinfoDao.getAll();
	}

	@Override
	public Long addFieldinfo(Fieldinfo fieldinfo) {
		return fieldinfoDao.save(fieldinfo);
	}

	@Override
	public void delFieldinfo(Long fieldinfoId) {
		fieldinfo = fieldinfoDao.get(fieldinfoId);
		fieldinfoDao.delete(fieldinfo);
	}

	@Override
	public void updateFieldinfo(Fieldinfo fieldinfo) {
		fieldinfoDao.update(fieldinfo);
	}

}
