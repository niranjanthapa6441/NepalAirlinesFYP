package com.FYP.Cabincrew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabinCrewServiceImpl implements CabinCrewService {
    @Autowired
    private CabinCrewRepository repository;

    CabinCrew cabinCrew;

    @Override
    public CabinCrewDTO save(CabinCrewRequest request) {
        cabinCrew = repository.save(toCabinCrew(request));
        return toCabinCrewDTO(cabinCrew);
    }

    @Override
    public Iterable<CabinCrew> findAll() {
        return repository.findAll();
    }

    @Override
    public CabinCrewDTO findById(String id) {
        Optional<CabinCrew> cabinCrew = repository.findById(id);
        if (cabinCrew.isPresent()) {
            CabinCrew crew = cabinCrew.get();
            return toCabinCrewDTO(crew);
        } else {
            throw new NullPointerException("Employee Does not Exist");
        }
    }

    @Override
    public CabinCrewDTO update(String id, CabinCrewRequest request) {
        Optional<CabinCrew> cabinCrew = repository.findById(id);
        if (cabinCrew.isPresent()) {
            CabinCrew updateCrew = toCabinCrew(request);
            updateCrew.setId(id);
            CabinCrew updatedCrew = repository.save(updateCrew);
            return toCabinCrewDTO(updatedCrew);
        } else {
            throw new NullPointerException("Crew Does not Exist");
        }
    }

    @Override
    public CabinCrewDTO delete(String id) {
        Optional<CabinCrew> crew = repository.findById(id);
        if (crew.isPresent()) {
            CabinCrew deleteCrew = crew.get();
            deleteCrew.setStatus("terminated");
            CabinCrew deletedCrew = repository.save(deleteCrew);
            return toCabinCrewDTO(deletedCrew);
        } else {
            throw new NullPointerException("Crew Doesn't exist");
        }
    }

    private CabinCrew toCabinCrew(CabinCrewRequest request) {
        cabinCrew = new CabinCrew();
        cabinCrew.setEmail(request.getEmail());
        cabinCrew.setFirstName(request.getFirstName());
        cabinCrew.setLastName(request.getLastName());
        cabinCrew.setStatus(request.getStatus());
        cabinCrew.setMiddleName(request.getMiddleName());
        cabinCrew.setPhoneNumber(request.getPhoneNumber());
        return cabinCrew;
    }

    private CabinCrewDTO toCabinCrewDTO(CabinCrew cabinCrew) {
        return CabinCrewDTO.builder().
                id(cabinCrew.getId()).
                email(cabinCrew.getEmail()).
                firstName(cabinCrew.getFirstName()).
                lastName(cabinCrew.getLastName()).
                middleName(cabinCrew.getMiddleName()).
                phoneNumber(cabinCrew.getPhoneNumber()).
                email(cabinCrew.getEmail()).
                status(cabinCrew.getStatus()).
                build();
    }
}
