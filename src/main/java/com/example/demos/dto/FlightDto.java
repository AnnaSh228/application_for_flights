package com.example.demos.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FlightDto {
    public String flyNumber;
    
    public boolean flightCancellation;
 
    public float ticketPrice;
    
    public float flightDuration;
    
    public float distanceInKm;
   
    public String departureAirport;
   
    public String arrivalAirport;


}
