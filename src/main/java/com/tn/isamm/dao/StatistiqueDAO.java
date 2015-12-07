package com.tn.isamm.dao;

import java.util.List;

import com.tn.isamm.entities.Categorie;
import com.tn.isamm.entities.User;

public interface StatistiqueDAO {
	public int  profit();
	public List nbr_Event_categorie();
	public User user_plus_actif();
	public User user_plus_fidele();
	public List prix_moy_categorie ();
	

}
