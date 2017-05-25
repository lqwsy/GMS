package com.gms.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gms.dao.ISpacesUseDao;
import com.gms.po.Spacesuse;

public class SpacesUseDaoImpl extends HibernateDaoSupport implements ISpacesUseDao{

	@Override
	public Spacesuse get(Long id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Spacesuse.class, id);
	}

}
