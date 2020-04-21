package com.bigdata.project.graphdb.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.bigdata.project.graphdb.pojos.Station;

@Repository
public interface StationRepository extends Neo4jRepository<Station, Long> {
	
}