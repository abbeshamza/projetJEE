package com.tn.isamm.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Categorie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String label;
	@OneToMany(mappedBy="categorie")
	private Collection<Event> event = new ArrayList<Event>();
	@OneToMany(mappedBy="categorie")
	private Collection<Cadeau> cadeau = new ArrayList<Cadeau>();
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Collection<Event> getEvent() {
		return event;
	}
	public void setEvent(Collection<Event> event) {
		this.event = event;
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
	public Categorie(String label, Collection<Event> event, Collection<Cadeau> cadeau) {
		super();
		this.label = label;
		this.event = event;
		this.cadeau = cadeau;
	}
	public Categorie() {
		
	}
	

}
