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

import com.ivione.dto.AthleteDto;
import com.ivione.entity.Athlete;
import com.ivione.entity.Competition;

@RequestScoped
public class WorkoutService {
	
	private static final Logger LOG = Logger.getLogger(WorkoutService.class);
	
	@Inject
	MapperService mapper;
	
	@Transactional
	public Response newAthlete(Athlete payload) {
		LOG.debugf("New athlete service: %s", payload);
		
		AthleteDto response = new AthleteDto();
		Athlete athlete = Athlete.findById(payload.license);
		
		if(athlete == null) {
			Athlete athlete_bd = mapper.toAthlete(payload);
			athlete_bd.persist();
			
			response.license = athlete_bd.license;
			response.createdDate = (DateTimeFormatter.ISO_INSTANT.format(athlete_bd.createdDate));
		} else {
			LOG.errorf("The license %s already exists", payload.license);
			return Response.status(Status.CONFLICT).build();
		}
		
		return Response.status(Status.CREATED).entity(response).build();
	}

	@Transactional
	public Response newCompetition(String license, Competition competition) {
		LOG.debugf("New competition %s service for athlete %s", competition, license);
		
		Athlete athlete = Athlete.findById(license);
		if(athlete != null) {
			Competition competition_bd = mapper.toCompetition(license, competition);
			competition_bd.persist();
		} else {
			LOG.errorf("The athlete %s does not exist", license);
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.status(Status.CREATED).build();
	}

	public Response getAllAthletes() {
		LOG.debugf("Get all athletes service");
		List<Athlete> athletes = Athlete.findAll().list();
		return Response.status(Status.OK).entity(athletes).build();
	}

	public Response getAllCompetitionsByAthlete(String license) {
		LOG.debugf("Get all competitions service for athlete %s", license);
		List<Competition> competitions = new ArrayList<Competition>();
		
		Athlete athlete = Athlete.findById(license);
		if(athlete != null) {
			competitions = Competition.find("license", license).list();
		} else {
			LOG.errorf("The athlete %s does not exist", license);
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.status(Status.OK).entity(competitions).build();
	}

}
