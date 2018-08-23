package com.station.demo.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.station.demo.jpa.model.StationEntity;


public interface StationRepository extends CrudRepository<StationEntity, Integer> {
	
	@Query("select sd from StationEntity sd where sd.stationid=:stationid")
	public StationEntity getStationsById(@Param("stationid") int stationid);
	
	@Query("select sd from StationEntity sd where sd.hdEnabled=TRUE")
	public List<StationEntity> getStationsByHD();
	
}
