package com.gms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gms.dao.IAnnouncementDao;
import com.gms.po.Announcement;

public class AnnouncementDaoImpl extends HibernateDaoSupport implements IAnnouncementDao{

	@Override
	public Long save(Announcement announcement) {
		// TODO Auto-generated method stub
		return (Long)getHibernateTemplate().save(announcement);
	}

	@Override
	public void delete(Announcement announcement) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(announcement);
	}

	@Override
	public void update(Announcement announcement) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(announcement);
	}

	@Override
	public Announcement get(Long id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Announcement.class, id);
	}

	@Override
	public List findByPage(String hql, int offset, int pageSize) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().
				executeFind(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				List result=session.createQuery(hql).
						setFirstResult(offset).setMaxResults(pageSize).list();
				return result;
			}
			
		});
		return list;
	}

	@Override
	public List findAllAnnouncement() {
		return getHibernateTemplate().find("from Announcement");
	}

}
