package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Worklog;

import java.util.List;

@Repository
public interface WorklogRepository extends JpaRepository<Worklog, Long> {
    List<Worklog> findByTicketId(Long ticketId);
}