package cl.oxman.support_api.dto;

import cl.oxman.support_api.entity.PrioridadTicket;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateTicketRequest(

@NotBlank
@Size(max = 150)
String titulo,

@NotBlank
@Size(max = 150)
String descripcion,

@NotNull
PrioridadTicket prioridad

) {
}
