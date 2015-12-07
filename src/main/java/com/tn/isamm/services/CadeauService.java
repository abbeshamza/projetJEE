package com.tn.isamm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.CadeauDAO;
import com.tn.isamm.entities.Cadeau;
import com.tn.isamm.entities.User;

@Service
public class CadeauService {
private CadeauDAO cadeauDAO;
	
	@Autowired
	public void cadeauDAO(CadeauDAO cadeauDAO) {
		this.cadeauDAO = cadeauDAO;
	}
	

	
	public boolean enregistrerUser(Cadeau m){
		return cadeauDAO.create(m);
	}
	
	public boolean mettreAJourCadeau(Cadeau m){
		return cadeauDAO.update(m);
	}
	
	public boolean supprimerCadeau(int id){
		Cadeau cadeau= cadeauDAO.findById(id);
		
		return cadeauDAO.delete(cadeau);
	}
	
	public Cadeau rechercherCadeau(int id){
		return cadeauDAO.findById(id);
	}
	

	
	public List<Cadeau> rechercherTous(){
		return cadeauDAO.findByAll();
	}
	


}
