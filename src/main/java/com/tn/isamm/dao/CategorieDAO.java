package com.tn.isamm.dao;

import java.util.List;

import com.tn.isamm.entities.Categorie;

public interface CategorieDAO {
	
	public boolean create(Categorie m);
	public boolean update(Categorie m);
	public boolean delete(Categorie m);
	public Categorie findById(int id);
	public List<Categorie>findByAll();
	public Categorie findByLabel(String label);

}
