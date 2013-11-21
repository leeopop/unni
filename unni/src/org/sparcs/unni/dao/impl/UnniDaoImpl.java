package org.sparcs.unni.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sparcs.unni.dao.UnniDao;
import org.sparcs.unni.entity.Unni;
import org.springframework.beans.factory.annotation.Autowired;
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

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
