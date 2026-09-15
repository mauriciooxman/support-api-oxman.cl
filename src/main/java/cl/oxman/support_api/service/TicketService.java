package cl.oxman.support_api.service;

import cl.oxman.support_api.dto.CreateTicketRequest;
import cl.oxman.support_api.dto.TicketResponse;
import cl.oxman.support_api.entity.EstadoTicket;
import cl.oxman.support_api.entity.Ticket;
import cl.oxman.support_api.exception.TicketNotFoundException;
import cl.oxman.support_api.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService implements ITicketService {
    private final TicketRepository ticketRepository;


    @Override
    public TicketResponse crear(CreateTicketRequest request) {
        Ticket ticket = Ticket.builder()
                .titulo(request.titulo())
                .descripcion(request.descripcion())
                .prioridad(request.prioridad())
                .estado(EstadoTicket.ABIERTO)
                .fechaCreacion(LocalDate.now())
                .build();

        Ticket guardado = ticketRepository.save(ticket);


        return convertirResponse(guardado);
    }

    @Override
    public List<TicketResponse> listar() {
        return ticketRepository.findAll()
                .stream()
                .map(this::convertirResponse)
                .toList();
    }

    @Override
    public TicketResponse buscarPorId(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(()-> new TicketNotFoundException(id));
        return convertirResponse(ticket);

    }

    private TicketResponse convertirResponse(Ticket ticket){
        return new TicketResponse(
                ticket.getId(),
                ticket.getTitulo(),
                ticket.getDescripcion(),
                ticket.getEstado(),
                ticket.getPrioridad(),
                ticket.getFechaCreacion()

        );
    }
}
