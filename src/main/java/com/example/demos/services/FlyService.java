package com.example.demos.services;
import com.example.demos.dto.FlyDto;
import com.example.demos.entity.Fly;
import com.example.demos.repositories.FlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FlyService {

 
    private final FlyRepository flyRepository;

   

    @Autowired
    public FlyService(FlyRepository flyRepository){
        this.flyRepository=flyRepository;
    }

    public Fly createFly(FlyDto dto){
        Fly newFly=new Fly();
        newFly.setMaximumFuel(dto.maximumFuel);
        newFly.setFuelConsumption(dto.fuelConsumption);
        return flyRepository.save(newFly);
}
    
}
