package com.gms.action;

import com.gms.po.Fieldrentinfo;
import com.gms.service.IFieldrentinfoService;
import com.opensymphony.xwork2.ActionSupport;

public class FieldrentAction extends ActionSupport{
	
	IFieldrentinfoService fieldrentinfoService;
	
	Fieldrentinfo fieldrentinfo;

	public Fieldrentinfo getFieldrentinfo() {
		return fieldrentinfo;
	}

	public void setFieldrentinfo(Fieldrentinfo fieldrentinfo) {
		this.fieldrentinfo = fieldrentinfo;
	}

	public void setFieldrentinfoService(IFieldrentinfoService fieldrentinfoService) {
		this.fieldrentinfoService = fieldrentinfoService;
	}
	
	public String request() {
		
		return "request";
	}
	
	
}
