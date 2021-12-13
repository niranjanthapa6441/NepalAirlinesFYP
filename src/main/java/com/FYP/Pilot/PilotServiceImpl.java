package com.FYP.Pilot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PilotServiceImpl implements PilotService {
    @Autowired
    private PilotRepository repository;
    Pilot pilot;

    @Override
    public PilotDTO save(PilotRequest request) {
        checkValidation(request);
        Pilot pilot = repository.save(toPilot(request));
        return toPilotDTO(pilot);
    }

    @Override
    public Iterable<Pilot> findAll() {
        return repository.findAll();
    }

    @Override
    public PilotDTO findById(String id) {
        Optional<Pilot> pilot = repository.findById(id);
        if (pilot.isPresent()) {
            Pilot pilotDTO = pilot.get();
            return toPilotDTO(pilotDTO);
        } else {
            throw new NullPointerException("Pilot Does not Exist");
        }
    }

    @Override
    public PilotDTO update(String id, PilotRequest request) {
        Optional<Pilot> pilot = repository.findById(id);
        if (pilot.isPresent()) {
            Pilot updatePilot = toPilot(request);
            updatePilot.setId(id);
            Pilot updatedPilot = repository.save(updatePilot);
            return toPilotDTO(updatedPilot);
        } else {
            throw new NullPointerException("Crew Does not Exist");
        }
    }

    @Override
    public PilotDTO delete(String id) {
        Optional<Pilot> pilot = repository.findById(id);
        if (pilot.isPresent()) {
            Pilot deletePilot = pilot.get();
            deletePilot.setStatus("terminated");
            Pilot deletedPilot = repository.save(deletePilot);
            return toPilotDTO(deletedPilot);
        } else {
            throw new NullPointerException("Pilot Doesn't exist");
        }
    }

    private Pilot toPilot(PilotRequest request) {
        pilot = new Pilot();
        pilot.setFirstName(request.getFirstName());
        pilot.setLastName(request.getLastName());
        pilot.setMiddleName(request.getMiddleName());
        pilot.setEmail(request.getEmail());
        pilot.setCAANNumber(request.getCAANNumber());
        pilot.setICAONumber(request.getICAONumber());
        pilot.setStatus(request.getStatus());
        pilot.setPhoneNumber(request.getPhoneNumber());
        return pilot;
    }

    private PilotDTO toPilotDTO(Pilot pilot) {
        return PilotDTO.builder().
                id(pilot.getId()).
                CAANNumber(pilot.getCAANNumber()).
                firstName(pilot.getFirstName()).
                lastName(pilot.getLastName()).
                middleName(pilot.getMiddleName()).
                ICAONumber(pilot.getICAONumber()).
                status(pilot.getStatus()).
                phoneNumber(pilot.getPhoneNumber()).
                email(pilot.getEmail()).
                build();
    }

    private void checkValidation(PilotRequest request) {
        //todo validation
    }
}
