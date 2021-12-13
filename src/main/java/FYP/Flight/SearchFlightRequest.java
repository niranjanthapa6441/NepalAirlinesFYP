package FYP.Flight;

import lombok.Data;

@Data
public class SearchFlightRequest {
    private String trip;
    private String departureDate;
    private String arrivalDate;
    private String nationality;
}
