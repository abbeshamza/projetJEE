package com.tn.isamm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.UserDAO;
import com.tn.isamm.entities.User;


@Service
public class UserService {
	
private UserDAO userDAO;
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	
	public boolean enregistrerUser(User m){
		return userDAO.create(m);
	}
	
	public boolean mettreAJourUser(User m){
		return userDAO.update(m);
	}
	
	public boolean supprimerUser(int id){
		User User= userDAO.findById(id);
		
		return userDAO.delete(User);
	}
	
	public User rechercherUser(int id){
		return userDAO.findById(id);
	}
	

	
	public List<User> rechercherTous(){
		return userDAO.findByAll();
	}
	

}
