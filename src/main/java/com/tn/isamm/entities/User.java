package com.tn.isamm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String email;
	private String password;
	private String num_tel;
	private int nb_points;
	private String role;
	private String img;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}
	public int getNb_points() {
		return nb_points;
	}
	public void setNb_points(int nb_points) {
		this.nb_points = nb_points;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getId() {
		return id;
	}
	public User()
	{
		
	}
	public User(String username, String email, String password, String num_tel, int nb_points, String role,
			String img) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.num_tel = num_tel;
		this.nb_points = nb_points;
		this.role = role;
		this.img = img;
	}
	
	
	

}
