

package com.staion.demo;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.station.demo.model.StationInfo;
import com.station.demo.RadioStationApplication;




@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes =RadioStationApplication.class
		)
@AutoConfigureMockMvc
public class RadioStationApplicationTests {

	@Autowired
	MockMvc  mockMvc;

	@Test
	public void  getAllStationsTest() throws Exception {

		mockMvc.perform(get("/services/stations").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(2)));

	}

	@Test
	public void getStationTest() throws Exception {


		mockMvc.perform(get("/services/stations/2")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());

		mockMvc.perform(get("/services/stations/21")
				.contentType(MediaType.APPLICATION_JSON))

		.andExpect(status().isOk())
		.andExpect(jsonPath("$.stationid", is(1)));

	}

	
}


