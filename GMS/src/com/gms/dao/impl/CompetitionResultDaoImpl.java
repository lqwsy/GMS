package com.gms.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gms.dao.ICompetitionResultDao;
import com.gms.po.Competitionresult;

public class CompetitionResultDaoImpl extends HibernateDaoSupport implements ICompetitionResultDao{

	@Override
	public Competitionresult get(Long id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Competitionresult.class, id);
	}

	@Override
	public void update(Competitionresult result) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(result);
	}

}
