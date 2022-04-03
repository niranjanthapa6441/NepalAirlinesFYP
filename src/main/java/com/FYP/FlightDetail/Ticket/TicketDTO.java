package com.FYP.FlightDetail.Ticket;


import com.FYP.FlightDetail.Ticket.BaggagePolicy.BaggagePolicy;
import com.FYP.FlightDetail.Ticket.CancellationPolicy.CancellationPolicy;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDTO {
    private int id;
    private String ticketCode;
    private int price;
    private String Status;
    private CancellationPolicy cancellationPolicy;
    private BaggagePolicy baggagePolicy;

}
