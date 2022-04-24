package com.example.demos.services;

import org.slf4j.LoggerFactory;

import com.example.demos.dto.UserDto;
import com.example.demos.entity.User;
import com.example.demos.entity.enams.Roles;
import com.example.demos.repositories.FlightRepository;
import com.example.demos.repositories.UserRepository;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final FlightRepository flightRepository;
   

    @Autowired
    public UserService(UserRepository userRepository, FlightRepository flightRepository){
        this.userRepository=userRepository;
        this.flightRepository=flightRepository;
    }

    public User createUser(UserDto dto){
        User newUser=new User();
        newUser.setUsername(dto.username);
        newUser.setName(dto.name);
        newUser.setLastname(dto.lastname);
        newUser.setEmail(dto.email);
        newUser.setPassword(dto.password);
        newUser.setPassportNumber(dto.passportNumber);
        newUser.setAddress(dto.address);
        newUser.setBankcardNumber(dto.bankcardNumber);
        newUser.setPhoneNumber(dto.phoneNumber);
      // newUser.setUserRoles(Roles.USER);
    

    try {
        LOG.info("Saving user {}", dto.username);
        return userRepository.save(newUser);
    } catch (Exception e){
        LOG.error("Error during creating user {}", e.getMessage());
        throw new RuntimeException("Failed create user");
    }
}
    
}
