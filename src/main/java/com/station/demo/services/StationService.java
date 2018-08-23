package com.station.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.station.demo.exception.StationDemoException;
//import com.station.demo.exception.StationDemoExceptionCode;
import com.station.demo.jpa.model.StationEntity;
import com.station.demo.jpa.repository.StationRepository;
import com.station.demo.model.StationInfo;


@Service
public class StationService {

	@Autowired
	StationRepository  stationrepository;

		
	/**
	 * Create Station 
	 * @return The StationInfo
	 */
	public StationInfo createStation(StationInfo stationinfo) {
		
		StationEntity stationentity = new StationEntity(stationinfo.getName(),stationinfo.isHdEnabled(),stationinfo.getCallSign());
				
		stationrepository.save(stationentity);
		
		stationinfo.setStationid(stationentity.getStationid());
		
		return stationinfo;
	}

	/**
	 * Update Station 
	 * @return The StationInfo
	 */
	public StationInfo updateStation(int id,StationInfo stationinfo) {
		
		StationEntity stationentity = new StationEntity(stationinfo.getName(),stationinfo.isHdEnabled(),stationinfo.getCallSign());
		
		stationentity.setStationid(id);
		
		stationrepository.save(stationentity);
		
		return stationinfo;
	}
	
	/**
	 * Retrieve Station 
	 * @return The StationInfo
	 */
	public StationInfo getStations(StationInfo stationinfo) {

		List<StationEntity> lstStations = (List<StationEntity>) stationrepository.findAll();
		
		for (StationEntity Station : lstStations)
		{
			stationinfo.setStationid(Station.getStationid());
			stationinfo.setCallSign(Station.getCallSign());
			stationinfo.setHdEnabled(Station.isHdEnabaled());
			stationinfo.setName(Station.getName());
			
			//return stationinfo;
		}
				
		return stationinfo;
	}

	
	public List<StationInfo> getAllStations() {
		// TODO Auto-generated method stub
		List<StationInfo> Stations = new ArrayList<>();
			
		for (StationEntity Station : stationrepository.findAll())
		{
			Stations.add(new StationInfo(Station.getStationid(),Station.getCallSign(),Station.isHdEnabaled(),Station.getName()));
		}
		
		return Stations;
	}
	
	/**
	 * Get specific Station Details 
	 * @return Stations
	 */
	public List<StationInfo> getStationsById(int stationid) {
		// TODO Auto-generated method stub
		List<StationInfo> Stations = new ArrayList<>();
		
		StationEntity  stationentity = stationrepository.getStationsById(stationid);
		
		Stations.add(new StationInfo(stationentity.getStationid(),stationentity.getCallSign(),stationentity.isHdEnabaled(),stationentity.getName()));
			
		return Stations;
	}
	
	/**
	 * Delete specific station by Id  
	 * @return true if deleted successfully
	 */
	public boolean deleteStation(int stationid) {
		StationEntity  stationentity = stationrepository.getStationsById(stationid);
		
		if (stationentity == null ) {
		//	throw new DemoException(DemoExceptionCode.NO_STATION_FOUND);
			return false;
		}
		else {
			stationrepository.delete(stationentity);
			return true;			
		}
	}
	
	/**
	 * Get HDEnabled Stations 
	 * @return HDEnabled Stations
	 */
	public List<StationInfo> getStationsByHD() {
		// TODO Auto-generated method stub
		List<StationInfo> Stations = new ArrayList<>();
		
		for (StationEntity Station : stationrepository.getStationsByHD()) 
		{
		Stations.add(new StationInfo(Station.getStationid(),Station.getCallSign(),Station.isHdEnabaled(),Station.getName()));
		}
		return Stations;
		
	}

}
