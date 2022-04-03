package com.FYP.FlightDetail.Flight;

import com.FYP.Cabincrew.CabinCrew;
import com.FYP.Fleet.Aircraft;
import com.FYP.FlightDetail.Sector.Sector;
import com.FYP.Pilot.Pilot;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class FlightDTO {
    private String id;
    private String flightCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String departureDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String departureTime;
    private Sector sector;
    private Aircraft aircraft;
    private List<Pilot> pilots;
    private List<CabinCrew> crewList;
    private String status;
}
