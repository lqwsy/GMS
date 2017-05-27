package com.gms.service.impl;

import java.util.List;

import com.gms.dao.IFieldrentinfoDao;
import com.gms.po.Fieldrentinfo;
import com.gms.service.IFieldrentinfoService;

public class FieldrentinfoServiceImpl implements IFieldrentinfoService {

	private Fieldrentinfo fieldrentinfo;
	private IFieldrentinfoDao fieldrentinfoDao;
	
	public void setFieldrentinfoDao(IFieldrentinfoDao fieldrentinfoDao) {
		this.fieldrentinfoDao = fieldrentinfoDao;
	}

	@Override
	public Fieldrentinfo getFieldrentinfoById(long fieldrentinfoId) {
		return fieldrentinfoDao.get(fieldrentinfoId);
	}

	@Override
	public List getAllFieldrentinfo() {
		return fieldrentinfoDao.getAll();
	}

	@Override
	public Long addFieldrentinfo(Fieldrentinfo fieldrentinfo) {
		return fieldrentinfoDao.save(fieldrentinfo);
	}

	@Override
	public void delFieldrentinfo(Long fieldrentinfoId) {
		fieldrentinfo = fieldrentinfoDao.get(fieldrentinfoId);
		fieldrentinfoDao.delete(fieldrentinfo);
	}

	@Override
	public void updateFieldrentinfo(Fieldrentinfo fieldrentinfo) {
		fieldrentinfoDao.update(fieldrentinfo);
	}

}
