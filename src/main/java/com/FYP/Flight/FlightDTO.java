package com.FYP.Flight;

import com.FYP.Flight.Sector.Sector;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import java.sql.Time;
import java.util.Date;
@Data
@Builder
public class FlightDTO {
    private String flightCode;
    private Date departureDate;
    private Time departureTime;
    private Sector sector;
}
