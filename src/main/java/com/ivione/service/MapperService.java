package com.ivione.service;

import java.time.Instant;

import javax.enterprise.context.RequestScoped;

import com.ivione.entity.Atleta;
import com.ivione.entity.Competicion;

@RequestScoped
public class MapperService {
	
	public Atleta toAtleta(Atleta atleta) {
		Atleta atleta_bd = new Atleta();
		atleta_bd.licencia = atleta.licencia;
		atleta_bd.nombre = atleta.nombre;
		atleta_bd.apellidos = atleta.apellidos;
		atleta_bd.fechaNacimiento = atleta.fechaNacimiento;
		atleta_bd.fechaAlta = Instant.now();
		return atleta_bd;
	}
	
	public Competicion toCompeticion(String licencia, Competicion competicion) {
		Competicion competicion_bd = new Competicion();
		competicion_bd.licencia = licencia;
		competicion_bd.lugar = competicion.lugar;
		competicion_bd.nombre = competicion.nombre;
		competicion_bd.fecha = competicion.fecha;
		competicion_bd.prueba = competicion.prueba;
		competicion_bd.marca = competicion.marca;
		return competicion_bd;
	}

}
