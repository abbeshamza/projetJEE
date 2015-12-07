package com.tn.isamm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tn.isamm.entities.Reservation;
import com.tn.isamm.entities.User;
@Repository
public class ReservationImpDAO implements ReservationDAO {
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean create(Reservation m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(m);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean update(Reservation m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(m);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean delete(Reservation m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Reservation c2=(Reservation)session.get(Reservation.class, m.getId());
		session.delete(c2);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public Reservation findById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Reservation c=(Reservation)session.get(Reservation.class, new Integer(id));
		tx.commit();
		session.close();
		return(c); 
	}

	@Override
	public List<Reservation> findByAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from Reservation");
		List<Reservation> l=(List<Reservation>)q.list();
		tx.commit();
		session.close();
		return l;
	}
	
	public List<Reservation>findByUser(User u){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from Reservation r where r.panier.user = :user ");
		q.setParameter("user", u);
		List<Reservation> l=(List<Reservation>)q.list();
		tx.commit();
		session.close();
		return l;
	}

}
