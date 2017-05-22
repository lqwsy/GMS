package com.gms.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.gms.dao.IUserinfoDao;
import com.gms.po.Userinfo;

public class UserinfoDaoImpl extends HibernateDaoSupport implements IUserinfoDao {
//github.com/lqwsy/GMS.git
	
	
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

	@Override
	public List findByName(String vRealName) {
		return getHibernateTemplate().find("from Userinfo u where u.vRealName = ?",vRealName);
	}
	
	

}
