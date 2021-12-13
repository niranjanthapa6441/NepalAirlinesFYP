package FYP.Flight.FlightTicket;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "flight_ticket")
public class FlightTicket {
    @Id
    private String id;
}
