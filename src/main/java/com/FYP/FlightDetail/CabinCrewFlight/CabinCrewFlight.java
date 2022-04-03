package com.FYP.FlightDetail.CabinCrewFlight;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="cabin_crew_flight")
public class CabinCrewFlight {
    @Id
    private String id;
}
