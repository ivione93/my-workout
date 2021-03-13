package com.ivione.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import com.ivione.dto.AtletaDto;
import com.ivione.entity.Atleta;
import com.ivione.entity.Competicion;

@RequestScoped
public class WorkoutService {
	
	private static final Logger LOG = Logger.getLogger(WorkoutService.class);
	
	@Inject
	MapperService mapper;
	
	@Transactional
	public Response altaAtleta(Atleta payload) {
		LOG.infof("Servicio alta atleta %s", payload);
		
		AtletaDto response = new AtletaDto();
		Atleta atleta = Atleta.findById(payload.licencia);
		
		if(atleta == null) {
			Atleta atleta_bd = mapper.toAtleta(payload);
			atleta_bd.persist();
			
			response.licencia = atleta_bd.licencia;
			response.fechaAlta = (DateTimeFormatter.ISO_INSTANT.format(atleta_bd.fechaAlta));
		} else {
			LOG.errorf("La licencia %s ya existe", payload.licencia);
			return Response.status(Status.CONFLICT).build();
		}
		
		return Response.status(Status.CREATED).entity(response).build();
	}

	@Transactional
	public Response altaCompeticion(String licencia, Competicion competicion) {
		LOG.infof("Servicio alta %s para atleta %s", competicion, licencia);
		
		Atleta atleta = Atleta.findById(licencia);
		if(atleta != null) {
			Competicion competicion_bd = mapper.toCompeticion(licencia, competicion);
			competicion_bd.persist();
		} else {
			LOG.errorf("El atleta %s no existe", licencia);
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.status(Status.CREATED).build();
	}

	public Response verAtletas() {
		LOG.infof("Servicio consulta de atletas");
		List<Atleta> atletas = Atleta.findAll().list();
		return Response.status(Status.OK).entity(atletas).build();
	}

	public Response verCompeticionesAtleta(String licencia) {
		LOG.infof("Servicio consulta de competiciones para el atleta %s", licencia);
		List<Competicion> competiciones = new ArrayList<Competicion>();
		
		Atleta atleta = Atleta.findById(licencia);
		if(atleta != null) {
			competiciones = Competicion.find("licencia", licencia).list();
		} else {
			LOG.errorf("El atleta %s no existe", licencia);
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.status(Status.OK).entity(competiciones).build();
	}

}
