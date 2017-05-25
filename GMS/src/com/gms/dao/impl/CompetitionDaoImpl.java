package com.gms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
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

	@Override
	public List findByPage(String hql,Object arg,int offset,int pageSize) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().
				executeFind(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				List result=session.createQuery(hql).
						setParameter(0, arg).
						setFirstResult(offset).
						setMaxResults(pageSize).list();
				return result;
			}
			
		});
		return list;
	}

	@Override
	public List findCompetitions(String hql, Object arg) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(hql, arg);
	}

}
