package com.tn.isamm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.EventDAO;
import com.tn.isamm.entities.Event;
import com.tn.isamm.entities.User;

@Service
public class EventService {
	private EventDAO eventDAO;
	@Autowired
	public void setEventDao(EventDAO eventDao) {
		this.eventDAO = eventDao;
	}
	

	
	
	public boolean enregistrerEvent(Event m){
		return eventDAO.create(m);
	}
	
	public boolean mettreAJourEvent(Event m){
		return eventDAO.update(m);
	}
	
	public boolean supprimerEvent(int id){
		Event Event= eventDAO.findById(id);
		
		return eventDAO.delete(Event);
	}
	
	public Event rechercherEvent(int id){
		return eventDAO.findById(id);
	}
	

	
	public List<Event> rechercherTous(){
		return eventDAO.findByAll();
	}
	public List<Event> rechercherParUser(User u)
	{
		return eventDAO.findByUser( u);
	}
	

}
