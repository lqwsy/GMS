package com.gms.action;

import com.gms.po.Fieldinfo;
import com.gms.po.Fieldtype;
import com.gms.service.IFieldtypeService;
import com.gms.service.impl.FieldinfoServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class FieldtypeAction extends ActionSupport {
	private Fieldtype fieldtype;

	private IFieldtypeService fieldtypeService;

	public Fieldtype getFieldtype() {
		return fieldtype;
	}

	public void setFieldtype(Fieldtype fieldtype) {
		this.fieldtype = fieldtype;
	}

	public void setFieldtypeService(IFieldtypeService fieldtypeService) {
		this.fieldtypeService = fieldtypeService;
	}

	public String addFieldtype() {
		System.out.println(fieldtype);
		fieldtypeService.addFieldtype(fieldtype);
		return "json";
	}
	
	public String listFieldtype() {
		fieldtypeService.getAllFieldtype();
		return SUCCESS;
	}
}
