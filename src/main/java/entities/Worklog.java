package entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "worklog") // Nome tabella lowercase
@Data
public class Worklog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private LocalDateTime data;
    
    private String descrizione;
    
    @Enumerated(EnumType.STRING)
    private Stato stato;
    
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @PrePersist
    protected void onCreate() {
        data = LocalDateTime.now();
    }
}