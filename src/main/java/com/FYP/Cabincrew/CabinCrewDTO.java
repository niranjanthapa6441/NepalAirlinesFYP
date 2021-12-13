package com.FYP.Cabincrew;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CabinCrewDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String email;
    private String status;
}
