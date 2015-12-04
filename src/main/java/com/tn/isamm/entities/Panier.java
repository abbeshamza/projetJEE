package com.tn.isamm.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Panier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name="user")
	private User user ;
	
	@OneToMany(mappedBy="panier")
	private Collection<Reservation> events = new ArrayList<Reservation>();
	@ManyToMany(mappedBy="panier")
	private Collection<Cadeau> cadeau= new ArrayList<Cadeau>();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Collection<Reservation> getEvents() {
		return events;
	}
	public void setEvents(Collection<Reservation> events) {
		this.events = events;
	}
	public Collection<Cadeau> getCadeau() {
		return cadeau;
	}
	public void setCadeau(Collection<Cadeau> cadeau) {
		this.cadeau = cadeau;
	}
	public int getId() {
		return id;
	}
	public Panier(User user, Collection<Reservation> events, Collection<Cadeau> cadeau) {
		super();
		this.user = user;
		this.events = events;
		this.cadeau = cadeau;
	}
	
	public Panier(){
		
	}
}
