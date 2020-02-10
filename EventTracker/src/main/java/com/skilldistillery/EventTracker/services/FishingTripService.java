package com.skilldistillery.EventTracker.services;

import java.util.List;

import com.skilldistillery.EventTracker.entities.FishingTrip;

public interface FishingTripService {
	FishingTrip findById(Integer id);

	List<FishingTrip> findAll();

	FishingTrip createFishingTrip(FishingTrip trip);

	List<FishingTrip> findByLake(String lake);

	List<FishingTrip> findByFishCaughtBetween(int low, int high);

	FishingTrip updateFishingTrip(Integer id, FishingTrip trip);
	
//	Boolean deleteFishingTrip(Integer id);

}
