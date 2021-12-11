package com.FYP.Fleet;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AircraftDTO {
    private String id;
    private String name;
    private String aircraftCode;
    private int numberOfSeats;
    private String status;
}
