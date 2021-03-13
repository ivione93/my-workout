package com.ivione.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="atleta")
public class Atleta extends PanacheEntityBase {
	
	@Id
	public String licencia;
	
	public String nombre;
	
	public String apellidos;
	
	@Column(name="fecha_nacimiento")
	public String fechaNacimiento;
	
	@Column(name="fecha_alta")
	public Instant fechaAlta;

	@Override
	public String toString() {
		return "Atleta [" + (licencia != null ? "licencia=" + licencia + ", " : "")
				+ (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (apellidos != null ? "apellidos=" + apellidos + ", " : "")
				+ (fechaNacimiento != null ? "fechaNacimiento=" + fechaNacimiento + ", " : "")
				+ (fechaAlta != null ? "fechaAlta=" + fechaAlta : "") + "]";
	}

}
