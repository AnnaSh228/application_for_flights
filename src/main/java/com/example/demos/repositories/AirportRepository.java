package com.example.demos.repositories;

import java.util.List;

import com.example.demos.entity.Airport;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
@Repository
public interface AirportRepository extends JpaRepository<Airport, Long>{
    // Airport findAirportByName(String name);
    // List <Airport> findAllByAirportCountry(String country);
}
