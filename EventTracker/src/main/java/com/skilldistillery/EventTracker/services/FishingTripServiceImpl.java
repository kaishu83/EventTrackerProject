package com.skilldistillery.EventTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.EventTracker.entities.FishingTrip;
import com.skilldistillery.EventTracker.repositories.FishingTripRepository;

@Service
public class FishingTripServiceImpl implements FishingTripService {

	@Autowired
	FishingTripRepository repo;

	@Override
	public FishingTrip findById(Integer id) {
		FishingTrip tp = null;
		Optional<FishingTrip> op = repo.findById(id);
		if (op.isPresent()) {
			tp = op.get();
		}

		return tp;
	}

	@Override
	public List<FishingTrip> findAll() {
		List<FishingTrip> trips = null;
		trips = repo.findAll();

		return trips;
	}

	@Override
	public FishingTrip createFishingTrip(FishingTrip trip) {
		System.out.println(trip);
		trip.setId(0);
		repo.saveAndFlush(trip);

		return trip;
	}

	@Override
	public List<FishingTrip> findByLake(String lake) {
		lake = "%" + lake + "%";
		List<FishingTrip> trips = null;
		trips = repo.findByLakeLike(lake);
		return trips;
	}

	@Override
	public List<FishingTrip> findByFishCaughtBetween(int low, int high) {
		List<FishingTrip> trips = null;
		trips = repo.findByFishCaughtBetween(low, high);
		return trips;
	}

	@Override
	public FishingTrip updateFishingTrip(Integer id, FishingTrip trip) {
		Optional<FishingTrip> op = repo.findById(id);

		FishingTrip newTrip = new FishingTrip();
		if (!op.isPresent()) {
			return null;
		}

		else {
			newTrip.setId(id);
			newTrip.setDate(trip.getDate());
			newTrip.setFishCaught(trip.getFishCaught());
			newTrip.setLake(trip.getLake());
			newTrip.setWeather(trip.getWeather());
		}

		return newTrip;
	}

//	@Override
//	public Boolean deleteFishingTrip(Integer id) {
//		Optional<FishingTrip> op = repo.findById(id);
//		FishingTrip trip = null;
//		boolean status = false;
//		if (op.isPresent()) {
//			trip = op.get();
//			repo.delete(trip);
//			status = true;
//		} else {
//			return false;
//		}
//
//		return null;
//	}

}
