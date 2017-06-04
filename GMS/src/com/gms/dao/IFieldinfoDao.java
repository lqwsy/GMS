package com.gms.dao;

import java.util.List;

import com.gms.po.Fieldinfo;

public interface IFieldinfoDao {
	Long save(Fieldinfo fieldinfo);
	void delete(Fieldinfo fieldinfo);
	void update(Fieldinfo fieldinfo);
	Fieldinfo get(long id);
	List getByFieldtypeId(long fieldtypeId);
	List getAll();
	List getByTypeIdWithoutFieldId(long fieldTypeId, List<Long> fieldIds);
	void saveOrUpdateFieldinfo(Fieldinfo fieldinfo);
	List getFieldinfoByName(String fieldName);
}
