package com.gms.dao;

import java.util.List;

import com.gms.po.Fieldtype;

public interface IFieldtypeDao {
	long save(Fieldtype fieldtype);
	void delete(Fieldtype fieldtype);
	void update(Fieldtype fieldtype);
	Fieldtype get(long id);
	List getAll();
}
