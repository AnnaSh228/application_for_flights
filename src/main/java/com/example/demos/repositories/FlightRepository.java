package com.example.demos.repositories;

import java.util.List;

import com.example.demos.entity.Flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List <Flight> findAllByUserId(long id);
    void deleteFlightById(long id);
    
}
