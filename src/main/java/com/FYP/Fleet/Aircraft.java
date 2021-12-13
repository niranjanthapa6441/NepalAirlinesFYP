package com.FYP.Fleet;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "aircraft")
public class Aircraft {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @Column(name = "aircraft_name")
    private String name;
    @Column(name = "aircraft_code")
    private String aircraftCode;
    @Column(name = "number_of_seats")
    private int numberOfSeats;
    @Column(name = "status")
    private String status;
}
