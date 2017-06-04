package com.gms.dao;

import java.util.List;

import com.gms.po.Fieldrentinfo;

public interface IFieldrentinfoDao {
	Long save(Fieldrentinfo fieldrentinfo);
	void delete(long fieldrentId);
	void update(Fieldrentinfo fieldrentinfo);
	Fieldrentinfo get(long id);
	List getAll();
	List getFieldIdFromRentedDate(String rentDate); //��ȡ����ĳ�����Ѿ��������˵ĳ���id
	List getFieldIdFromRentedTime(String rentDate, String rentTime); //��ȡ����ĳ���ڡ�ʱ�䱻���õĳ���id
	List getFieldrentRecord(Integer userId);
	int setStatusFalseById(Long fieldrentiId);
	List queryFieldrent(String rentDate,String status,String fieldId,String userName);
}
