package com.tn.isamm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.tn.isamm.entities.Categorie;
@Repository
public class CategorieImpDAO implements CategorieDAO {
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean create(Categorie c) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(c);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean update(Categorie m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(m);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean delete(Categorie c) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Categorie c2=(Categorie)session.get(Categorie.class, c.getId());
		session.delete(c2);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public Categorie findById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Categorie c=(Categorie)session.get(Categorie.class, new Integer(id));
		tx.commit();
		session.close();
		return(c); 
	}

	@Override
	public List<Categorie> findByAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from Categorie");
		List<Categorie> l=(List<Categorie>)q.list();
		tx.commit();
		session.close();
		return l;
	}

}
