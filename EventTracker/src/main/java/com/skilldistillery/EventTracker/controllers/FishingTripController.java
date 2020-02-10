package com.skilldistillery.EventTracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.EventTracker.entities.FishingTrip;
import com.skilldistillery.EventTracker.services.FishingTripService;

@RestController
@RequestMapping("api")
public class FishingTripController {
	@Autowired
	FishingTripService service;

	@GetMapping("trips")
	public List<FishingTrip> index(HttpServletResponse resp) {
		List<FishingTrip> trips = null;
		try {
			trips = service.findAll();
			if (trips != null) {
				resp.setStatus(200);
			} else
				resp.setStatus(404);

		} catch (Exception e) {
			resp.setStatus(400);
		}
		return trips;
	}

	@PostMapping("trips")
	public FishingTrip create(@RequestBody FishingTrip trip, HttpServletResponse resp, HttpServletRequest req) {
		FishingTrip newTrip = null;
		System.out.println(trip);
		try {
			newTrip = service.createFishingTrip(trip);
			System.out.println(newTrip);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(newTrip.getId());
			resp.addHeader("Location", url.toString());
		} catch (Exception e) {
			newTrip = null;
			resp.setStatus(404);
		}
		return newTrip;
	}

	@PutMapping("trips/{id}")
	public FishingTrip update(@RequestBody FishingTrip trip, @PathVariable Integer id, HttpServletResponse resp) {
		FishingTrip newTrip = null;
		try {
			newTrip = service.updateFishingTrip(id, trip);
			resp.setStatus(200);
			if (newTrip == null) {
				resp.setStatus(404);
			}
		} catch (Exception e) {
			resp.setStatus(400);
		}

		return newTrip;

	}
	@DeleteMapping("trips/{id}")
	public void delete(@PathVariable Integer id,HttpServletResponse resp) {
		
		try {
		if(service.deleteFishingTrip(id)) {
			resp.setStatus(200);
			
		}
		else {
			resp.setStatus(404);
		}
		}
		catch(Exception e) {
			resp.setStatus(400);
		}
		
	}

}
