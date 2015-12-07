package com.tn.isamm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.CadeauDAO;
import com.tn.isamm.dao.StatistiqueDAO;
import com.tn.isamm.entities.User;

@Service
public class StatistiqueService {
	private StatistiqueDAO  statistiqueDAO;
	@Autowired
	public void cadeauDAO(StatistiqueDAO statDAO) {
		this.statistiqueDAO = statDAO;
	}
	
	public int moyenne ()
	{
		return statistiqueDAO.profit();
	}
	
	public List eventparcategorie()
	{
		return statistiqueDAO.nbr_Event_categorie();
	}
	
	public User userPlusActif()
	{
		return statistiqueDAO.user_plus_actif();
	}
	public User userPlusFiele()
	{
		return statistiqueDAO.user_plus_fidele();
	}

	public List prix_moy_categorie()
	{
		return statistiqueDAO.prix_moy_categorie();
	}
}
