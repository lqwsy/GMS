package com.gms.action;

import com.gms.po.Fieldinfo;
import com.gms.service.impl.FieldinfoServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class FieldinfoAction extends ActionSupport {
	private Fieldinfo fieldInfo;

	private FieldinfoServiceImpl fieldinfoService;
	
	public Fieldinfo getFieldInfo() {
		return fieldInfo;
	}

	public void setFieldInfo(Fieldinfo fieldInfo) {
		this.fieldInfo = fieldInfo;
	}
	
	public void setFieldinfoService(FieldinfoServiceImpl fieldinfoService) {
		this.fieldinfoService = fieldinfoService;
	}
	
	public String getAllField() {
		return SUCCESS;
	}
}
