package Flight.Tickets.service;

import Flight.Tickets.model.FlightDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "flights-api")
public interface FlightClient {

    @GetMapping("/flights")
    List<FlightDTO> getAllFlights();
}
