package com.gms.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.gms.dao.IRoleinfoDao;
import com.gms.po.Roleinfo;

public class RoleinfoDaoImpl extends HibernateDaoSupport implements IRoleinfoDao {

	/*@Override
	public Integer save(Roleinfo roleinfo) {
		return (Integer) getHibernateTemplate().save(roleinfo);
	}

	@Override
	public void update(Roleinfo roleinfo) {
		getHibernateTemplate().update(roleinfo);
	}

	@Override
	public void delete(Roleinfo roleinfo) {
		getHibernateTemplate().delete(roleinfo);
	}*/

	@Override
	public Roleinfo get(Integer iRoleId) {
		return getHibernateTemplate().get(Roleinfo.class, iRoleId);
	}

	@Override
	public List findAllRole() {
		return getHibernateTemplate().find("from Roleinfo");
	}

}
