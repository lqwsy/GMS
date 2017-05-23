package com.gms.dao.impl;

import java.util.List;

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
	public List findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Announcement");
	}

}
