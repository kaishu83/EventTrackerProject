package com.skilldistillery.EventTracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class fishTripTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private FishingTrip ft;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf=Persistence.createEntityManagerFactory("123test");
		
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em=emf.createEntityManager();
		ft= em.find(FishingTrip.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void test() {
		assertEquals("antero", ft.getLake());
		assertEquals(4,ft.getFishCaught());
		assertEquals("cold but not windy",ft.getWeather());
	}

}
