package cl.oxman.support_api.dto;

import cl.oxman.support_api.entity.EstadoTicket;
import cl.oxman.support_api.entity.PrioridadTicket;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateTicketRequest (
        @NotNull(message = "El titulo es obligatorio")
        @Size(max = 150, message = "El maximo son 150 caracteres")
        String titulo,

        @NotNull(message = "La descripción es obligatoria")
        @Size(max = 150, message = "El maximo son 150 caracteres")
        String descripcion,

        @NotNull(message = "El estado es obligatorio")
        EstadoTicket estado,

        @NotNull(message = "La prioridad es obligatoria")
        PrioridadTicket prioridad


){
}
