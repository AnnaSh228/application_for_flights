package com.example.demos.services;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.demos.dto.FlightDto;
import com.example.demos.entity.Flight;
import com.example.demos.repositories.FlightRepository;


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
    public FlightService(FlightRepository flightRepository){
        this.flightRepository=flightRepository;
    }

    public Flight createFlight(FlightDto dto){
        Flight newFlight=new Flight();
        newFlight.setFlyNumber(dto.flyNumber);
     
        newFlight.setTicketPrice(dto.ticketPrice);
        newFlight.setFlightDuration(dto.flightDuration);
        newFlight.setDistanceInKm(dto.distanceInKm);
        newFlight.setDepartureAirport(dto.departureAirport);
        newFlight.setArrivalAirport(dto.arrivalAirport);
        newFlight.setCountry(dto.country);

        String arrivalDate = dto.arrivalDate.replace("T", " ");
        LocalDateTime dateTime = LocalDateTime.parse(arrivalDate + ":00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        newFlight.setArrivalDate(dateTime);

        String departureDate = dto.departureDate.replace("T", " ");
        LocalDateTime dateTime1 = LocalDateTime.parse(departureDate + ":00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        newFlight.setDepartureDate(dateTime1);

        try{
            LOG.info("Saving flight {}", dto.flyNumber);
            return flightRepository.save(newFlight);
        }catch(Exception e){
            LOG.error("Error {}", dto.flyNumber);
            throw new RuntimeException("Failed create flight");
        }
    }

public List <Flight> getFlightList(){
    List <Flight> list = flightRepository.findAll();
    
    return list;
}

public Flight getFlight(long id) {
    return flightRepository.findFlightById( id);
}
public boolean deleteFlight(long flightId){
    if (flightRepository.findById(flightId).isPresent()) {
        flightRepository.deleteById(flightId);
        return true;
    }
    return false;
}
// private Set<String> getCountryFromStr(String str){
//     String[] tags = str.split("&;");
//     return new HashSet<>(Arrays.asList(tags));
// }

public List<Flight> getByCountryFlight(String country) {
    List <Flight> flight = flightRepository.findAllFlightByCountry(country);
    return flight;
}

public List<Flight> allFlights() {
    return flightRepository.findAll();
}

public List<Flight> flightgtList(Long idMin) {
    return em.createQuery("SELECT u FROM Flight u WHERE u.id > :paramId", Flight.class)
            .setParameter("paramId", idMin).getResultList();
}

}
