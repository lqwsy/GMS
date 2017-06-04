package com.gms.dao;

import java.util.List;

import com.gms.po.Fieldrentinfo;

public interface IFieldrentinfoDao {
	Long save(Fieldrentinfo fieldrentinfo);
	void delete(long fieldrentId);
	void update(Fieldrentinfo fieldrentinfo);
	Fieldrentinfo get(long id);
	List getAll();
	List getFieldIdFromRentedDate(String rentDate); //获取，在某日期已经被租用了的场地id
	List getFieldIdFromRentedTime(String rentDate, String rentTime); //获取，在某日期、时间被租用的场地id
	List getFieldrentRecord(Integer userId);
	int setStatusFalseById(Long fieldrentiId);
	List queryFieldrent(String rentDate,String status,String fieldId,String userName);
}
