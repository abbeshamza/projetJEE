package com.tn.isamm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.ReservationDAO;
import com.tn.isamm.entities.Reservation;
import com.tn.isamm.entities.User;

@Service
public class ReservationService {
	private ReservationDAO reservationDAO;
	@Autowired
	public void setReservationDAO(ReservationDAO reservationDAO) {
		this.reservationDAO = reservationDAO;
	}

	
	
	public boolean enregistrerReservation(Reservation m){
		return reservationDAO.create(m);
	}
	
	public boolean mettreAJourReservation(Reservation m){
		return reservationDAO.update(m);
	}
	
	public boolean supprimerReservation(int id){
		Reservation Reservation= reservationDAO.findById(id);
		
		return reservationDAO.delete(Reservation);
	}
	
	public Reservation rechercherReservation(int id){
		return reservationDAO.findById(id);
	}
	
	public List<Reservation> rechercherParUser(User u){
		return reservationDAO.findByUser(u);
	}
	
	public List<Reservation> rechercherTous(){
		return reservationDAO.findByAll();
	}
	

}
