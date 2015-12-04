package com.tn.isamm.dao;

import java.util.List;

import com.tn.isamm.entities.Carte;

public interface CarteDAO {
	public boolean create(Carte m);
	public boolean update(Carte m);
	public boolean delete(Carte m);
	public Carte findById(int id);
	public List<Carte>findByAll();

}
