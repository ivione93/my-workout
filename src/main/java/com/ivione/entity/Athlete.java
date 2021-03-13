package com.ivione.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="athlete")
public class Athlete extends PanacheEntityBase {
	
	@Id
	public String license;
	
	@Column(name="athlete_name")
	public String name;
	
	public String surnames;
	
	@Column(name="birth_date")
	public String birthDate;
	
	@Column(name="created_date")
	public Instant createdDate;

	@Override
	public String toString() {
		return "Athlete [" + (license != null ? "license=" + license + ", " : "")
				+ (name != null ? "name=" + name + ", " : "") + (surnames != null ? "surnames=" + surnames + ", " : "")
				+ (birthDate != null ? "birthDate=" + birthDate + ", " : "")
				+ (createdDate != null ? "createdDate=" + createdDate : "") + "]";
	}

}
