package com.FYP.Flight;

import com.FYP.Flight.Sector.Sector;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
@Data
public class FlightRequest {
    private String flightCode;
    private Date departureDate;
    private Time departureTime;
    private String sector;
}
