package servicies;

import java.util.List;

import org.springframework.stereotype.Service;

import entities.Ticket;
import entities.Worklog;
import lombok.RequiredArgsConstructor;
import repositories.TicketRepository;
import repositories.WorklogRepository;

@Service
@RequiredArgsConstructor
public class WorklogService {
    private final WorklogRepository worklogRepository;
    private final TicketRepository ticketRepository;

    public Worklog addWorklogToTicket(Long ticketId, Worklog worklog) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket non trovato"));
        
        worklog.setTicket(ticket);
        ticket.setStato(worklog.getStato()); // Aggiorna stato ticket
        
        return worklogRepository.save(worklog);
    }

    public List<Worklog> getWorklogsByTicket(Long ticketId) {
        return worklogRepository.findByTicketId(ticketId);
    }
}