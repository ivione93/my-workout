package com.ivione;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import com.ivione.entity.Atleta;
import com.ivione.entity.Competicion;
import com.ivione.service.WorkoutService;

@RequestScoped
@Path("/atleta")
public class WorkoutResource {
	
	private static final Logger LOG = Logger.getLogger(WorkoutResource.class);
	
	@Inject
	WorkoutService service;
    
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/alta")
    public Response altaAtleta(Atleta atleta) {
    	LOG.infof("Alta de atleta: %s", atleta);
    	try {
			return service.altaAtleta(atleta);
		} catch (Exception e) {
			LOG.errorf("Error en el alta del atleta %s", atleta);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{licencia}/competicion")
    public Response altaCompeticion(@PathParam("licencia") String licencia, Competicion competicion) {
    	LOG.infof("Alta de %s para el atleta %s", competicion, licencia);
    	try {
			return service.altaCompeticion(licencia, competicion);
		} catch (Exception e) {
			LOG.errorf("Error en el alta del atleta %s en competicion", licencia, competicion);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
    }
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public Response verAtletas() {
		LOG.infof("Obteniendo atletas");
		try {
			return service.verAtletas();
		} catch (Exception e) {
			LOG.errorf("No se ha podido conseguir el listado de atletas");
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{licencia}/competicion/all")
	public Response verCompeticionesAtleta(@PathParam("licencia") String licencia) {
		LOG.infof("Obteniendo competiciones para el atleta %s", licencia);
		try {
			return service.verCompeticionesAtleta(licencia);
		} catch (Exception e) {
			LOG.errorf("No se ha podido conseguir el listado de competiciones para el atleta %s", licencia);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}