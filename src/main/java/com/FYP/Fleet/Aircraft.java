package com.FYP.Fleet;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

@Data
@Entity
@Table(name = "BUDDHA_AIRCRAFT")
public class Aircraft {
    private String id;
    private String name;
    private String aircraftCode;
    private int numberOfSeats;
    private String status;
}
