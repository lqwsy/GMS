package com.gms.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.gms.dao.IUserinfo;
import com.gms.po.Userinfo;

public class UserinfoDao extends HibernateDaoSupport implements IUserinfo {
	
	
	@Override
	public Integer save(Userinfo userinfo) {
		return (Integer) getHibernateTemplate().save(userinfo);
	}

	@Override
	public void delete(Userinfo userinfo) {
		getHibernateTemplate().delete(userinfo);
	}

	@Override
	public void update(Userinfo userinfo) {
		getHibernateTemplate().update(userinfo);
	}

	@Override
	public Userinfo get(Integer iUserId) {
		return getHibernateTemplate().get(Userinfo.class, iUserId);
	}

	@Override
	public List findAllUser() {
		return getHibernateTemplate().find("from Userinfo");
	}
	
	

}
