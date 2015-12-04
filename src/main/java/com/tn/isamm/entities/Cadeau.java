package com.tn.isamm.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Cadeau {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String label;
	private int prix;
	@ManyToOne
	@JoinColumn(name="categorie")
	private Categorie categorie;
	
	@ManyToMany
	private Collection<Panier> panier= new ArrayList<Panier>();

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Collection<Panier> getPanier() {
		return panier;
	}

	public void setPanier(Collection<Panier> panier) {
		this.panier = panier;
	}

	public int getId() {
		return id;
	}

	public Cadeau(String label, int prix, Categorie categorie, Collection<Panier> panier) {
		super();
		this.label = label;
		this.prix = prix;
		this.categorie = categorie;
		this.panier = panier;
	}
	public Cadeau() {
		
	}
	
	
}
