package cl.oxman.support_api.controller;


import cl.oxman.support_api.dto.CreateTicketRequest;
import cl.oxman.support_api.dto.TicketResponse;
import cl.oxman.support_api.entity.Ticket;
import cl.oxman.support_api.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketResponse crear (@Valid @RequestBody CreateTicketRequest request){
        return ticketService.crear(request);
    }

    @GetMapping
    public List<TicketResponse>listar(){
        return ticketService.listar();
    }

    @GetMapping("/{id}")
    public TicketResponse buscarPorId(@PathVariable Long id){
        return ticketService.buscarPorId(id);
    }
}
