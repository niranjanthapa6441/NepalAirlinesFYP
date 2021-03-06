package com.FYP.BookingDetail.Booking;

import com.FYP.BookingDetail.Passenger.Passenger;
import com.FYP.BookingDetail.Passenger.PassengerRepo;
import com.FYP.BookingDetail.Passenger.PassengerRequest;
import com.FYP.Customer.Customer;
import com.FYP.Customer.CustomerRepo;
import com.FYP.FlightDetail.Flight.FlightDetail;
import com.FYP.FlightDetail.Flight.FlightRepo;
import com.FYP.FlightDetail.FlightTicket.FlightTicket;
import com.FYP.FlightDetail.FlightTicket.FlightTicketRepo;
import com.FYP.FlightDetail.Ticket.Ticket;
import com.FYP.FlightDetail.Ticket.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepo repo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private FlightTicketRepo flightTicketRepo;
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private FlightRepo flightRepo;
    @Autowired
    private PassengerRepo passengerRepo;

    @Override
    public Iterable<Booking> findAll() {
        return repo.findAll();
    }

    @Override
    public BookingDTO update(String id, BookingRequest request) {
        return null;
    }

    @Override
    public BookingDTO save(BookingRequest request) {
        Booking booking = repo.save(toBooking(request));
        toPassengers(booking,request.getPassengerList());
        return toBookingDTO(booking);
    }

    @Override
    public BookingDTO delete(String id) {
        return null;
    }

    @Override
    public BookingDTO findById(String id) {
        Optional<Booking> booking=repo.findById(id);
        List<Passenger> passengers = new ArrayList<>();
        if (booking.isPresent()) {
            passengers=passengerRepo.findPassengerByBookingId(booking.get());
        }
        return toFindByBookingIdDTO(booking.get(),passengers);
    }

    @Override
    public Iterable<Booking> findByCustomerId(String id) {
        Optional<Customer> customer= customerRepo.findById(id);
        if (customer.isEmpty())
            throw new NullPointerException("The Customer Doesn't exist");
        Iterable<Booking> bookings=repo.findBookingByCustomerId(customer);
        return bookings;
    }

    private Booking toBooking(BookingRequest request) {
        Ticket ticket = getTicket(request);
        FlightDetail flightDetail = getFlightDetail(request);
        FlightTicket flightTicket = getFlightTicket(ticket, flightDetail);
        Optional<Customer> findCustomer = getCustomer(request);
        Booking booking = getBooking(request, flightTicket, findCustomer);
        return booking;
    }

    private Booking getBooking(BookingRequest request, FlightTicket flightTicket, Optional<Customer> findCustomer) {
        Booking booking = new Booking();
        booking.setBookingDate(LocalDate.now());
        booking.setBookingTime(LocalTime.now());
        booking.setCustomer(findCustomer.get());
        booking.setFlightTicket(flightTicket);
        booking.setStatus(request.getStatus());
        return booking;
    }

    private Ticket getTicket(BookingRequest request) {
        Ticket ticket = ticketRepo.findByTicketCode(request.getTicketCode());
        if (ticket == null)
            throw new NullPointerException("The Ticked Does not Exist");
        return ticket;
    }

    private FlightDetail getFlightDetail(BookingRequest request) {
        FlightDetail flightDetail = flightRepo.findByFlightCode(request.getFlightCode());
        if (flightDetail == null)
            throw new NullPointerException("The detail of the flight does not exist");
        return flightDetail;
    }

    private FlightTicket getFlightTicket(Ticket ticket, FlightDetail flightDetail) {
        FlightTicket flightTicket = flightTicketRepo.findFlightTicket(flightDetail, ticket);
        if (flightTicket == null)
            throw new NullPointerException("The ticket for the flight does not exist");
        return flightTicket;
    }

    private Optional<Customer> getCustomer(BookingRequest request) {
        Optional<Customer> findCustomer = customerRepo.findById(request.getCustomerId());
        if (findCustomer.isEmpty())
            throw new NullPointerException("The Customer Does not Exist");
        return findCustomer;
    }

    private void toPassengers(Booking booking, List<PassengerRequest> passengerList) {
        for (PassengerRequest passengerRequest:passengerList
             ) {
            Passenger passenger = getPassenger(booking, passengerRequest);
            passengerRepo.save(passenger);
        }
    }

    private Passenger getPassenger(Booking booking, PassengerRequest passengerRequest) {
        Passenger passenger= new Passenger();
        passenger.setFirstName(passengerRequest.getFirstName());
        passenger.setMiddleName(passengerRequest.getLastName());
        passenger.setLastName(passengerRequest.getLastName());
        passenger.setPhoneNumber(passengerRequest.getPhoneNumber());
        passenger.setBooking(booking);
        return passenger;
    }

    private BookingDTO toBookingDTO(Booking booking) {
        return BookingDTO.builder().
                id(booking.getId()).
                bookingDate(String.valueOf(booking.getBookingDate())).
                bookingTime(String.valueOf(booking.getBookingTime())).
                customer(booking.getCustomer()).
                flightTicket(booking.getFlightTicket()).
                status(booking.getStatus()).build();
    }
    private BookingDTO toFindByBookingIdDTO(Booking booking, List<Passenger> passengers) {
        return BookingDTO.builder().
                id(booking.getId()).
                bookingDate(String.valueOf(booking.getBookingDate())).
                bookingTime(String.valueOf(booking.getBookingTime())).
                customer(booking.getCustomer()).
                flightTicket(booking.getFlightTicket()).
                passengerList(passengers).
                status(booking.getStatus()).build();
    }
}
