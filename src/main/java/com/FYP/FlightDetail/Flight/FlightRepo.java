package com.FYP.FlightDetail.Flight;

import com.FYP.Fleet.Aircraft;
import com.FYP.FlightDetail.Sector.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<FlightDetail,String> {
    @Query("SELECT fd FROM FlightDetail fd where fd.flightCode=?1")
    FlightDetail findByFlightCode(String flightCode);
    @Query("SELECT ea FROM FlightDetail ea where ea.sector=?1 and ea.departureDate=?2")
    List<FlightDetail> findFlightBySectorAndDate(Sector sector, LocalDate date);

    @Query("SELECT count(*) FROM FlightDetail ea where ea.sector=?1 and ea.departureDate=?2 and ea.departureTime=?3" )
    int findFlightBySectorDateAndTime(Sector sector, LocalDate date, String time);

    @Query("SELECT count(*) FROM FlightDetail fd where fd.flightCode=?1")
    int countFlightCode(String flightCode);
}
