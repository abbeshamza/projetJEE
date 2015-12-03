package com.tn.isamm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.tn.isamm.entities.User;
@Repository
public class UserImpDAO implements UserDAO {
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean create(User v) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(v);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean update(User m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(m);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean delete(User c) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		User c2=(User)session.get(User.class, c.getId());
		session.delete(c2);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public User findById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		User c=(User)session.get(User.class, new Integer(id));
		tx.commit();
		session.close();
		return(c); 
	}

	@Override
	public List<User> findByAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from User");
		List<User> l=(List<User>)q.list();
		tx.commit();
		session.close();
		return l;
	}

}
