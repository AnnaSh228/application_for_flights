package com.example.demos.controllers;

import java.util.List;
import java.util.Optional;

import com.example.demos.dto.FilterDto;
import com.example.demos.dto.FlightDto;
import com.example.demos.entity.Flight;
import com.example.demos.repositories.FlightRepository;
import com.example.demos.services.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightService flightService;

    @GetMapping("")
    public String flightsPage(Model model){
       List <Flight> list=flightService.getFlightList();
       model.addAttribute("flights",list);
       model.addAttribute("filterDto", new FilterDto());

    return "flights";
    }

    @PostMapping("/filter")
    public String filterPage(Model model, FilterDto flightDto){
       List <Flight> list=flightService.getFilterList(flightDto);
       model.addAttribute("flights", list);
       model.addAttribute("filterDto", new FilterDto());

        return "flights";
    }

    @GetMapping("/new")
    public String createFlightPage(Model model){
        model.addAttribute("flightDto", new FlightDto());
        return "newFlight";
    }
    

    @PostMapping("/new")
    public String createFlight(FlightDto flightDto, Model model){
        flightService.createFlight(flightDto);
        return "redirect:/flights/";
    }
    

    @GetMapping("/{id}")
    public String detailFlightPage(@PathVariable("id") long flightId, Model model){
        Flight flight = flightService.getFlight(flightId);
        model.addAttribute("flights", flight);


        return "detailFlight";
        
    }
    @PostMapping("/{id}")
    public String detailFlight(long flightId, Model model){
       
       flightService.getFlight(flightId);
        return "redirect:/flights/detailFlight";
    }     
    @DeleteMapping("/{id}")
    public void deleteFlight(long flightId, Model model){
        flightService.deleteFlight(flightId);
    }
}
