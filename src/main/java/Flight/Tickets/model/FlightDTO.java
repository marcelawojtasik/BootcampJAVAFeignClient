package Flight.Tickets.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightDTO {
    private Long id;
    private String origin;
    private String destiny;
    private String departureTime;
    private String arrivalTime;
    private double convertedPrice;
    private String frequency;

}
