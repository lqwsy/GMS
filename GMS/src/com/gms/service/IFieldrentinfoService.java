package com.gms.service;

import java.util.List;

import com.gms.po.Fieldrentinfo;

public interface IFieldrentinfoService {
	Fieldrentinfo getFieldrentinfoById(long fieldrentinfoId);
	List getAllFieldrentinfo();
	Long addFieldrentinfo(Fieldrentinfo fieldrentinfo);
	void realDeleteFieldrent(long fieldrentId);
	int delFieldrentinfo(Long fieldrentinfoId);
	void updateFieldrentinfo(Fieldrentinfo fieldrentinfo);
	List getFieldIdFromRentedDate(String rentDate); //��ȡ����ĳ�����Ѿ��������˵ĳ���id
	List getFieldIdFromRentedTime(String rentDate, String rentTime); //��ȡ����ĳ���ڡ�ʱ�䱻���õĳ���id
	List getFieldrentRecord(Integer userId);  //��ȡ��������¼
	List queryFieldrent(String rentDate,String status,String fieldId,String userName);
}
