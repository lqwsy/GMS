package com.gms.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gms.po.Fieldinfo;
import com.gms.po.Fieldtype;
import com.gms.service.IFieldinfoService;
import com.gms.service.IFieldrentinfoService;
import com.gms.service.IFieldtypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FieldinfoAction extends ActionSupport {
	private Fieldinfo fieldinfo;

	private IFieldinfoService fieldinfoService;
	private IFieldtypeService fieldtypeService;
	private IFieldrentinfoService fieldrentinfoService;
	
	private String fieldId;
	private String display;
	private String fieldtypeId;
	private String rentDate;
	private String rentTime;
	
	private InputStream inputStream;
	
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
	
	public void setFieldrentinfoService(IFieldrentinfoService fieldrentinfoService) {
		this.fieldrentinfoService = fieldrentinfoService;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
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
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public String addFieldinfo() {
		String fieldName = fieldinfo.getFieldName();
		int num = fieldinfoService.getFieldinfoByName(fieldName).size();
		if(num != 0) {
			ActionContext actionContext = ActionContext.getContext();
			Map<String,Object> request = (Map<String,Object>)actionContext.get("request");
			request.put("repeat", true);
			return "to-input";
		}
		long id = fieldinfo.getFieldId();
		fieldinfoService.saveOrUpdateFieldinfo(fieldinfo);
		if(id != 0) { //如果是修改操作
			return "query-to";
		}else {
			return "no-to-input";
		}
	}
	
	public String queryFieldinfo() {
		long typeId = Long.parseLong(fieldtypeId);
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)actionContext.get("request");
		if("all".equals(display)) {  //全部显示
			List<Fieldinfo> fieldinfos = fieldinfoService.getFieldinfoByFieldtypeId(typeId);
			request.put("fieldinfos", fieldinfos);
			return "query-success";
		}else if("enable".equals(display)) {
			List<Long> fieldIds = null; 
			if("一整天".equals(rentTime)) {
				fieldIds = fieldrentinfoService.getFieldIdFromRentedDate(rentDate);
				System.out.println(fieldIds.size());
			}else {
				fieldIds = fieldrentinfoService.getFieldIdFromRentedTime(rentDate,rentTime);
			}
			List<Fieldinfo> fieldinfos = fieldinfoService.getByTypeIdWithoutFieldId(typeId, fieldIds);
			request.put("fieldinfos", fieldinfos);
			return "query-success";
		}
		return "error";
	}
	
	public String query() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)actionContext.get("request");
		request.put("fieldtypes", fieldtypeService.getAllFieldtype());
		return "query";
	}
	
	public String input() {
		if(fieldId != null) {
			fieldinfo = fieldinfoService.getFieldinfoById(Long.parseLong(fieldId));
		}
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)actionContext.get("request");
		request.put("fieldtypes", fieldtypeService.getAllFieldtype());
		return "input";
	}

	public String delete() {
		if(fieldId != null) {
			try {
				fieldinfoService.delFieldinfo(Long.parseLong(fieldId));
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
}
