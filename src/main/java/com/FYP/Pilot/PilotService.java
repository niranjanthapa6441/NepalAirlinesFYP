package com.FYP.Pilot;

import org.springframework.stereotype.Service;

@Service
public interface PilotService {
    PilotDTO save(PilotRequest request);
    Iterable<Pilot> findAll();
    PilotDTO findById(String id);
    PilotDTO update(String id,PilotRequest request);
    PilotDTO delete(String id);
}
