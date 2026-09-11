package cl.oxman.support_api.dto;

import cl.oxman.support_api.entity.EstadoTicket;
import cl.oxman.support_api.entity.PrioridadTicket;


import java.time.LocalDate;

public record TicketResponse(
        Long id,
        String titulo,
        String descripcion,
        EstadoTicket estado,
        PrioridadTicket prioridad,
        LocalDate fechaCreacion
) {
}
