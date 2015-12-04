package com.tn.isamm.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tn.isamm.entities.Event;
@Repository
public class EventImpDAO implements EventDAO {
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean create(Event m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Event m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Event m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Event findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> findByAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
