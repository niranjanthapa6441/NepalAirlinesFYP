package com.FYP.FlightDetail.PilotFlight;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotFlightRepo extends CrudRepository<PilotFlight,String> {
}
