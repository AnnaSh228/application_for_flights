package com.example.demos.services;

import com.example.demos.dto.TicketsDto;
import com.example.demos.entity.Tickets;
import com.example.demos.repositories.TicketsRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class TicketsService {
    
    private TicketsRepository ticketsRepository;
    @Autowired
    public TicketsService(TicketsRepository ticketsRepository){
        this.ticketsRepository=ticketsRepository;
    }

    public Tickets createTickets (TicketsDto dto){
        Tickets newTickets=new Tickets();
        newTickets.setNameOfUser(dto.nameOfUser);
        newTickets.setNameOfFlight(dto.nameOfFlight);
        return newTickets;
    }

}
