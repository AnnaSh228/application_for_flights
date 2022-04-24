package com.example.demos.entity;

import java.time.LocalDateTime;

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
    private boolean flightCancellation;
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

  

    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalDate;

    @PrePersist
    protected void onCreate(){
        this.departureDate = LocalDateTime.now();
        this.arrivalDate = LocalDateTime.now();
    }

    
    
    
}
