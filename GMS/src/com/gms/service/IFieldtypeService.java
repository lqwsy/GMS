package com.gms.service;

import java.util.List;
import com.gms.po.Fieldtype;

public interface IFieldtypeService {
	List getAllFieldtype();
	Long addFieldtype(Fieldtype fieldtype);
	void delFieldtype(Long fieldtypeId);
	void updateFieldtype(Fieldtype fieldtype);
}
