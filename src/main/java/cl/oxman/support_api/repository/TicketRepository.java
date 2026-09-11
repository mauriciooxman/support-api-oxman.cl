package cl.oxman.support_api.repository;

import cl.oxman.support_api.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
