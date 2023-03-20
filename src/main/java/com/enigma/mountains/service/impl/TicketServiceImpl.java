package com.enigma.mountains.service.impl;

import com.enigma.mountains.entity.Mountain;
import com.enigma.mountains.entity.Ticket;
import com.enigma.mountains.repository.TicketRepository;
import com.enigma.mountains.service.MountainService;
import com.enigma.mountains.service.TicketService;
import com.enigma.mountains.utils.customResponse.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TicketServiceImpl implements TicketService {
    TicketRepository ticketRepository;
    MountainService mountainService;

    public TicketServiceImpl(TicketRepository ticketRepository, MountainService mountainService) {
        this.ticketRepository = ticketRepository;
        this.mountainService = mountainService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public  List<Ticket> addTicket(List<Ticket> ticket) {
        try{
            for (Ticket x : ticket){
                Mountain mountain = mountainService.getMountainById(x.getMountain().getId());
                if(mountain.getQuota() > x.getQuantity()){
                    mountain.setQuota(mountain.getQuota() - x.getQuantity());
                }else throw new Exception("Jumlah ticket melebihi quota yang ada");
                mountainService.updateMountain(mountain);
                ticketRepository.saveAll(ticket);
            }
            return ticket;
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public Ticket findTicketById(String id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }
}
