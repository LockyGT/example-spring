package com.solucionesdigitales.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="PRODUCTO")
public class Producto {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="N_ID")
	int id;
	@Column(name="C_DESCRIPCION")
	String descripcion;
	@Column(name="N_COSTO")
	double costo;
	@Column(name="N_CANTIDAD")
	int cantidad;
	@Column(name="C_STATUS")
	String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", costo=" + costo + ", cantidad=" + cantidad
				+ ", status=" + status + "]";
	}
	
}
