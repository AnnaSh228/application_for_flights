package com.example.demos.services;

import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

import com.example.demos.dto.UserDto;
import com.example.demos.entity.User;
import com.example.demos.entity.enams.Roles;
import com.example.demos.repositories.FlightRepository;
import com.example.demos.repositories.UserRepository;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    FlightRepository flightRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public User createUser(UserDto dto){
        User newUser=new User();
        newUser.setUsername(dto.username);
        newUser.setName(dto.name);
        newUser.setLastname(dto.lastname);
        newUser.setEmail(dto.email);
        newUser.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        newUser.setPhoneNumber(dto.phoneNumber);

        Set<String> roles = new HashSet<>();
        roles.add(Roles.ROLE_USER);
        newUser.setRole(roles);

        try {
            LOG.info("Saving user {}", dto.username);
            return userRepository.save(newUser);
        } catch (Exception e){
            LOG.error("Error during creating user {}", e.getMessage());
            throw new RuntimeException("Failed create user");
        }
    }   
    
}
