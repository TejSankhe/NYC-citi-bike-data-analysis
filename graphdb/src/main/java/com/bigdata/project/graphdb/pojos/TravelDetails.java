package com.bigdata.project.graphdb.pojos;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "TRAVEL_TO")
public class TravelDetails {
	@Id
	private Long id;

	int tripduration;
	String starttime;
	String stoptime;
	int bikeId;
	String usertype;
	int birth_year;
	int gender;

	@StartNode
	private Station startStation;

	@EndNode
	private Station endStation;

	
	public TravelDetails() {
	}

	public TravelDetails(Long id, int tripduration, String starttime, String stoptime, int bikeId, String usertype,
			int birth_year, int gender) {
		super();
		this.id = id;
		this.tripduration = tripduration;
		this.starttime = starttime;
		this.stoptime = stoptime;
		this.bikeId = bikeId;
		this.usertype = usertype;
		this.birth_year = birth_year;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTripduration() {
		return tripduration;
	}

	public void setTripduration(int tripduration) {
		this.tripduration = tripduration;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getStoptime() {
		return stoptime;
	}

	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public int getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Station getStartStation() {
		return startStation;
	}

	public void setStartStation(Station startStation) {
		this.startStation = startStation;
	}

	public Station getEndStation() {
		return endStation;
	}

	public void setEndStation(Station endStation) {
		this.endStation = endStation;
	}

}