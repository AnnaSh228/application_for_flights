package com.example.demos.dto;

import lombok.Data;

@Data
public class FlightUpdateDto {
   

    public long id;
    public float ticketPrice;

    public String arrivalDate;
    public String departureDate;


}
