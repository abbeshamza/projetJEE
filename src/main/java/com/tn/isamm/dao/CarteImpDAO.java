package com.tn.isamm.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tn.isamm.entities.Carte;
@Repository
public class CarteImpDAO implements CarteDAO {
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean create(Carte m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Carte m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Carte m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Carte findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carte> findByAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
