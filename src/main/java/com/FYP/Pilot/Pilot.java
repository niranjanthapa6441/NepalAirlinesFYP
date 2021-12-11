package com.FYP.Pilot;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "Pilot")
public class Pilot {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "cabin_crew_id")
    private String id;
    @Column(name = "first_name",nullable = false,length = 30)
    private String firstName;
    @Column(name = "last_name",nullable = false,length = 30)
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name ="phone_number",nullable = false,unique = true)
    private String phoneNumber;
    @Column(name ="email",nullable = false,unique = true)
    private String email;
    @Column(name ="ICAO_License_Number",nullable = false,unique = true)
    private String ICAONumber;
    @Column(name ="CIAA_License_Number",nullable = false,unique = true)
    private String CIAANumber;
    @Column(name = "status")
    private String status;
}
