package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.TicketDto;
import com.elj.gestioncinema.exceptions.EntityNotFoundException;
import com.elj.gestioncinema.model.Ticket;
import com.elj.gestioncinema.repositories.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements  TicketService{

    TicketRepository ticketRepository;
    ModelMapper modelMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TicketDto save(TicketDto ticketDto) {
        Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
        Ticket saved = ticketRepository.save(ticket);
        return modelMapper.map(saved, TicketDto.class);
    }

    @Override
    public TicketDto findById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Ticket Not Found"));
        return modelMapper.map(ticket, TicketDto.class);
    }

    @Override
    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public List<TicketDto> findAll() {
        return ticketRepository.findAll().stream()
                .map(el->modelMapper.map(el,TicketDto.class))
                .collect(Collectors.toList());
    }
}
