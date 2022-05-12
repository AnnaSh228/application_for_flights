package com.example.demos.repositories;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demos.entity.Flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findFlightById(Long id);
    Flight deleteFlightById(Long id);
    Flight findFlightByCountry(String country);
    
    List<Flight> findAllFlightByCountry(String country);

    // @Query(value = 
    //     "SELECT * FROM flight WHERE arrival_airport = ?1" +
    //     "AND departure_airport = ?2"+
    //     "BETWEEN ?3 AND ?4", 
    //     nativeQuery = true)
    // List<Flight> findAllByFilter(String arrival, String departure, 
    //     LocalDateTime arrivalDate, LocalDateTime departureDate);
 
    
    List<Flight> findAllByArrivalAirportAndDepartureAirport(String arrival, String departure);

}
