package com.tn.isamm.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tn.isamm.entities.Categorie;
import com.tn.isamm.entities.Event;
import com.tn.isamm.entities.Panier;
import com.tn.isamm.entities.PrixCategorie;
import com.tn.isamm.entities.Reservation;
import com.tn.isamm.entities.User;


@Repository
public class StatistiqueImpDAO implements StatistiqueDAO{
	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int profit() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		
		Criteria q = sessionFactory.openSession().createCriteria(Reservation.class)
				.add(Restrictions.eq("statut", "oui"))
				.setProjection(Projections.projectionList()
				.add(Projections.property("nbr_place"))
				.add(Projections.property("event")));
		List l =q.list();
		Iterator i = l.iterator();
		int somme=0;
		while(i.hasNext())
		{
			Object [] o= (Object[])i.next();
			Integer nb = (Integer) o[0];
			Event e = (Event) o[1];
			somme= somme+ nb*e.getPrix();
			System.out.println("le nombre est : "+nb);
		}
		
		tx.commit();
		session.close();
		
		return somme;
	}

	@Override
	public List nbr_Event_categorie() {
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		
		Criteria q = sessionFactory.openSession().createCriteria(Event.class)
				.setProjection(Projections.projectionList()
				.add(Projections.count("id"))
				.add(Projections.groupProperty("categorie")));
		List l =q.list();
		Iterator i = l.iterator();
		
		
		while(i.hasNext())
		{
			Object [] o= (Object[])i.next();
			Categorie c = (Categorie) o[1];
			Long e = (Long) o[0];
		}
		
		tx.commit();
		session.close();
		
		return l;
	}

	
	@Override
	public User user_plus_actif() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		
		Criteria q = sessionFactory.openSession().createCriteria(Event.class)
				.setProjection(Projections.projectionList()
				.add(Projections.count("id"))
				.add(Projections.groupProperty("user")));
		List l =q.list();
		Iterator i = l.iterator();
		Long max=(long) 0;
		User umax= new User();
		while(i.hasNext())
		{
			Object [] o= (Object[])i.next();
			User c = (User) o[1];
			Long e = (Long) o[0];
			if(e>max)
				umax= c ;
				
		}
		
		tx.commit();
		session.close();
		
		return umax;
	}

	@Override
	public User user_plus_fidele() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		
		Criteria q = sessionFactory.openSession().createCriteria(Reservation.class)
				.add(Restrictions.eq("statut", "oui"))
				.setProjection(Projections.projectionList()
				.add(Projections.count("id"))
				.add(Projections.groupProperty("panier")));
		List l =q.list();
		Iterator i = l.iterator();
		Long max=(long) 0;
		User umax= new User();
		while(i.hasNext())
		{
			Object [] o= (Object[])i.next();
			Panier p = (Panier) o[1];
			User c = p.getUser();
			Long e = (Long) o[0];
			if(e>max)
				umax= c ;
		}
		
		tx.commit();
		session.close();
		
		return umax;
	}

	@Override
	public List prix_moy_categorie() {
		
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		
		Criteria q = sessionFactory.openSession().createCriteria(Event.class)
				.setProjection(Projections.projectionList()
				.add(Projections.avg("prix"))
				.add(Projections.groupProperty("categorie")));
		List l =q.list();
		Iterator i = l.iterator();
		List<PrixCategorie> k = new ArrayList<PrixCategorie>();
		while(i.hasNext())
		{
			
			Object [] o= (Object[])i.next();
			Categorie c = (Categorie) o[1];
			o[1]= c;
			Double e = (Double) o[0];
		}
		
		tx.commit();
		session.close();
		
		return l;
		
	}
	
	
	

}
