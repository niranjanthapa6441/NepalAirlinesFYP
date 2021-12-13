package FYP.Flight.CabinCrewFlight;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinCrewFlightRepo extends CrudRepository<CabinCrewFlight,String> {
    
}
