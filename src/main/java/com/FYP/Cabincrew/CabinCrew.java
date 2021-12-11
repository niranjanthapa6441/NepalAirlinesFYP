package com.FYP.Cabincrew;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cabin_crew")
public class CabinCrew {
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
    @Column(name = "status")
    private String status;
}
