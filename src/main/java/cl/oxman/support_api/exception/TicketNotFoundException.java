package cl.oxman.support_api.exception;

//Lo que devolvemos cuando hay una excepcion
public class TicketNotFoundException extends RuntimeException{
    public TicketNotFoundException(Long id){
        super("Ticket con id " + id + " no encontrado");
    }
}
