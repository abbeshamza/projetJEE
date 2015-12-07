package com.tn.isamm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.PanierDAO;
import com.tn.isamm.entities.Panier;
import com.tn.isamm.entities.User;

@Service
public class PanierService {
	private PanierDAO panierDAO;
	@Autowired
	public void setPanierDAO(PanierDAO panierDAO) {
		this.panierDAO = panierDAO;
	}
	

	
	
	public boolean enregistrerPanier(Panier m){
		return panierDAO.create(m);
	}
	
	public boolean mettreAJourPanier(Panier m){
		return panierDAO.update(m);
	}
	
	public boolean supprimerPanier(int id){
		Panier Panier= panierDAO.findById(id);
		
		return panierDAO.delete(Panier);
	}
	
	public Panier rechercherPanier(int id){
		return panierDAO.findById(id);
	}
	public Panier rechercherPanierByUser(User u)
	{
		return panierDAO.findByUser(u);
	}
	

	
	public List<Panier> rechercherTous(){
		return panierDAO.findByAll();
	}
	
	

}
