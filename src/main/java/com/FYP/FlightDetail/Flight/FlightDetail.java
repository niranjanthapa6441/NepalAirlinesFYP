package com.FYP.FlightDetail.Flight;

import com.FYP.Fleet.Aircraft;
import com.FYP.FlightDetail.Sector.Sector;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


@Data
@Entity
@Table(name = "flight")
public class FlightDetail {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "flight_code",nullable = false,unique = true)
    private String flightCode;

    @Column(name = "departure_date",nullable = false)
    private LocalDate departureDate;

    @Column(name = "departure_time",nullable = false)
    private String departureTime;

    @Column(name = "number_of_available_seats",nullable = false)
    private int numberOfAvailableSeats;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @ManyToOne
    @JoinColumn
    private Aircraft aircraft;

    @Column(name = "status",nullable = false)
    private String status;

}
