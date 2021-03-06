package com.tn.isamm.dao;

import java.util.List;

import com.tn.isamm.entities.Reservation;
import com.tn.isamm.entities.User;

public interface ReservationDAO {
	public boolean create(Reservation m);
	public boolean update(Reservation m);
	public boolean delete(Reservation m);
	public Reservation findById(int id);
	public List<Reservation>findByAll();
	public List<Reservation>findByUser(User u);

}
