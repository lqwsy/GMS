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

	//��ȡ����ĳ�����Ѿ��������˵ĳ���id
	public List getFieldIdFromRentedDate(String rentDate) {
		return fieldrentinfoDao.getFieldIdFromRentedDate(rentDate);
	}
		
	//��ȡ����ĳ���ڡ�ʱ�䱻���õĳ���id
	public List getFieldIdFromRentedTime(String rentDate, String rentTime) {
		return fieldrentinfoDao.getFieldIdFromRentedTime(rentDate, rentTime);
	}

	//��ȡ��ǰ�û���7��ǰ��������ü�¼
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
