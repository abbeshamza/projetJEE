package com.tn.isamm.dao;

import java.util.List;

import com.tn.isamm.entities.Carte;
import com.tn.isamm.entities.User;

public interface CarteDAO {
	public boolean create(Carte m);
	public boolean update(Carte m);
	public boolean delete(Carte m);
	public Carte findById(int id);
	public Carte findByUser(User u);
	public List<Carte>findByAll();

}
