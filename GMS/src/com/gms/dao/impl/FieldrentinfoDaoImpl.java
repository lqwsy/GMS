package com.gms.dao.impl;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gms.dao.IFieldrentinfoDao;
import com.gms.po.Fieldrentinfo;

public class FieldrentinfoDaoImpl extends HibernateDaoSupport implements IFieldrentinfoDao  {

	@Override
	public Long save(Fieldrentinfo fieldrentinfo) {
		return (long)getHibernateTemplate().save(fieldrentinfo);
	}

	@Override
	public void delete(Fieldrentinfo fieldrentinfo) {
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
	
}
