package com.Semillero2023.Practica2.entity;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO")
@DynamicUpdate @DynamicInsert
public class Usuario implements Serializable{

	private static final long serialVersionUID = 4765050212987314083L;
	
	@Id
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="password")
	private String password;

	public String getUsername() {        
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
