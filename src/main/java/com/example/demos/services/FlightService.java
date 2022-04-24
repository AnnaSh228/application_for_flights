package com.example.demos.services;
import com.example.demos.dto.FlightDto;
import com.example.demos.entity.Flight;
import com.example.demos.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {


    private final FlightRepository flightRepository;

   

    @Autowired
    public FlightService(FlightRepository flightRepository){
        this.flightRepository=flightRepository;
    }

    public Flight createFly(FlightDto dto){
        Flight newFlight=new Flight();
        newFlight.setFlyNumber(dto.flyNumber);
        newFlight.setFlightCancellation(dto.flightCancellation);
        newFlight.setTicketPrice(dto.ticketPrice);
        newFlight.setFlightDuration(dto.flightDuration);
        newFlight.setDistanceInKm(dto.distanceInKm);
        newFlight.setDepartureAirport(dto.departureAirport);
        newFlight.setArrivalAirport(dto.arrivalAirport);
        return flightRepository.save(newFlight);
}

}
