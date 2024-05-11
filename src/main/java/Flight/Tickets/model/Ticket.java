package Flight.Tickets.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private Long id;
    private FlightDTO flight;
    private String passengerName;
    private String passengerEmail;
    private String passengerPassport;

}

