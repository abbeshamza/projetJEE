package com.tn.isamm.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tn.isamm.entities.Reservation;
@Repository
public class ReservationImpDAO implements ReservationDAO {
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean create(Reservation m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reservation m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Reservation m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reservation findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> findByAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
