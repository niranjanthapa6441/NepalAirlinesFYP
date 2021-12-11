package com.FYP.Flight.Sector;

import lombok.Data;

@Data
public class SectorRequest {
    private String sector;
    private String from;
    private String to;
    private String duration;
    private String status;
}
