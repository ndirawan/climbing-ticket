package com.enigma.mountains.service;

import com.enigma.mountains.entity.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> addTicket(List<Ticket> ticket);
    Ticket findTicketById(String id);
    Ticket updateTicket(Ticket ticket);
    List<Ticket> getAllTicket();
}
