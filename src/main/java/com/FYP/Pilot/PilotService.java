package com.FYP.Pilot;

import com.FYP.Cabincrew.CabinCrew;
import com.FYP.Cabincrew.CabinCrewDTO;
import com.FYP.Cabincrew.CabinCrewRequest;
import org.springframework.stereotype.Service;

@Service
public interface PilotService {
    PilotDTO save(PilotRequest request);
    Iterable<Pilot> findAll();
    PilotDTO findById(String id);
    PilotDTO update(String id,PilotRequest request);
    PilotDTO delete(String id);
}
