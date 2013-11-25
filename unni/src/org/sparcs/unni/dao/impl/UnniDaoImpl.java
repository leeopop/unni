package org.sparcs.unni.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.sparcs.unni.dao.UnniDao;
import org.sparcs.unni.entity.Unni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UnniDaoImpl implements UnniDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Unni saveOrUpdate(Unni unni) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(unni);
		session.flush();
		return unni;
	}

	@Override
	public Unni searchDB(String id) throws UsernameNotFoundException {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Unni.class);
		criteria.add(Restrictions.eq("id", id));
		Unni userEntity = (Unni) criteria.uniqueResult();
		if (userEntity == null) {
			throw new UsernameNotFoundException("UserID:" + id + " does not exist.");
		}
		return userEntity;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
