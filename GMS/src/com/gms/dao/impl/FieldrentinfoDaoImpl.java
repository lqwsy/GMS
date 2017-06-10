package com.gms.dao.impl;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gms.dao.IFieldrentinfoDao;
import com.gms.dao.IUserinfoDao;
import com.gms.po.Fieldrentinfo;
import com.gms.po.Userinfo;
import com.gms.util.DateUtil;
import com.sun.jmx.snmp.Timestamp;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class FieldrentinfoDaoImpl extends HibernateDaoSupport implements IFieldrentinfoDao  {

	private IUserinfoDao userinfoDao;
	
	public void setUserinfoDao(IUserinfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
	}

	@Override
	public Long save(Fieldrentinfo fieldrentinfo) {
		return (long)getHibernateTemplate().save(fieldrentinfo);
	}

	@Override
	public void delete(long fieldrentId) {
		Fieldrentinfo fieldrentinfo = this.get(fieldrentId);
		getHibernateTemplate().delete(fieldrentinfo);
	}

	@Override
	public void update(Fieldrentinfo fieldrentinfo) {
		getHibernateTemplate().update(fieldrentinfo);
	}

	@Override
	public Fieldrentinfo get(long id) {
		return getHibernateTemplate().get(Fieldrentinfo.class, id);
	}

	@Override
	public List getAll() {
		return getHibernateTemplate().find("from Fieldrentinfo"); 
	}
	
	//获取，在某日期已经被租用了的场地id
	public List getFieldIdFromRentedDate(String rentDate) {
		Date date = DateUtil.getDateFromString(rentDate);
		String rd = DateUtil.getStringFromDate(date);
		return getHibernateTemplate().find("select fr.fieldinfo.fieldId from Fieldrentinfo fr "
				+ "where fr.status = true and fr.rentDate = '" + rd + "'");
	}
	
	//获取，在某日期、时间被租用的场地id
	public List getFieldIdFromRentedTime(String rentDate, String rentTime) {
		Date date = DateUtil.getDateFromString(rentDate);
		String rd = DateUtil.getStringFromDate(date);
		return getHibernateTemplate().find("select fr.fieldinfo.fieldId from Fieldrentinfo fr "
				+ "where fr.status = true and fr.rentDate = '" + rd + "' AND (fr.rentTime LIKE '" + rentTime + "' OR fr.rentTime LIKE '一整天')");
	}

	@Override
	public List getFieldrentRecord(Integer userId) {
		String date = DateUtil.getSpecifiedDayBefore(new Date(), 30);
		String beforeDate = DateUtil.getStringFromDate(DateUtil.getDateFromString(date));
		return getHibernateTemplate().find("from Fieldrentinfo fr LEFT OUTER JOIN FETCH fr.fieldinfo"
				+ " where fr.status = true and fr.userinfo.iuserId = " + userId + " and fr.rentDate > '" + beforeDate + "'");
	}
	
	public int setStatusFalseById(Long fieldrentiId) {
		return getHibernateTemplate().bulkUpdate("UPDATE Fieldrentinfo fr SET fr.status=false "
				+ "where fr.fieldrentId = "+fieldrentiId);
	}
	
	public List queryFieldrent(String rentDate,String status,String fieldId,String userName) {
		Date date = DateUtil.setHms0(new Date());
		String sDate = DateUtil.getStringFromDate(date);
		String statusHQL = "";
		StringBuffer sb = new StringBuffer("from Fieldrentinfo fr LEFT OUTER JOIN FETCH fr.fieldinfo LEFT OUTER JOIN FETCH fr.userinfo where ");
		if("true".equals(status)) {
			statusHQL = "(fr.status = true AND fr.rentDate >= '" + sDate + "')";
		}else if("false".equals(status)) {
			statusHQL = "(fr.status = false OR fr.rentDate < '" + sDate + "')";
		}
		if(!("--".equals(rentDate))) {
			rentDate += " 00:00:00";
			sb.append("fr.rentDate = '" + rentDate + "' and ");
		}
		if(!("".equals(fieldId))) {
			sb.append("fr.fieldinfo.fieldId = " + fieldId + " and ");
		}
		if(!("".equals(userName))) {
			String userId = "null";
			List<Userinfo> userinfos = userinfoDao.findUserByUserName(userName);
			Iterator<Userinfo> it = userinfos.iterator();
			if(it.hasNext()) {
				userId = it.next().getIuserId().toString(); //获取用户id
			}
			sb.append("fr.userinfo.iuserId = " + userId + " and ");
		}
		sb.append(statusHQL);
		return getHibernateTemplate().find(sb.toString());
	}
	
}
