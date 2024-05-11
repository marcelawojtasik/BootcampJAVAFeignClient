package Flight.Tickets.service;

import Flight.Tickets.model.FlightDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "flights-api")
public interface FlightClient {

    @GetMapping("/flights/all")
    List<FlightDTO> getAllFlights();

    @GetMapping("/flights/id{id}")
    FlightDTO getFlight(@PathVariable Long id);
}
