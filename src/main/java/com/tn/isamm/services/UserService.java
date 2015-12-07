package com.tn.isamm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.PanierDAO;
import com.tn.isamm.dao.UserDAO;
import com.tn.isamm.entities.Panier;
import com.tn.isamm.entities.User;


@Service
public class UserService {
	
private UserDAO userDAO;
private PanierDAO panierDAO;
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Autowired
	public void setPanierDAO(PanierDAO panierDAO) {
		this.panierDAO = panierDAO;
	}
	
	
	
	public boolean enregistrerUser(User m){
		m.setNb_points(0);
		m.setRole("user");
		Panier p = new Panier();
		p.setUser(m);
		userDAO.create(m);
		return  panierDAO.create(p);
		
		
	}
	
	public boolean mettreAJourUser(User m){
		return userDAO.update(m);
	}
	
	public boolean supprimerUser(int id){
		User user= userDAO.findById(id);
		
		return userDAO.delete(user);
	}
	
	public User rechercherUser(int id){
		return userDAO.findById(id);
	}
	
	public User loginUser (User u)
	{
		return userDAO.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
	

	
	public List<User> rechercherTous(){
		return userDAO.findByAll();
	}
	

}
