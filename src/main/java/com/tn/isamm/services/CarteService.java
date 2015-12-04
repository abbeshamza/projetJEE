package com.tn.isamm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.CarteDAO;

@Service
public class CarteService {
	private CarteDAO carteDao ;
	@Autowired
	public CarteDAO getCarteDao() {
		return carteDao;
	}
	

}
