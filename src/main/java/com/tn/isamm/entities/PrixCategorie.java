package com.tn.isamm.entities;

public class PrixCategorie {
	private double prix ;
	private Categorie categorie ;
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public PrixCategorie(double prix, Categorie categorie) {
		super();
		this.prix = prix;
		this.categorie = categorie;
	}
	

}
