package com.gms.service;

import java.util.List;

import com.gms.po.Fieldinfo;

public interface IFieldinfoService {
	Fieldinfo getFieldinfoById(long fieldinfoId);
	List getAllFieldinfo();
	Long addFieldinfo(Fieldinfo fieldinfo);
	void delFieldinfo(Long fieldinfoId);
	void updateFieldinfo(Fieldinfo fieldinfo);
	List getFieldinfoByFieldtypeId(long fieldtypeId);
	List getByTypeIdWithoutFieldId(long fieldTypeId, List<Long> fieldIds);
	void saveOrUpdateFieldinfo(Fieldinfo fieldinfo);
	List getFieldinfoByName(String fieldName);
}
