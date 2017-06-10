package com.gms.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gms.po.Fieldinfo;
import com.gms.po.Fieldrentinfo;
import com.gms.po.Userinfo;
import com.gms.service.IFieldinfoService;
import com.gms.service.IFieldrentinfoService;
import com.gms.service.IFieldtypeService;
import com.gms.util.DateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class FieldrentAction extends ActionSupport {

	private IFieldrentinfoService fieldrentinfoService;
	private IFieldtypeService fieldtypeService;
	private IFieldinfoService fieldinfoService;
	
	private Fieldrentinfo fieldrentinfo;
	private InputStream inputStream;
	
	private List<Fieldinfo> jsonResult;
	
	private String rentDate;
	private String fieldrentId;
	
	private String rentYear;
	private String rentMonth;
	private String rentDay;
	private String status;
	private String fieldId;
	private String fieldtypeId;
	private String userName;
	
	public Fieldrentinfo getFieldrentinfo() {
		return fieldrentinfo;
	}

	public void setFieldrentinfo(Fieldrentinfo fieldrentinfo) {
		this.fieldrentinfo = fieldrentinfo;
	}

	public void setFieldrentinfoService(IFieldrentinfoService fieldrentinfoService) {
		this.fieldrentinfoService = fieldrentinfoService;
	}

	public void setFieldtypeService(IFieldtypeService fieldtypeService) {
		this.fieldtypeService = fieldtypeService;
	}
	
	public void setFieldinfoService(IFieldinfoService fieldinfoService) {
		this.fieldinfoService = fieldinfoService;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	
	public String getFieldrentId() {
		return fieldrentId;
	}

	public void setFieldrentId(String fieldrentId) {
		this.fieldrentId = fieldrentId;
	}

	public void setRentYear(String rentYear) {
		this.rentYear = rentYear;
	}

	public void setRentMonth(String rentMonth) {
		this.rentMonth = rentMonth;
	}

	public void setRentDay(String rentDay) {
		this.rentDay = rentDay;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public void setFieldtypeId(String fieldtypeId) {
		this.fieldtypeId = fieldtypeId;
	}

	public List<Fieldinfo> getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(List<Fieldinfo> jsonResult) {
		this.jsonResult = jsonResult;
	}

	public String query() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		Map<String, Object> request = (Map<String,Object>)actionContext.get("request");
		Userinfo userinfo = (Userinfo)session.get("cur_user");
		Integer userId = userinfo.getIuserId();
		if(userId != null) {
			List<Fieldrentinfo> fieldrentinfos =fieldrentinfoService.getFieldrentRecord(userId);
			/*Iterator<Fieldrentinfo> it = fieldrentinfos.iterator();
			System.out.println(it.next().getFieldinfo());*/
			request.put("fieldrentinfos", fieldrentinfos);
			return "query";
		}
		return "error";
	}
	
	public String add() {
		try {
			fieldrentinfo.setStatus(true);
			fieldrentinfo.setRentDate(DateUtil.getDateFromString(rentDate));
			long result = fieldrentinfoService.addFieldrentinfo(fieldrentinfo);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			if(result == 0) {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return "ajax";
	}
	
	public String delete() {
		try {
			int result = fieldrentinfoService.delFieldrentinfo(Long.parseLong(fieldrentId));
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			if (result == 0) {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "ajax";
	}
	
	public String realDelete() {
		try {
			fieldrentinfoService.realDeleteFieldrent(Long.parseLong(fieldrentId));
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return "ajax";
	}

	//查询场地租用记录前的处理方法
	public String lookup() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)actionContext.get("request");
		request.put("fieldtypes", fieldtypeService.getAllFieldtype()) ;
		return "lookup";
	}
	
	public String queryFieldrent() {
		String rentDate = rentYear + "-" + rentMonth + "-" + rentDay;
		List<Fieldrentinfo> fieldrents = fieldrentinfoService.queryFieldrent(rentDate, status, fieldId, userName);
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)actionContext.get("request");
		request.put("fieldrents", fieldrents) ;
		return "rent-query-success";
	}

	//通过ajax-json，实现二级联动
	public String ejldAjax() {
		jsonResult =  fieldinfoService.getFieldinfoByFieldtypeId(Long.parseLong(fieldtypeId));
		return SUCCESS;
	}
	
}
