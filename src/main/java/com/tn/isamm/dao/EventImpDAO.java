package com.tn.isamm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tn.isamm.entities.Event;
import com.tn.isamm.entities.User;
@Repository
public class EventImpDAO implements EventDAO {
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean create(Event m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		m.setEtat(1);
		session.save(m);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean update(Event m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(m);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean delete(Event m) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		m.setEtat(0);
		session.update(m);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public Event findById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Event c=(Event)session.get(Event.class, new Integer(id));
		tx.commit();
		session.close();
		return(c);
	}

	@Override
	public List<Event> findByAll() {
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from Event e where e.etat = :id ");
		q.setParameter("id", 1);
		List<Event> l=(List<Event>)q.list();
		tx.commit();
		session.close();
		return l;
	}
	public List<Event> findByUser(User u)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from Event e where e.user = :user");
		q.setParameter("user", u);
		List<Event> l=(List<Event>)q.list();
		tx.commit();
		session.close();
		return l;
	
	}

}
