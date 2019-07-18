package com.solucionesdigitales.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="USER")
public class User {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="N_ID")
    private int id;
	@Column(name="C_NAME")
    private String name;
	@Column(name="C_EMAIL")
    private String email;
	@Column(name="N_EDAD")
    private int edad;
	@Column(name="C_SEXO")
    private String sexo;

    public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", edad=" + edad + ", sexo=" + sexo + "]";
	}
	
}
