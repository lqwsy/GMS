package com.gms.service.impl;

import java.util.List;

import com.gms.dao.IFieldtypeDao;
import com.gms.po.Fieldinfo;
import com.gms.po.Fieldtype;
import com.gms.service.IFieldtypeService;

public class FieldtypeServiceImpl implements IFieldtypeService {

	private IFieldtypeDao fieldtypeDao;
	
	public void setFieldtypeDao(IFieldtypeDao fieldtypeDao) {
		this.fieldtypeDao = fieldtypeDao;
	}

	@Override
	public List getAllFieldtype() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long addFieldtype(Fieldtype fieldtype) {
		return fieldtypeDao.save(fieldtype);
	}

	@Override
	public void delFieldtype(Long fieldtypeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFieldtype(Fieldtype fieldtype) {
		// TODO Auto-generated method stub
		
	}

	

}
