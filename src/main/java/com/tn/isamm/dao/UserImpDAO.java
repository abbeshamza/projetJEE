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
		v.setEtat(1);
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
	public boolean delete(User m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		m.setEtat(0);
		session.update(m);
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
	public User findByUsernameAndPassword(String username,String password)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from User u where u.username = :username and u.password = :password and u.etat = :id");
		q.setParameter("id", 1);
		q.setParameter("username", username);
		q.setParameter("password", password);
		User c = new User();
		if (!q.list().isEmpty())
		 c=(User)q.list().get(0);
		else
			c =null;
		tx.commit();
		session.close();
		return(c); 
		
	}

	@Override
	public List<User> findByAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from User u where u.etat = :id ");
		q.setParameter("id", 1);
		List<User> l=(List<User>)q.list();
		tx.commit();
		session.close();
		return l;
	}

}
