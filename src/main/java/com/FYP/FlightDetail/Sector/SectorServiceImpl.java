package com.FYP.FlightDetail.Sector;

import com.FYP.Util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SectorServiceImpl implements SectorService{
    @Autowired
    private SectorRepo repository;
    @Override
    public SectorDTO save(SectorRequest request) {
        checkValidation(request);
        Sector sector= repository.save(toSector(request));
        return toSectorDTO(sector);
    }

    @Override
    public Iterable<Sector> findAll() {
        return repository.findAll();
    }

    @Override
    public SectorDTO findBySector(String sector) {
        Sector findSector= repository.findBySector(sector);
        if (findSector!=null){
            return toSectorDTO(findSector);
        }
        else{
            throw new NullPointerException("Sector Does not exist");
        }
    }

    @Override
    public SectorDTO update(String id, SectorRequest request) {
        checkValidation(request);
        Optional<Sector> sector= repository.findById(id);
        if (sector.isPresent()) {
            Sector updateSector= toSector(request);
            updateSector.setId(id);
            Sector updatedSector = repository.save(updateSector);
            return toSectorDTO(updatedSector);
        } else {
            throw new NullPointerException("Sector Does not Exist");
        }
    }

    @Override
    public SectorDTO delete(String id) {
        Optional<Sector> sector = repository.findById(id);
        if (sector.isPresent()) {
            Sector deleteSector = sector.get();
            deleteSector.setStatus("terminated");
            Sector deletedSector = repository.save(deleteSector);
            return toSectorDTO(deletedSector);
        } else {
            throw new NullPointerException("Sector does not exist");
        }
    }
    private void checkValidation(SectorRequest request) {
        int count=repository.countSectorCode(request.getSectorCode());
        if (count>0)
            throw new CustomException(CustomException.Type.SECTOR_ALREADY_EXISTS);
    }
    private SectorDTO toSectorDTO(Sector sector) {
        return SectorDTO.builder()
                .id(sector.getId())
                .sectorCode(sector.getSector_code())
                .duration(sector.getDuration())
                .from(sector.getDeparture())
                .to(sector.getArrival())
                .status(sector.getStatus())
                .build();
    }

    private Sector toSector(SectorRequest request) {
        Sector sector= new Sector();
        sector.setSector_code(request.getSectorCode());
        sector.setDuration(request.getDuration());
        sector.setDeparture(request.getFrom());
        sector.setId(request.getTo());
        sector.setStatus(request.getStatus());
        return sector;
    }
}
