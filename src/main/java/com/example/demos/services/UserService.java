package com.example.demos.services;

import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demos.dto.UserDto;
import com.example.demos.entity.Role;
import com.example.demos.entity.User;
import com.example.demos.entity.enams.Roles;
import com.example.demos.repositories.FlightRepository;
import com.example.demos.repositories.RoleRepository;
import com.example.demos.repositories.UserRepository;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    RoleRepository roleRepository;

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return null;
    }
    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

   
    

    
}   
    

