package com.FYP.Cabincrew;

import org.springframework.stereotype.Service;

@Service
public interface CabinCrewService {
    CabinCrewDTO save(CabinCrewRequest request);
    Iterable<CabinCrew> findAll();
    CabinCrewDTO findById(String id);
    CabinCrewDTO update(String id,CabinCrewRequest request);
    CabinCrewDTO delete(String id);
}
