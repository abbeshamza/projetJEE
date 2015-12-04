package com.tn.isamm.dao;

import java.util.List;

import com.tn.isamm.entities.Reservation;

public interface ReservationDAO {
	public boolean create(Reservation m);
	public boolean update(Reservation m);
	public boolean delete(Reservation m);
	public Reservation findById(int id);
	public List<Reservation>findByAll();

}
