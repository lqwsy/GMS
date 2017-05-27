package com.gms.service;

import java.util.List;

import com.gms.po.Fieldrentinfo;

public interface IFieldrentinfoService {
	Fieldrentinfo getFieldrentinfoById(long fieldrentinfoId);
	List getAllFieldrentinfo();
	Long addFieldrentinfo(Fieldrentinfo fieldrentinfo);
	void delFieldrentinfo(Long fieldrentinfoId);
	void updateFieldrentinfo(Fieldrentinfo fieldrentinfo);
}
