package com.FYP.BookingDetail.Booking;

import com.FYP.Customer.Customer;
import com.FYP.FlightDetail.FlightTicket.FlightTicket;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Entity
@Data
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "booking_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "flight_ticket_id")
    private FlightTicket flightTicket;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "booking_date",nullable = false)
    private LocalDate bookingDate;

    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "booking_time",nullable = false)
    private LocalTime bookingTime;

    @Column(name = "number_of_traveller",nullable = false)
    private int numberOfTraveller;

    @Column(name = "total_ticket_price",nullable = false)
    private int totalTicketPrice;

    private String status;
}
