package Flight.Tickets.controller;

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


    @PostMapping("/add")
    public Ticket addTicket(@RequestBody Ticket ticket){
        return ticketService.createTicket(ticket);
    }

    @PostMapping("/addTk/{flightId}")
    public Ticket addTicket(@RequestBody Ticket ticket, @PathVariable Long flightId){
        return ticketService.createTicketWithFlight(ticket, flightId);
    }

    @GetMapping("/all")
    public List<Ticket> getAllTickets(){
        return ticketService.readAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket searchTicket(@PathVariable Long id){
        return ticketService.searchTicketById(id);
    }

    @PutMapping("/update")
    public Ticket updateTicket(@RequestParam Long id, @RequestParam String name, @RequestParam String email, @RequestParam String passport){
        return ticketService.updateTicketByPassenger(id, name, email, passport);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
        return "El ticket ha sido eliminado";
    }
}
