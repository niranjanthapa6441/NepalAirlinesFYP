package com.FYP.Sector;

import lombok.Data;

@Data
public class SectorRequest {
    private String sectorName;
    private String from;
    private String to;
    private String duration;
    private String status;
}
