package com.example.demos.dto;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class FilterDto {
    String countryDeparture = null;
    String countryArrival = null;
    String departureDate = null;
    String arrivalDate = null;

    public LocalDate getDepartureDate(){
        try{
            departureDate = departureDate.replace("T", " ");
            LocalDate date = LocalDate.parse(departureDate,
            DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return date;
        } catch(Exception e){
            return null;
        }
    }

    public LocalDate getArrivalDate(){
        try{
            arrivalDate = arrivalDate.replace("T", " ");
            LocalDate date = LocalDate.parse(arrivalDate,
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return date;
        } catch(Exception e){
            return null;
        }
    }
}
