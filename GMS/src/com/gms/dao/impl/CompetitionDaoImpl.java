package com.gms.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gms.dao.ICompetitionDao;
import com.gms.po.Competition;

public class CompetitionDaoImpl extends HibernateDaoSupport implements ICompetitionDao{

	@Override
	public Long save(Competition competition) {
		// TODO Auto-generated method stub
		return (Long)getHibernateTemplate().save(competition);
	}

	@Override
	public void delete(Competition competition) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(competition);
	}

	@Override
	public void update(Competition competition) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(competition);
	}

	@Override
	public Competition get(Long id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Competition.class, id);
	}

}
