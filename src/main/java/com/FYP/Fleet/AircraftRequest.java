package com.FYP.Fleet;

import lombok.Data;

@Data
public class AircraftRequest {
    private String name;
    private String aircraftCode;
    private int numberOfSeats;
    private String status;
}
