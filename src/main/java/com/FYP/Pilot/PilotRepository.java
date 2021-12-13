package com.FYP.Pilot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotRepository extends CrudRepository<Pilot,String> {

}
