package com.ivione.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="competicion")
public class Competicion extends PanacheEntityBase {
	
	@Id
	public String licencia;
	
	public String lugar;
	
	public String nombre;
	
	public Instant fecha;
	
	public String prueba;
	
	public String marca;

	@Override
	public String toString() {
		return "Competicion [" + (licencia != null ? "licencia=" + licencia + ", " : "")
				+ (lugar != null ? "lugar=" + lugar + ", " : "") + (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (fecha != null ? "fecha=" + fecha + ", " : "") + (prueba != null ? "prueba=" + prueba + ", " : "")
				+ (marca != null ? "marca=" + marca : "") + "]";
	}

}
