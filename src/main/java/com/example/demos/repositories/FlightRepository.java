package com.example.demos.repositories;



import java.util.List;

import com.example.demos.entity.Flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findFlightById(Long id);
    Flight deleteFlightById(Long id);
    Flight findFlightByCountry(String country);
    
    List<Flight> findAllFlightByCountry(String country);
    
}
