package com.tn.isamm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String statut;
	private int nbr_place;
	@ManyToOne
	@JoinColumn(name="panier")
	private Panier panier;
	@ManyToOne
	@JoinColumn(name="event")
	private Event event ;
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public int getNbr_place() {
		return nbr_place;
	}
	public void setNbr_place(int nbr_place) {
		this.nbr_place = nbr_place;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public int getId() {
		return id;
	}
	public Reservation(String statut, int nbr_place, Panier panier, Event event) {
		super();
		this.statut = statut;
		this.nbr_place = nbr_place;
		this.panier = panier;
		this.event = event;
	}
	public Reservation(){
		
	}
	
	
	
	


}
