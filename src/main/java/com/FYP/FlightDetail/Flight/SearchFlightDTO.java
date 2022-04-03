package com.FYP.FlightDetail.Flight;

import com.FYP.FlightDetail.Sector.Sector;
import com.FYP.FlightDetail.Ticket.Ticket;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class SearchFlightDTO {
    private String flightCode;
    private String departureDate;
    private String departureTime;
    private Sector Sector;
    private String status;
    private Ticket ticket;
}
