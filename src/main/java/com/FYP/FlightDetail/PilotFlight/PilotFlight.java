package com.FYP.FlightDetail.PilotFlight;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "pilot_flight")
public class PilotFlight {
    @Id
    private String id;
}
