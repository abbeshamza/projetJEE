package com.tn.isamm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tn.isamm.entities.Event;
import com.tn.isamm.entities.Panier;
import com.tn.isamm.entities.User;
@Repository
public class PanierImpDAO implements PanierDAO {
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean create(Panier m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(m);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean update(Panier m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(m);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean delete(Panier m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Panier c2=(Panier)session.get(Panier.class, m.getId());
		session.delete(c2);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public Panier findById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Panier c=(Panier)session.get(Panier.class, new Integer(id));
		tx.commit();
		session.close();
		return(c); 
	}
	public Panier findByUser(User u){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q = session.createQuery("from Panier p where p.user = :u ");
		q.setParameter("u", u);
		Panier c = null ;
		if (q.list().size()>0)
			 c = (Panier)q.list().get(0);
		tx.commit();
		session.close();
		return(c); 
		
	}

	@Override
	public List<Panier> findByAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from Panier");
		List<Panier> l=(List<Panier>)q.list();
		tx.commit();
		session.close();
		return l;
	}

}
