package com.gms.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gms.dao.IFieldtypeDao;
import com.gms.po.Fieldtype;

public class FieldtypeDaoImpl extends HibernateDaoSupport implements IFieldtypeDao {

	@Override
	public long save(Fieldtype fieldtype) {
		return (long)getHibernateTemplate().save(fieldtype);
	}

	@Override
	public void delete(Fieldtype fieldtype) {
		getHibernateTemplate().delete(fieldtype);
	}

	@Override
	public void update(Fieldtype fieldtype) {
		getHibernateTemplate().update(fieldtype);
	}

	@Override
	public Fieldtype get(long id) {
		return getHibernateTemplate().get(Fieldtype.class, id);
	}

	@Override
	public List getAll() {
		return getHibernateTemplate().find("from Fieldtype");
	}

	
}
