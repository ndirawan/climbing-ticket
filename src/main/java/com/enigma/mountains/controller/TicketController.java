package com.enigma.mountains.controller;

import com.enigma.mountains.entity.Ticket;
import com.enigma.mountains.service.TicketService;
import com.enigma.mountains.utils.constant.ApiUrlConstants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiUrlConstants.TICKET_PATH)
public class TicketController {
    TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @PostMapping
    public List<Ticket> addTicket(@RequestBody List<Ticket> tickets){
        return ticketService.addTicket(tickets);
    }
    @GetMapping
    public List<Ticket> getAllTicket(){
        return ticketService.getAllTicket();
    }
    @GetMapping("/{id}")
    public Ticket findTicketById(@PathVariable String id){
        return ticketService.findTicketById(id);
    }
    @PutMapping
    public Ticket updateTicket(@RequestBody Ticket ticket){
        return ticketService.updateTicket(ticket);
    }
}
