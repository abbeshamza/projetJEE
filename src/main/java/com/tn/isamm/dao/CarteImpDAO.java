package com.tn.isamm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tn.isamm.entities.Carte;
import com.tn.isamm.entities.User;
@Repository
public class CarteImpDAO implements CarteDAO {
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean create(Carte m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(m);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean update(Carte m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(m);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean delete(Carte m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Carte c2=(Carte)session.get(Carte.class, m.getId());
		session.delete(c2);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public Carte findById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Carte c=(Carte)session.get(Carte.class, new Integer(id));
		tx.commit();
		session.close();
		return(c); }
	
	public Carte findByUser(User u)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from Carte c where c.user = :user ");
		q.setParameter("user", u);
		Carte c =null;
		if (q.list().size()>0)
			c=(Carte) q.list().get(0);
		
		tx.commit();
		session.close();
		return c;
		
	}

	@Override
	public List<Carte> findByAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from Carte");
		List<Carte> l=(List<Carte>)q.list();
		tx.commit();
		session.close();
		return l;
	}

}
