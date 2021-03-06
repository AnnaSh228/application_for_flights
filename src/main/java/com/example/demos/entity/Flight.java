package com.example.demos.entity;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;



@Data
@Entity
@Table(name="flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length=10)
    private String flyNumber;
    @Column
    private float ticketPrice;

    @Column(nullable = false)
    private float distanceInKm;
    @Column
    private String departureAirport;
    @Column
    private String arrivalAirport;
    @Column
    private String countryDeparture;
    @Column
    private String countryArrival;
 
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalDate;

    public Flight(){
    }
  
    public Flight(String flyNumber, float ticketPrice,  float distanceInKm,String departureAirport,String arrivalAirport, String countryDeparture,String countryArrival){
        this.flyNumber=flyNumber;
       
        this.ticketPrice=ticketPrice;
 
        this.distanceInKm=distanceInKm;
        this.departureAirport=departureAirport;
        this.arrivalAirport=arrivalAirport;
        this.countryDeparture=countryDeparture;
        this.countryArrival=countryArrival;
    }
    


  
    public String getDepartureDateStr(){
        String date = departureDate.toString();
        date = date.replace("T", " ");
        date = date.substring(0, 16);
        return date;
    }

    public String getArrivalDateStr(){
        String date = arrivalDate.toString();
        date = date.replace("T", " ");
        date = date.substring(0, 16);
        return date;
    }

}
