package com.FYP.FlightDetail.Ticket;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="ticket")
public class Ticket {
    @SequenceGenerator(
            name = "ticket_id_seq",
            sequenceName = "ticket_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="ticket_sequence"
    )
    private int id;
    @Column(name = "ticket_code",nullable = false,unique = true)
    private String ticket_code;
    @Column(nullable = false)
    private int ticket_price;
    @Column(nullable = false)
    private String Status;
}
