package com.tn.isamm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.EventDAO;

@Service
public class EventService {
	private EventDAO eventDao;
	@Autowired
	public void setEventDao(EventDAO eventDao) {
		this.eventDao = eventDao;
	}
	
	

}
