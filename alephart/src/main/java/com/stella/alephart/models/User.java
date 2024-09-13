package com.stella.alephart.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	
	@Column
	private String first_name;
	
	@Column
	private String last_name;
	
	@Column
	private String phone_number;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	public User() {}
	
	public User(Long id_user, String first_name, String last_name, String phone_number, String password, String email) {
		super();
		this.id_user = id_user;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.password = password;
		this.email = email;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", phone_number=" + phone_number + ", password=" + password + ", email=" + email + "]";
	}
	
	
	
	
}
