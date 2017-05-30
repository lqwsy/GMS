package com.gms.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gms.po.Fieldinfo;
import com.gms.po.Fieldtype;
import com.gms.service.IFieldinfoService;
import com.gms.service.IFieldtypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FieldinfoAction extends ActionSupport {
	private Fieldinfo fieldinfo;

	private IFieldinfoService fieldinfoService;
	private IFieldtypeService fieldtypeService;
	
	private String display;
	private String fieldtypeId;
	private String rentDate;
	private String rentTime;
	
	public Fieldinfo getFieldinfo() {
		return fieldinfo;
	}

	public void setFieldinfo(Fieldinfo fieldinfo) {
		this.fieldinfo = fieldinfo;
	}

	public void setFieldinfoService(IFieldinfoService fieldinfoService) {
		this.fieldinfoService = fieldinfoService;
	}

	public void setFieldtypeService(IFieldtypeService fieldtypeService) {
		this.fieldtypeService = fieldtypeService;
	}
	
	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}
	
	public String getFieldtypeId() {
		return fieldtypeId;
	}

	public void setFieldtypeId(String fieldtypeId) {
		this.fieldtypeId = fieldtypeId;
	}
	
	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public String getRentTime() {
		return rentTime;
	}

	public void setRentTime(String rentTime) {
		this.rentTime = rentTime;
	}

	public String addFieldinfo() {
		long result = fieldinfoService.addFieldinfo(fieldinfo);
		if(result == 0) {
			return "error";
		}else {
			System.out.println(fieldinfo);
			return "add";
		}
	}
	
	public String queryFieldinfo() {
		if("all".equals(display)) {  //È«²¿ÏÔÊ¾
			List<Fieldinfo> fieldinfos = fieldinfoService.getFieldinfoByFieldtypeId(Long.parseLong(fieldtypeId));
			ActionContext actionContext = ActionContext.getContext();
			Map<String,Object> request = (Map<String,Object>)actionContext.get("request");
			request.put("fieldinfos", fieldinfos) ;
			return "query-success";
		}else if("enable".equals(display)) {
			return "error";
		}
		return "error";
	}
	
	public String query() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)actionContext.get("request");
		request.put("fieldtypes", fieldtypeService.getAllFieldtype()) ;
		return "query";
	}
	
	public String input() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)actionContext.get("request");
		List<Fieldtype> fieldtypes = fieldtypeService.getAllFieldtype();
		request.put("fieldtypes", fieldtypes);
		return "input";
	}

}
