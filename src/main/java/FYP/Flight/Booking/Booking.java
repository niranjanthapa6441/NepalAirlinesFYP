package FYP.Flight.Booking;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "booking")
public class Booking {
    @Id
    private String id;
}
