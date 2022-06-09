package com.example.demos;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demos.dto.FlightDto;
import com.example.demos.dto.UserDto;
import com.example.demos.entity.User;
import com.example.demos.services.FlightService;
import com.example.demos.services.UserService;

@SpringBootTest
class DemosApplicationTests {
	FlightService service;
UserService userService;
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




}
