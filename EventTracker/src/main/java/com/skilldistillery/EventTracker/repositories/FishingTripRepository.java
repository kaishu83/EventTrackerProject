package com.skilldistillery.EventTracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.EventTracker.entities.FishingTrip;

public interface FishingTripRepository extends JpaRepository<FishingTrip, Integer> {
	List<FishingTrip> findByLakeLike(String lake);
	List<FishingTrip> findByFishCaughtBetween(int low, int high);
}
