package com.FYP.Cabincrew;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinCrewRepository extends JpaRepository<CabinCrew,String> {
}
