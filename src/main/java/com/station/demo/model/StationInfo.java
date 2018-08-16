package com.station.demo.model;

//import java.io.Serializable;
//import org.hibernate.validator.constraints.NotBlank;

public class StationInfo {
	
	
	private int stationid;
	
	//@NotBlank
	private String name;
	//@NotBlank
	private boolean hdEnabled;
	//@NotBlank
	private String callSign;
	
	public StationInfo() {
		
	}	
	
	public StationInfo(int stationid, String name, boolean hdEnabled, String callSign) {
		super();
		this.stationid = stationid;
		this.name = name;
		this.hdEnabled = hdEnabled;
		this.callSign = callSign;
	}
	
	public StationInfo(String name, boolean hdEnabled, String callSign) {
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

	public boolean isHdEnabled() {
		return hdEnabled;
	}

	public void setHdEnabled(boolean hdEnabled) {
		this.hdEnabled = hdEnabled;
	}

	public String getCallSign() {
		return callSign;
	}

	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}
	
	
}
