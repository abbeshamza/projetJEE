package com.tn.isamm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.dao.ReservationDAO;

@Service
public class ReservationService {
	private ReservationDAO reservationDAO;
	@Autowired
	public void setReservationDAO(ReservationDAO reservationDAO) {
		this.reservationDAO = reservationDAO;
	}
	

}
