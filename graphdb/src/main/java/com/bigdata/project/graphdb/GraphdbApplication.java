package com.bigdata.project.graphdb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import com.bigdata.project.graphdb.pojos.Station;
import com.bigdata.project.graphdb.pojos.TravelDetails;
import com.bigdata.project.graphdb.repositories.StationRepository;

@SpringBootApplication
@EnableNeo4jRepositories
public class GraphdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphdbApplication.class, args);
	}
	 @Bean
	 CommandLineRunner demo( StationRepository stationRepository) {
	 return args -> {

		 Station a = new Station((long) 4,"A",1,2);
			Station b = new Station((long) 5,"B",1,2);
			TravelDetails trip1 = new TravelDetails((long) 1, 120, "kk", "kk", 1, "kk", 1, 1);
			a.addStation(b);
			trip1.setStartStation(a);
			trip1.setEndStation(b);
			stationRepository.save(a);
			stationRepository.save(b);
			System.out.println("Done");
	 };
	 }

}
