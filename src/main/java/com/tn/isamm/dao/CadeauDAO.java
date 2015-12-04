package com.tn.isamm.dao;

import java.util.List;

import com.tn.isamm.entities.Cadeau;

public interface CadeauDAO {
	public boolean create(Cadeau m);
	public boolean update(Cadeau m);
	public boolean delete(Cadeau m);
	public Cadeau findById(int id);
	public List<Cadeau>findByAll();

}
