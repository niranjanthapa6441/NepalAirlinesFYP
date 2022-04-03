package com.FYP.BookingDetail.Booking;

import com.FYP.BookingDetail.Passenger.Passenger;
import com.FYP.Customer.Customer;
import com.FYP.FlightDetail.FlightTicket.FlightTicket;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookingDTO {
    private String id;
    private FlightTicket flightTicket;
    private Customer customer;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String bookingDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private String bookingTime;
    private String numberOfTraveller;
    private String totalPrice;
    private String status;
    private List<Passenger> passengerList;
}
