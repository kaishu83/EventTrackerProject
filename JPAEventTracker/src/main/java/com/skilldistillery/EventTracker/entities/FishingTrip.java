package com.skilldistillery.EventTracker.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "fishing_trip")
@Entity
public class FishingTrip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String lake;
	private String date;
	private String weather;

	@Column(name = "fish_caught")
	private int fishCaught;

	@Override
	public String toString() {
		return "FishingTrip [id=" + id + ", lake=" + lake + ", date=" + date + ", weather=" + weather + ", fishCaught="
				+ fishCaught + "]";
	}

	public FishingTrip() {
		super();
	}

	public FishingTrip(int id, String lake, String date, String weather, int fishCaught) {
		super();
		this.id = id;
		this.lake = lake;
		this.date = date;
		this.weather = weather;
		this.fishCaught = fishCaught;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLake() {
		return lake;
	}

	public void setLake(String lake) {
		this.lake = lake;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public int getFishCaught() {
		return fishCaught;
	}

	public void setFishCaught(int fishCaught) {
		this.fishCaught = fishCaught;
	}

}
