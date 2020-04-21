package com.bigdata.project.graphdb;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigdata.project.graphdb.pojos.Station;
import com.bigdata.project.graphdb.pojos.TravelDetails;
import com.bigdata.project.graphdb.services.StationServices;

@RestController
@RequestMapping("/")
public class DataLoading {
	
	@Autowired
	private StationServices stationServices;
	
	@GetMapping("/create")
	public String loadData() {
	
		Station a = new Station((long) 4,"A",1,2);
		Station b = new Station((long) 5,"B",1,2);
		TravelDetails trip1 = new TravelDetails((long) 1, 120, "kk", "kk", 1, "kk", 1, 1);
		a.addStation(b);
		trip1.setStartStation(a);
		trip1.setEndStation(b);
		stationServices.create(a);
		stationServices.create(b);
		
		return "success";
		
	}
	
	@PostMapping("/getstation")
	public Station addBook(@RequestBody Long id) {
		
		return stationServices.findById(id);
	}
}
