package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.TicketDto;

import java.util.List;

public interface TicketService {
    TicketDto save(TicketDto ticketDto);

    TicketDto findById(Long id);

    void delete(Long id);

    List<TicketDto> findAll();
}
