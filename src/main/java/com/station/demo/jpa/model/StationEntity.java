package com.station.demo.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StationInfo")
public class StationEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "StationId")
	private int stationid;
	@Column(name = "Name")
	private String name;
	@Column(name = "HdEnabled")
	private boolean hdEnabled;
	@Column(name = "CallSign")
	private String callSign;
	
	public StationEntity() {
		
	}
	
	public StationEntity(String name, boolean hdEnabled, String callSign) {
		super();
		this.name = name;
		this.hdEnabled = hdEnabled;
		this.callSign = callSign;
	}
	public int getStationid() {
		return stationid;
	}
	public void setStationid(int stationid) {
		this.stationid = stationid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isHdEnabaled() {
		return hdEnabled;
	}
	public void setHdEnabaled(boolean hdEnabaled) {
		this.hdEnabled = hdEnabaled;
	}
	public String getCallSign() {
		return callSign;
	}
	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}
	

}
