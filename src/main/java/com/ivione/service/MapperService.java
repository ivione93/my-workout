package com.ivione.service;

import java.time.Instant;

import javax.enterprise.context.RequestScoped;

import com.ivione.entity.Athlete;
import com.ivione.entity.Competition;

@RequestScoped
public class MapperService {
	
	public Athlete toAthlete(Athlete atleta) {
		Athlete atleta_bd = new Athlete();
		atleta_bd.license = atleta.license;
		atleta_bd.name = atleta.license;
		atleta_bd.surnames = atleta.surnames;
		atleta_bd.birthDate = atleta.birthDate;
		atleta_bd.createdDate = Instant.now();
		return atleta_bd;
	}
	
	public Competition toCompetition(String license, Competition competicion) {
		Competition competicion_bd = new Competition();
		competicion_bd.license = license;
		competicion_bd.place = competicion.place;
		competicion_bd.name = competicion.name;
		competicion_bd.date = competicion.date;
		competicion_bd.track = competicion.track;
		competicion_bd.result = competicion.result;
		return competicion_bd;
	}

}
