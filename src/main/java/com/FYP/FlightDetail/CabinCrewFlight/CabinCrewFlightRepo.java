package com.FYP.FlightDetail.CabinCrewFlight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinCrewFlightRepo extends JpaRepository<CabinCrewFlight,String> {
    
}
