package com.bigdata.project.graphdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigdata.project.graphdb.pojos.Station;
import com.bigdata.project.graphdb.repositories.StationRepository;

@Service("StationServices")
public class StationServices {

   @Autowired
   private StationRepository stationRepository;	

   public Station create(Station station) {
      return stationRepository.save(station);
   }

   public void delete(Station station) {		
	   stationRepository.delete(station);
   }

   public Station findById(long id) {		
      return stationRepository.findById(id).isPresent()? stationRepository.findById(id).get():null;
   }

//   public Result<GoogleProfile> findAll() {		
//      return stationRepository.findAll();
//   }
}
