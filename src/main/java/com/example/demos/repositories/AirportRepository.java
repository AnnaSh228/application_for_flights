package com.example.demos.repositories;

import com.example.demos.entity.Airport;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long>{
    
}
