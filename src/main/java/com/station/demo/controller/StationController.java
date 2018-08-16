package com.station.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.station.demo.model.StationInfo;
import com.station.demo.services.StationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/services")
@Api("Radio application which allow create new stations and update existing stations and dose basic crud operations")
public class  StationController {

	@Autowired
	StationService  stationService;

	@PostMapping(value = "/station")
	@ApiOperation(value = "Creates new Station with information provided.")
	public StationInfo createStation(@RequestBody StationInfo stationInfo) {
		return stationService.createStation(stationInfo);
	}

	@PutMapping("/station/{id}")
	@ApiOperation(value = "Update existing Station with information provided.")
	public StationInfo updateStation(@PathVariable int id, @RequestBody StationInfo stationInfo) {
		return stationService.updateStation(id,stationInfo);
	}

	@GetMapping("/stations")
	@ApiOperation(value = "Get all existing Stations with information provided.")
	public List<StationInfo> getAllStations() {
		return stationService.getAllStations();
	}

	@GetMapping("/stations/{id}")
	@ApiOperation(value = "Get Station by ID provided.")
	public List<StationInfo> getStationsById1(@PathVariable int id) {
		return stationService.getStationsById(id);
	}

	@DeleteMapping(value = "/stations/{stationid}")
	@ApiOperation(value = "Delete Station By Id")
	public boolean deleteCustomber(@PathVariable(value="stationid") int stationid) {
		return stationService.deleteStation(stationid);
	}

}