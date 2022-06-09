package com.example.demos.services;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Optional;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.demos.dto.FilterDto;
import com.example.demos.dto.FlightDto;
import com.example.demos.dto.FlightUpdateDto;
import com.example.demos.entity.Flight;
import com.example.demos.repositories.FlightRepository;
import com.example.demos.repositories.UserRepository;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    private final FlightRepository flightRepository;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight createFlight(FlightDto dto) {
        
        Flight newFlight = new Flight();
        newFlight.setFlyNumber(dto.flyNumber);

        newFlight.setTicketPrice(dto.ticketPrice);
  
        newFlight.setDistanceInKm(dto.distanceInKm);
        newFlight.setDepartureAirport(dto.departureAirport);
        newFlight.setArrivalAirport(dto.arrivalAirport);
        newFlight.setCountryDeparture(dto.countryDeparture);
        newFlight.setCountryArrival(dto.countryArrival);
        

        String arrivalDate = dto.arrivalDate.replace("T", " ");
        LocalDateTime dateTime = LocalDateTime.parse(arrivalDate + ":00",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        newFlight.setArrivalDate(dateTime);

        String departureDate = dto.departureDate.replace("T", " ");
        LocalDateTime dateTime1 = LocalDateTime.parse(departureDate + ":00",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        newFlight.setDepartureDate(dateTime1);

        try {
            LOG.info("Saving flight {}", dto.flyNumber);
            return flightRepository.save(newFlight);
        } catch (Exception e) {
            LOG.error("Error {}", dto.flyNumber);
            throw new RuntimeException("Failed create flight");
        }
    }

    public List<Flight> getFlightList() {
        List<Flight> list = flightRepository.findAll();

        return list;
    }

    public Flight getFlight(long id) {
        return flightRepository.findFlightById(id);
    }

    public void deleteFlight(long flightId) {
        try{    
            LOG.info("Try delete{}", flightId);
            flightRepository.deleteById(flightId);
         
        } catch (Exception e){
            LOG.error("Failed delete flight: {}", e);
        }
    }
   

    public List<Flight> allFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> getFilterList(FilterDto dto) {
        List<Flight> flights = flightRepository.findAllByCountryArrivalAndCountryDeparture(dto.getCountryArrival(), dto.getCountryDeparture());
        List<Flight> flightsRes = new ArrayList<>();

        for(var i : flights){
            int left = i.getDepartureDate().compareTo(dto.getDepartureDate().atStartOfDay());
            int right = i.getArrivalDate().compareTo(dto.getDepartureDate().atStartOfDay().plusDays(1));

            if(left >= 0 && right <= 0){
                flightsRes.add(i);
            }
        }

        return flightsRes;
    }

    
    public Flight updateFlight(FlightUpdateDto dto) {
        Optional<Flight> in =  flightRepository.findById(dto.id);
        if(in.isEmpty()){
            LOG.info("не найдено {}", dto.id);
            return null;
        }
        Flight flight = in.get();
      
        String arrivalDate = dto.arrivalDate.replace("T", " ");
        LocalDateTime dateTime = LocalDateTime.parse(arrivalDate + ":00",
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        flight.setArrivalDate(dateTime);
        String departureDate = dto.departureDate.replace("T", " ");
        LocalDateTime dateTime1 = LocalDateTime.parse(departureDate + ":00",
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        flight.setDepartureDate(dateTime1);
        flight.setTicketPrice(dto.ticketPrice);

        try{    
            LOG.info("Try update{}", dto.id);
           return flightRepository.save(flight);
         
        } catch (Exception e){
            LOG.error("Failed update flight: {}", e);
            return null;
        }
       
    }



}
