package com.FYP.Pilot;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PilotDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String ICAONumber;
    private String CAANNumber;
    private String email;
    private String status;
}
