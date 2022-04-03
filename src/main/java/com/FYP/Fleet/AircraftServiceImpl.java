package com.FYP.Fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AircraftServiceImpl implements AircraftService{
    @Autowired
    private AircraftRepository repository;
    @Override
    public AircraftDTO save(AircraftRequest request) {
        checkValidation(request);
        Aircraft aircraft = repository.save(toAircraft(request));
        return toAircraftDTO(aircraft);
    }

    @Override
    public Iterable<Aircraft> findAll() {
        return repository.findAll();
    }

    @Override
    public AircraftDTO findById(String id) {
        Optional<Aircraft> aircraft= repository.findById(id);
        if (aircraft.isPresent()){
            Aircraft aircraftDTO= aircraft.get();
            return toAircraftDTO(aircraftDTO);
        }
        else{
            throw new NullPointerException("Aircraft Does not exist");
        }
    }

    @Override
    public AircraftDTO update(String id, AircraftRequest request) {
        Optional<Aircraft> aircraft = repository.findById(id);
        if (aircraft.isPresent()) {
            Aircraft updateAircraft= toAircraft(request);
            updateAircraft.setId(id);
            Aircraft updatedAircraft = repository.save(updateAircraft);
            return toAircraftDTO(updatedAircraft);
        } else {
            throw new NullPointerException("Aircraft Does not Exist");
        }
    }

    @Override
    public AircraftDTO delete(String id) {
        Optional<Aircraft> aircraft = repository.findById(id);
        if (aircraft.isPresent()) {
            Aircraft deleteAircraft = aircraft.get();
            deleteAircraft.setStatus("terminated");
            Aircraft deletedAircraft = repository.save(deleteAircraft);
            return toAircraftDTO(deletedAircraft);
        } else {
            throw new NullPointerException("Aircraft does not exist");
        }
    }
    private void checkValidation(AircraftRequest request){
        //todo validation
    }
    private Aircraft toAircraft(AircraftRequest request){
        Aircraft aircraft= new Aircraft();
        aircraft.setAircraftCode(request.getAircraftCode());
        aircraft.setName(request.getName());
        aircraft.setNumberOfSeats(request.getNumberOfSeats());
        aircraft.setStatus(request.getStatus());
        return aircraft;
    }
    private AircraftDTO toAircraftDTO(Aircraft aircraft){
        return AircraftDTO.builder().
                id(aircraft.getId()).
                aircraftCode(aircraft.getAircraftCode()).
                name(aircraft.getName()).
                numberOfSeats(aircraft.getNumberOfSeats()).
                status(aircraft.getStatus())
                .build();
    }
}
