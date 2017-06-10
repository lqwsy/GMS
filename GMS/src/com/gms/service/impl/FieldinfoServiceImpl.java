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

	@Override
	public List getFieldinfoByFieldtypeId(long fieldtypeId) {
		return fieldinfoDao.getByFieldtypeId(fieldtypeId);
	}

	//查询满足条件，仍未被租用的场地
	public List getByTypeIdWithoutFieldId(long fieldTypeId, List<Long> fieldIds) {
		return fieldinfoDao.getByTypeIdWithoutFieldId(fieldTypeId, fieldIds);
	}

	@Override
	public void saveOrUpdateFieldinfo(Fieldinfo fieldinfo) {
		fieldinfoDao.saveOrUpdateFieldinfo(fieldinfo);
	}

	@Override
	public List getFieldinfoByName(String fieldName) {
		return fieldinfoDao.getFieldinfoByName(fieldName);
	}
	
}
