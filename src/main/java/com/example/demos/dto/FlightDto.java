package com.example.demos.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FlightDto {
    public String flyNumber;

    public float ticketPrice;


    public float distanceInKm;

    public String departureAirport;

    public String arrivalAirport;
    public String arrivalDate;
    public String departureDate;
    public String countryArrival;
    public String countryDeparture;

}
