package com.tn.isamm.dao;

import java.util.List;

import com.tn.isamm.entities.User;

public interface UserDAO {
	
	public boolean create(User m);
	public boolean update(User m);
	public boolean delete(User m);
	public User findById(int id);
	public User findByUsernameAndPassword(String username,String password);
	public List<User>findByAll();

}
