package com.tn.isamm.dao;

import java.util.List;

import com.tn.isamm.entities.Event;
import com.tn.isamm.entities.User;

public interface EventDAO {
	public boolean create(Event m);
	public boolean update(Event m);
	public boolean delete(Event m);
	public Event findById(int id);
	public List<Event>findByAll();
	public List<Event>findByUser(User u);

}
