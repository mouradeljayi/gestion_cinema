package com.elj.gestioncinema.controllers;

import com.elj.gestioncinema.dto.TicketDto;
import com.elj.gestioncinema.services.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("tickets")
public class TicketController {

    TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("")
    public ResponseEntity<TicketDto> save(@Valid @RequestBody TicketDto ticketDto) {
        return new ResponseEntity<>(ticketService.save(ticketDto), HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<TicketDto> findById(@PathVariable Long id) {
        TicketDto ticketDto = ticketService.findById(id);
        return ResponseEntity.ok(ticketDto);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ticketService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("")
    public ResponseEntity<List<TicketDto>> getTickets() {
        return new ResponseEntity<>(ticketService.findAll(), HttpStatus.OK);
    }
}
