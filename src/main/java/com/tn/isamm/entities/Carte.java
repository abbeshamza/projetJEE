package com.tn.isamm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Carte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank
	@Size(min = 6, max = 6)
	private String numero;
	@NotBlank
	@Size(min = 4, max = 8)
	private String password;
	private double solde ;
	@OneToOne
	@JoinColumn(name="user")
	private User user ;
	
	public Carte() {
		
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public Carte(String numero, String password, double solde, User user) {
		super();
		this.numero = numero;
		this.password = password;
		this.solde = solde;
		this.user = user;
	}
	
	
	
	
	
	

}
