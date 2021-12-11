package com.FYP.Flight.Sector;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SectorRepo extends CrudRepository<Sector,String> {
    @Query("SELECT s FROM Sector s where s.sector=?1")
    Sector findBySector(String sector);
}
