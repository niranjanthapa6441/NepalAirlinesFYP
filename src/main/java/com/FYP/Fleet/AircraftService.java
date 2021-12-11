package com.FYP.Fleet;

import com.FYP.Cabincrew.CabinCrew;
import com.FYP.Cabincrew.CabinCrewDTO;
import com.FYP.Cabincrew.CabinCrewRequest;
import org.springframework.stereotype.Service;

@Service
public interface AircraftService {
    AircraftDTO save(AircraftRequest request);
    Iterable<Aircraft> findAll();
    AircraftDTO findById(String id);
    AircraftDTO update(String id,AircraftRequest request);
    AircraftDTO delete(String id);
}
