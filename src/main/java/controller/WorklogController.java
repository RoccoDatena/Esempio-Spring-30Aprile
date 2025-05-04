package controller;

import org.springframework.web.bind.annotation.*;

import entities.Worklog;
import lombok.RequiredArgsConstructor;
import servicies.WorklogService;

import java.util.List;

@RestController
@RequestMapping("/worklogs")
@RequiredArgsConstructor
public class WorklogController {
    private final WorklogService worklogService;

    @PostMapping("/{ticketId}")
    public Worklog addWorklog(
        @PathVariable Long ticketId,
        @RequestBody Worklog worklog
    ) {
        return worklogService.addWorklogToTicket(ticketId, worklog);
    }

    @GetMapping("/ticket/{ticketId}")
    public List<Worklog> getWorklogsByTicket(@PathVariable Long ticketId) {
        return worklogService.getWorklogsByTicket(ticketId);
    }
}