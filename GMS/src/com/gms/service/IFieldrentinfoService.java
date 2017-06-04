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
	List getFieldIdFromRentedDate(String rentDate); //获取，在某日期已经被租用了的场地id
	List getFieldIdFromRentedTime(String rentDate, String rentTime); //获取，在某日期、时间被租用的场地id
	List getFieldrentRecord(Integer userId);  //获取场地租借记录
	List queryFieldrent(String rentDate,String status,String fieldId,String userName);
}
