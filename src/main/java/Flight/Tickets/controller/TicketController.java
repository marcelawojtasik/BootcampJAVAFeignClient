package Flight.Tickets.controller;

import Flight.Tickets.model.FlightDTO;
import Flight.Tickets.model.Ticket;
import Flight.Tickets.service.FlightClient;
import Flight.Tickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private FlightClient flightClient;

    @GetMapping("/all")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/flights")
    public List<FlightDTO> getAllFlights(){
        return flightClient.getAllFlights();
    }

    @PostMapping("/add")
    public Ticket addTicket(@RequestBody Ticket ticket){
        return ticketService.addTicket(ticket);
    }
}
