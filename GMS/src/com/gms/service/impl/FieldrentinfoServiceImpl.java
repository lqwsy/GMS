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
	public int delFieldrentinfo(Long fieldrentinfoId) {
		return fieldrentinfoDao.setStatusFalseById(fieldrentinfoId);
	}

	@Override
	public void updateFieldrentinfo(Fieldrentinfo fieldrentinfo) {
		fieldrentinfoDao.update(fieldrentinfo);
	}

	//获取，在某日期已经被租用了的场地id
	public List getFieldIdFromRentedDate(String rentDate) {
		return fieldrentinfoDao.getFieldIdFromRentedDate(rentDate);
	}
		
	//获取，在某日期、时间被租用的场地id
	public List getFieldIdFromRentedTime(String rentDate, String rentTime) {
		return fieldrentinfoDao.getFieldIdFromRentedTime(rentDate, rentTime);
	}

	//获取当前用户的7天前往后的租用记录
	@Override
	public List getFieldrentRecord(Integer userId) {
		return fieldrentinfoDao.getFieldrentRecord(userId);
	}

	@Override
	public List queryFieldrent(String rentDate, String status, String fieldId, String userName) {
		return fieldrentinfoDao.queryFieldrent(rentDate, status, fieldId, userName);
	}

	@Override
	public void realDeleteFieldrent(long fieldrentId) {
		fieldrentinfoDao.delete(fieldrentId);
	}
	
}
