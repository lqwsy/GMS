package com.gms.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gms.dao.IEquitmentsUseDao;
import com.gms.po.Equitmentsuse;

public class EquitmentsUseDaoImpl extends HibernateDaoSupport implements IEquitmentsUseDao{

	@Override
	public Equitmentsuse get(Long id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Equitmentsuse.class, id);
	}

}
