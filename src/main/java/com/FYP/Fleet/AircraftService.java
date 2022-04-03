package com.FYP.Fleet;

import org.springframework.stereotype.Service;

@Service
public interface AircraftService {
    AircraftDTO save(AircraftRequest request);
    Iterable<Aircraft> findAll();
    AircraftDTO findById(String id);
    AircraftDTO update(String id,AircraftRequest request);
    AircraftDTO delete(String id);
}
