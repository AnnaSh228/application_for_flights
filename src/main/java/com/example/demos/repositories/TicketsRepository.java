package com.example.demos.repositories;

import com.example.demos.entity.Tickets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Long>{
 
 // Tickets findTicketByUsername(String username);
 // Tickets findTicketById(long id);

 // void deleteTicketById(long id);
}