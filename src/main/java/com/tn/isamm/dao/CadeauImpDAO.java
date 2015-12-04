package com.tn.isamm.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tn.isamm.entities.Cadeau;
@Repository
public class CadeauImpDAO implements CadeauDAO {
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean create(Cadeau m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Cadeau m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Cadeau m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cadeau findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cadeau> findByAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
