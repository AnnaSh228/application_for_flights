package com.example.demos;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demos.dto.FilterDto;
import com.example.demos.dto.FlightDto;
import com.example.demos.dto.FlightUpdateDto;
import com.example.demos.dto.UserDto;
import com.example.demos.entity.Flight;
import com.example.demos.entity.User;
import com.example.demos.services.FlightService;
import com.example.demos.services.UserService;

@SpringBootTest
class DemosApplicationTests {
	@Autowired
	FlightService flightService;
	@Autowired
UserService userService;
//test for create user	
@Test
	void createUser() {
		UserDto userDTO = new UserDto();
		userDTO.username = "viktor";
		userDTO.name = "Vasya";
		userDTO.lastname = "Grishin";
		userDTO.email = "vasya@inbox.ru";
		userDTO.password = "123";
		userDTO.phoneNumber = "89247174056";
	
		
		assertDoesNotThrow(() -> {
			User user = userService.createUser(userDTO);
			assertEquals(user.getUsername(), userService.getUserById(user.getId()).getUsername());
			assertThrows(RuntimeException.class, ()->{
				userService.createUser(userDTO);
			});

			userService.deleteUserById(user.getId());
		});
	}

	//test datas
	@Test
	public void beforeAll(){
		try{
		
			UserDto userDTO = new UserDto();
			userDTO.username = "Oleg321";
			userDTO.name = "Oleg";
			userDTO.lastname = "Olegov";
			userDTO.email = "Vasya@mail.ru";
			userDTO.password = "1234";
			userDTO.phoneNumber = "89247174056";
			userService.createUser(userDTO);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	


//test for create flight
	@Test
	void createFlight() {
		FlightDto flightDTO = new FlightDto();
		flightDTO.flyNumber = "SU228";
		flightDTO.ticketPrice = 600;
		flightDTO.distanceInKm = 800;
		flightDTO.departureAirport = "SVO";
		flightDTO.arrivalAirport = "DLS";
		flightDTO.countryArrival = "Paris";
		flightDTO.countryDeparture = "Moscow";
		flightDTO.arrivalDate = "2022-06-10 10:10";
		flightDTO.departureDate = "2022-06-10 10:10";

		
		assertDoesNotThrow(() -> {
			Flight flight = flightService.createFlight(flightDTO);

			flightService.deleteFlight(flight.getId());
		});
	}


//test for update data about flight

	@Test
	void flightUpdateTest(){
		FlightUpdateDto flightDTO = new FlightUpdateDto();
		flightDTO.id=5;
		flightDTO.ticketPrice = 600;
		flightDTO.arrivalDate = "2022-06-10 10:10";
		flightDTO.departureDate = "2022-06-10 10:10";

		assertDoesNotThrow(() -> {
			Flight flight = flightService.updateFlight(flightDTO);			

			flightService.deleteFlight(flight.getId());
		});
	}


	//test for get

	@Test
	void flightListSearch(){
	FilterDto dto=new FilterDto();
		dto.setCountryArrival("Moscow");
		dto.setCountryDeparture("Irkutsk");
		dto.setDepartureDate("2022-06-10 10:10");
		assertDoesNotThrow(() -> {
				flightService.getFilterList(dto);

			
		});
	}


	//test for getUserBy ID

	@Test
	void getUserById(){
		UserDto userDTO = new UserDto();
		userDTO.username = "viktorй";
		userDTO.name = "Vasya";
		userDTO.lastname = "Grishin";
		userDTO.email = "vasya@inbox.ru";
		userDTO.password = "123";
		userDTO.phoneNumber = "89247174056";
		User user = userService.createUser(userDTO);
			assertEquals(user.getUsername(), userService.getUserById(user.getId()).getUsername());
				

			
				userService.getUserById(user.getId());
				userService.deleteUserById(user.getId());
			
			}

			//test for data parse

	@Test
	void parseData(){
		FilterDto DTO = new FilterDto();
	
		DTO.setArrivalDate("25.07.2022 10:10");
		DTO.setDepartureDate("25.07.2022 10:10");
	
		
		assertDoesNotThrow(() -> {
			DTO.getArrivalDate();
			DTO.getDepartureDate();

		
	});


		
			}
		}


		
	

	









