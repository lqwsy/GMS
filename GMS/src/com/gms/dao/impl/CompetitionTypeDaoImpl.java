package com.gms.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gms.dao.ICompetitionTypeDao;
import com.gms.po.Competitiontype;

public class CompetitionTypeDaoImpl extends HibernateDaoSupport implements ICompetitionTypeDao{

	@Override
	public Competitiontype get(Integer typeId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Competitiontype.class, typeId);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Competitiontype");
	}

}
