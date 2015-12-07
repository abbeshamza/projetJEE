package com.tn.isamm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.CategorieDAO;
import com.tn.isamm.entities.Categorie;

@Service
public class CategorieService {
	private CategorieDAO categorieDAO;
	@Autowired
	public void setCategorieDao(CategorieDAO categorieDao) {
		this.categorieDAO = categorieDao;
	}

	
	
	public boolean enregistrerCategorie(Categorie m){
		return categorieDAO.create(m);
	}
	
	public boolean mettreAJourCategorie(Categorie m){
		return categorieDAO.update(m);
	}
	
	public boolean supprimerCategorie(int id){
		Categorie Categorie= categorieDAO.findById(id);
		
		return categorieDAO.delete(Categorie);
	}
	
	public Categorie rechercherCategorie(int id){
		return categorieDAO.findById(id);
	}
	public Categorie rechercherCategorieByLabel(String label){
		return categorieDAO.findByLabel(label);
	}
	

	
	public List<Categorie> rechercherTous(){
		return categorieDAO.findByAll();
	}
	

}
