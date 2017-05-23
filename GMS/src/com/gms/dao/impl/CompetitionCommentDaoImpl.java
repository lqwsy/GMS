package com.gms.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gms.dao.ICompetitionCommentDao;
import com.gms.po.Competitioncomment;

public class CompetitionCommentDaoImpl extends HibernateDaoSupport implements ICompetitionCommentDao{

	@Override
	public Long save(Competitioncomment competitionComment) {
		// TODO Auto-generated method stub
		return (Long)getHibernateTemplate().save(competitionComment);
	}

	@Override
	public void delete(Competitioncomment competitionComment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(competitionComment);
	}

	@Override
	public Competitioncomment get(Long id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Competitioncomment.class, id);
	}

	@Override
	public List findByCompetitionId(Long id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().
				find("from Competitioncomment c where c.competition.bcompetitionId=?",id);
	}

}
