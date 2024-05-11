package Flight.Tickets.service;

import Flight.Tickets.controller.FlightController;
import Flight.Tickets.model.FlightDTO;
import Flight.Tickets.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Service
public class TicketService {

    @Autowired FlightClient flightClient;


    public final List<Ticket> tickets = new ArrayList<>();
    FlightDTO flight1 = new FlightDTO(2052L, "Nueva York", "Los Ángeles", "2024-03-24 08:00", "2024-03-24 11:30", 671673.6, "Diario");
    FlightDTO flight2 = new FlightDTO(2053L, "Los Ángeles", "Miami", "2024-03-25 10:30", "2024-03-25 16:00", 691766.4, "Semanal");
    FlightDTO flight3 = new FlightDTO(2054L, "Miami", "Chicago", "2024-03-26 09:45", "2024-03-26 12:15", 551116.8, "Diario");


    Ticket ticket1 = new Ticket(123456L, flight1 , "Copito", "copo@mail.com", "2589654");
    Ticket ticket2 = new Ticket(234567L, flight2 , "Pimpon", "pim@mail.com", "6598544");
    Ticket ticket3 = new Ticket(345678L, flight3, "Cony", "cony@mail.com", "69854786");

    public void addTickets(){
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
    }

    public Ticket createTicket(Ticket createdTicket){
        tickets.add(createdTicket);
        return createdTicket;
    }

    public Ticket createTicketWithFlight(Ticket createdTicket, Long flightId){
        FlightDTO flight = flightClient.getFlight(flightId);
        createdTicket.setFlight(flight);
        tickets.add(createdTicket);
        return createdTicket;
    }

    public List<Ticket> readAllTickets(){
        //addTickets();
        return tickets;
    }

    public Ticket searchTicketById(Long id) {
        addTickets();

        for (int i = 0; i < tickets.size(); i++) {
                if(Objects.equals(tickets.get(i).getId(), id)){
                Ticket ticket= tickets.get(i);
                return ticket;
                }
            } return null;
    }

    public Ticket updateTicketByPassenger(Long id, String name, String email, String passport) {
        addTickets();

        for (int i = 0; i < tickets.size(); i++) {
            if(Objects.equals(tickets.get(i).getId(), id)){
                Ticket ticket= tickets.get(i);
                ticket.setPassengerName(name);
                ticket.setPassengerEmail(email);
                ticket.setPassengerPassport(passport);
                System.out.println("Los nuevos datos del pasajero son:  "+ name +" "+email+" "+passport);
                return ticket;
            }
        } return null;
    }

    public void deleteTicket(Long id){
        Ticket ticketToDelete = searchTicketById(id);
        tickets.remove(ticketToDelete);
    }

}
