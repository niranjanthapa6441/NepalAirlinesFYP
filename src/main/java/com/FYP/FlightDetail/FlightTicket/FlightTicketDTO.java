package com.FYP.FlightDetail.FlightTicket;

import com.FYP.FlightDetail.Flight.FlightDetail;
import com.FYP.FlightDetail.Ticket.Ticket;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class FlightTicketDTO {
    private String id;
    private Ticket ticket;
    private FlightDetail flightDetail;
}
