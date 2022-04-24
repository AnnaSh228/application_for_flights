package com.example.demos.controllers;

import java.util.List;

import com.example.demos.entity.Flight;
import com.example.demos.services.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    
}
