package com.FYP.Ticket;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="ticket")
public class Ticket {
    @Id
    private String id;
}
