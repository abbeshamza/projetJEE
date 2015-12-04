package com.tn.isamm.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String label;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date date ;
	private int nbr_participant;
	private String lieu;
	private int prix;
	private String img;
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	@ManyToOne
	@JoinColumn(name="categorie")
	private Categorie categorie;
	@OneToMany(mappedBy="event")
	private Collection<Reservation> events = new ArrayList<Reservation>();
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNbr_participant() {
		return nbr_participant;
	}
	public void setNbr_participant(int nbr_participant) {
		this.nbr_participant = nbr_participant;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Collection<Reservation> getEvents() {
		return events;
	}
	public void setEvents(Collection<Reservation> events) {
		this.events = events;
	}
	public int getId() {
		return id;
	}
	public Event(String label, String description, Date date, int nbr_participant, String lieu, int prix, String img,
			User user, Categorie categorie, Collection<Reservation> events) {
		
		this.label = label;
		this.description = description;
		this.date = date;
		this.nbr_participant = nbr_participant;
		this.lieu = lieu;
		this.prix = prix;
		this.img = img;
		this.user = user;
		this.categorie = categorie;
		this.events = events;
	}
	public Event()
	{
		
	}
	
	
	
	

}
