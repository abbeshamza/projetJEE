package com.tn.isamm.dao;

import java.util.List;

import com.tn.isamm.entities.Event;
import com.tn.isamm.entities.Panier;
import com.tn.isamm.entities.User;

public interface PanierDAO {
	public boolean create(Panier m);
	public boolean update(Panier m);
	public boolean delete(Panier m);
	public Panier findById(int id);
	public Panier findByUser(User u);
	public List<Panier>findByAll();

}
