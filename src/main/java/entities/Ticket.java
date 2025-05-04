package entities;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ticket") // Nome tabella lowercase
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private LocalDateTime data;

    private String oggetto;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Worklog> worklogs;

    @PrePersist
    protected void onCreate() {
        data = LocalDateTime.now();
    }
}