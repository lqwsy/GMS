package com.gms.dao.impl;


import java.util.Iterator;
import java.util.List;

import org.hibernate.dialect.Ingres10Dialect;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gms.dao.IFieldinfoDao;
import com.gms.po.Fieldinfo;

public class FieldinfoDaoImpl extends HibernateDaoSupport implements IFieldinfoDao  {
	
	@Override
	public Long save(Fieldinfo fieldinfo) {
		return (Long)getHibernateTemplate().save(fieldinfo);
	}

	@Override
	public void delete(Fieldinfo fieldinfo) {
		getHibernateTemplate().delete(fieldinfo);
	}

	@Override
	public void update(Fieldinfo fieldinfo) {
		getHibernateTemplate().update(fieldinfo);
	}

	@Override
	public Fieldinfo get(long id) {
		return getHibernateTemplate().get(Fieldinfo.class, id);
	}

	@Override
	public List getAll() {
		return getHibernateTemplate().find("from Fieldinfo");
	}

	@Override
	public List getByFieldtypeId(long fieldTypeId) {
		return getHibernateTemplate().find("from Fieldinfo fi where fi.fieldtype.fieldtypeId="+fieldTypeId);
	}
	
	public List getByTypeIdWithoutFieldId(long fieldTypeId, List<Long> fieldIds) {
		int i = 0;
		StringBuffer sb = new StringBuffer();
		for(long fieldId : fieldIds) {
			if(i == 0) {
				sb.append(fieldId);
			}else {
				sb.append(","+fieldId);
			}
			i++;
		}
		if(sb.length() == 0) {
			return getHibernateTemplate().find("from Fieldinfo fi where fi.fieldtype.fieldtypeId="+fieldTypeId);
		}
		return getHibernateTemplate().find("from Fieldinfo fi where fi.fieldtype.fieldtypeId="
								+fieldTypeId +" and fi.fieldId NOT IN " + "(" + sb.toString() + ")");
	}
	
	public void saveOrUpdateFieldinfo(Fieldinfo fieldinfo) {
		getHibernateTemplate().saveOrUpdate(fieldinfo);
	}
	
	public List getFieldinfoByName(String fieldName) {
		return getHibernateTemplate().find("from Fieldinfo fi where fi.fieldName = '" + fieldName + "'");
	}
}
