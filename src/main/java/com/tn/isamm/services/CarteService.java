package com.tn.isamm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.CarteDAO;
import com.tn.isamm.entities.Carte;
import com.tn.isamm.entities.User;

@Service
public class CarteService {
	private CarteDAO carteDAO ;
	@Autowired
	public void setCarteDAO(CarteDAO carteDAO) {
		this.carteDAO = carteDAO;
	}
	
	

	
	public boolean enregistrerCarte(Carte m){
		m.setSolde(20);
		return carteDAO.create(m);
	}
	
	

	public boolean mettreAJourCarte(Carte m){
		return carteDAO.update(m);
	}
	
	public boolean supprimerCarte(int id){
		Carte carte= carteDAO.findById(id);
		
		return carteDAO.delete(carte);
	}
	
	public Carte rechercherCarte(int id){
		return carteDAO.findById(id);
	}
	

	public Carte rechercherCarteParUser(User u){
		return carteDAO.findByUser(u);
	}
	
	public List<Carte> rechercherTous(){
		return carteDAO.findByAll();
	}
	

	

}
