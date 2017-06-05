package com.gms.dao.impl;

import java.util.List;

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

	@Override
	public List findResultsByCompetitionId(Long competitionId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().
				find("from Competitionresult cr where cr.competition.bcompetitionId=?",competitionId);
	}

	@Override
	public Integer getScore(Long id) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().
				find("select iscores from Competitionresult c where c.bcompetitionResultId=?",id).
				get(0);
	}

}
