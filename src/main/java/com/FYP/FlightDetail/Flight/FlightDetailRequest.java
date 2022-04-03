package com.FYP.FlightDetail.Flight;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class FlightDetailRequest {
    @NotBlank( message = "The flight code should not be empty")
    private String flightCode;
    @NotBlank( message = "The departure date should not be empty")
    private String departureDate;
    @NotBlank( message = "The departure time should not be empty")
    private String departureTime;
    @NotBlank( message = "The status should not be empty")
    private String status;
    @NotBlank( message = "The sector code should not be empty")
    private String sectorCode;
    @NotBlank( message = "The aircraft code should not be empty")
    private String aircraft;
    @NotBlank(message = "The pilot should not be empty")
    private List<String> pilotCodes;
    @NotBlank(message = "The ca")
    private List<String> cabinCrewCodes;
}
