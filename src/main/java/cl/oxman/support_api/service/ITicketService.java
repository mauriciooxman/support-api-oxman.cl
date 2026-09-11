package cl.oxman.support_api.service;

import cl.oxman.support_api.dto.CreateTicketRequest;
import cl.oxman.support_api.dto.TicketResponse;

import java.util.List;

public interface ITicketService {
    TicketResponse crear(CreateTicketRequest request);
    List<TicketResponse> listar();
    TicketResponse buscarPorId(Long id);
}
