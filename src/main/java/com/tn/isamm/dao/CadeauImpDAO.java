package com.tn.isamm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tn.isamm.entities.Cadeau;
import com.tn.isamm.entities.User;
@Repository
public class CadeauImpDAO implements CadeauDAO {
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean create(Cadeau m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(m);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean update(Cadeau m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(m);
		tx.commit();
		session.close();
		return true;
		
	}

	@Override
	public boolean delete(Cadeau m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Cadeau c2=(Cadeau)session.get(Cadeau.class, m.getId());
		session.delete(c2);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public Cadeau findById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Cadeau c=(Cadeau)session.get(Cadeau.class, new Integer(id));
		tx.commit();
		session.close();
		return(c); 
	}

	@Override
	public List<Cadeau> findByAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from Cadeau");
		List<Cadeau> l=(List<Cadeau>)q.list();
		tx.commit();
		session.close();
		return l;
	}

}
