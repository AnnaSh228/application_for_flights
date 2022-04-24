package com.example.demos.controllers;

import java.util.List;

import com.example.demos.dto.FlightDto;
import com.example.demos.entity.Flight;
import com.example.demos.services.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "redirect:/flight/";
    }
    

    @GetMapping("/{id}")
    public String detailFlightPage(@PathVariable("id") long flightId, Model model){
        Flight flight = flightService.getFlight(flightId);
        model.addAttribute("flight", flight);

        return "detailFlight";
        
    }
}
