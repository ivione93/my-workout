package com.ivione;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTestResource(H2DatabaseTestResource.class)
@QuarkusTest
public class WorkoutResourceTest {
	
	/*@Test
	public void altaAtletaTest() {
		given()
			.when()
			.header("Content-Type", "application/json")
			.body("{\"licencia\": \"M1599\",\"nombre\": \"Iván\",\"apellidos\": \"García Gómez\",\"fechaNacimiento\": \"18-06-1993\"}")
			.post("/atleta/alta")
			.then()
			.statusCode(201);
		
	}*/

}