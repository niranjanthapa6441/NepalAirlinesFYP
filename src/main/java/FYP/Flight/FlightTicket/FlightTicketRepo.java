package FYP.Flight.FlightTicket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightTicketRepo extends CrudRepository<FlightTicket,String> {
}
