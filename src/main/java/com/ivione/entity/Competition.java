package com.ivione.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="competition")
public class Competition extends PanacheEntityBase {
	
	@Id
	public String license;
	
	public String place;
	
	@Column(name = "competition_name")
	public String name;
	
	@Column(name = "competition_date")
	public Instant date;
	
	public String track;
	
	public String result;

	@Override
	public String toString() {
		return "Competition [" + (license != null ? "license=" + license + ", " : "")
				+ (place != null ? "place=" + place + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (date != null ? "date=" + date + ", " : "") + (track != null ? "track=" + track + ", " : "")
				+ (result != null ? "result=" + result : "") + "]";
	}

}
