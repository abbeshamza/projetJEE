package com.tn.isamm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.PanierDAO;

@Service
public class PanierService {
	private PanierDAO panierDAO;
	@Autowired
	public void setPanierDAO(PanierDAO panierDAO) {
		this.panierDAO = panierDAO;
	}
	
	

}
