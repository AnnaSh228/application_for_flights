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
    @Column
    private float flightDuration;
    @Column(nullable = false)
    private float distanceInKm;
    @Column
    private String departureAirport;
    @Column
    private String arrivalAirport;
    @Column
    private String country;

    public Flight(){
    }
  
    public Flight(String flyNumber, float ticketPrice, float flightDuration, float distanceInKm,String departureAirport,String arrivalAirport, String country){
        this.flyNumber=flyNumber;
       
        this.ticketPrice=ticketPrice;
        this.flightDuration=flightDuration;
        this.distanceInKm=distanceInKm;
        this.departureAirport=departureAirport;
        this.arrivalAirport=arrivalAirport;
        this.country=country;
    }
    
    

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalDate;

    @PrePersist
    protected void onCreate(){
        this.departureDate = LocalDateTime.now();
        this.arrivalDate = LocalDateTime.now();
    }
    public String getSDate(){
        String date = arrivalDate.toString();
        System.out.println(Arrays.toString(date.split("T")));
        date = date.split("T")[0];

        return date;
    }

    public String getSTime(){
        String time = arrivalDate.toString();
        time = time.split("T")[1];
        time = time.substring(0, 5);

        return time;
    }

    public String getSDate1(){
        String date = departureDate.toString();
        System.out.println(Arrays.toString(date.split("T")));
        date = date.split("T")[0];

        return date;
    }

    public String getSTime1(){
        String time = departureDate.toString();
        time = time.split("T")[1];
        time = time.substring(0, 5);

        return time;
    }


    
    
    
}
