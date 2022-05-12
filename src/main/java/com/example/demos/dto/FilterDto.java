package com.example.demos.dto;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class FilterDto {
    String departureAirport = null;
    String arrivalAirport = null;
    String departureDate = null;
    String arrivalDate = null;

    public LocalDateTime getDepartureDate(){
        try{
            departureDate = departureDate.replace("T", " ");
            LocalDateTime dateTime = LocalDateTime.parse(departureDate + ":00",
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return dateTime;
        } catch(Exception e){
            return null;
        }
    }

    public LocalDateTime getArrivalDate(){
        try{
            arrivalDate = arrivalDate.replace("T", " ");
            LocalDateTime dateTime = LocalDateTime.parse(arrivalDate + ":00",
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return dateTime;
        } catch(Exception e){
            return null;
        }
    }
}
