package com.example.demos.services;
import java.util.ArrayList;
import java.util.List;

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

   

    @Autowired
    public FlightService(FlightRepository flightRepository){
        this.flightRepository=flightRepository;
    }

    public Flight createFlight(FlightDto dto){
        Flight newFlight=new Flight(null, false, 0, 0, 0, null, null);
        newFlight.setFlyNumber(dto.flyNumber);
        newFlight.setFlightCancellation(dto.flightCancellation);
        newFlight.setTicketPrice(dto.ticketPrice);
        newFlight.setFlightDuration(dto.flightDuration);
        newFlight.setDistanceInKm(dto.distanceInKm);
        newFlight.setDepartureAirport(dto.departureAirport);
        newFlight.setArrivalAirport(dto.arrivalAirport);
        try{
            LOG.info("Saving flight {}", dto.flyNumber);
            return flightRepository.save(newFlight);
        }catch(Exception e){
            LOG.error("Error {}", dto.flyNumber);
            throw new RuntimeException("Failed create flight");
        }
    }

public List <Flight> getFlightList(){
    List <Flight> list= new ArrayList<>();
    list.add(new Flight("RFR432",false,5, 566,100,"Russia","USA"));
    return list;
}

public Flight getFlight(long id) {
    return flightRepository.findFlightById( id);
}

}
