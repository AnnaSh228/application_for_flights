package com.example.demos.services;
import com.example.demos.dto.AirportDto;
import com.example.demos.entity.Airport;
import com.example.demos.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AirportService {
    private final AirportRepository airportRepository;

   

    @Autowired
    public AirportService(AirportRepository airportRepository){
        this.airportRepository=airportRepository;
    }

    public Airport createFly(AirportDto dto){
        Airport newAirport=new Airport();
        newAirport.setCountry(dto.country);
        newAirport.setName(dto.name);
        return airportRepository.save(newAirport);
}
    
}
