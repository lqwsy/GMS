package com.gms.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gms.dao.ICompetitionReplyDao;
import com.gms.po.Competitionreply;

public class CompetitionReplyDaoImpl extends HibernateDaoSupport implements ICompetitionReplyDao{

	@Override
	public Long save(Competitionreply reply) {
		// TODO Auto-generated method stub
		return (Long)getHibernateTemplate().save(reply);
	}

	@Override
	public void delete(Competitionreply reply) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(reply);
	}

	@Override
	public Competitionreply get(Long id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Competitionreply.class, id);
	}

	@Override
	public List findByCommentId(Long id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().
				find("from Competitionreply r where r.competitioncomment.bcommentId=?", id);
	}

}
