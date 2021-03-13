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

import com.ivione.entity.Athlete;
import com.ivione.entity.Competition;
import com.ivione.service.WorkoutService;

@RequestScoped
@Path("/workout")
public class WorkoutResource {
	
	private static final Logger LOG = Logger.getLogger(WorkoutResource.class);
	
	@Inject
	WorkoutService service;
    
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/athlete/new")
    public Response newAthlete(Athlete athlete) {
    	LOG.infof("Call to method newAthlete: %s", athlete);
    	try {
			return service.newAthlete(athlete);
		} catch (Exception e) {
			LOG.errorf("Error in the creation of athlete %s", athlete);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/athlete/{licencia}/competition")
    public Response newCompetition(@PathParam("licencia") String license, Competition competition) {
    	LOG.infof("Call to method newCompetition %s for athlete %s", competition, license);
    	try {
			return service.newCompetition(license, competition);
		} catch (Exception e) {
			LOG.errorf("Error in the creation of %s for athlete %s", competition, license);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
    }
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/athlete/all")
	public Response getAllAthletes() {
		LOG.infof("Call to method getAllAthletes");
		try {
			return service.getAllAthletes();
		} catch (Exception e) {
			LOG.errorf("Error getting the listing of athletes");
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/athlete/{licencia}/competition/all")
	public Response getAllCompetitionsByAthlete(@PathParam("licencia") String license) {
		LOG.infof("Call to method getAllCompetitionsByAthlete for athlete %s", license);
		try {
			return service.getAllCompetitionsByAthlete(license);
		} catch (Exception e) {
			LOG.errorf("Error getting the listing of competitions of athlete %s", license);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}