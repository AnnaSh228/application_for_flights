package com.example.demos.controllers;

import java.util.List;

import com.example.demos.entity.Flight;
import com.example.demos.services.FlightService;
import com.example.demos.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private FlightService flightService;
    @GetMapping("")
    public String flightsPage(Model model){
       List <Flight> list=flightService.getFlightList();
       model.addAttribute("flights",list);
    return "flights";
    }

    @PostMapping("/admin")
    public String  deleteFlight(@RequestParam(required = true, defaultValue = "" ) Long flightId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            flightService.deleteFlight(flightId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/flights/{flightId}")
    public String  gtFlight(@PathVariable("flightId") Long flightId, Model model) {
        model.addAttribute("allFlights", flightService.flightgtList(flightId));
        return "admin";
    }
}
