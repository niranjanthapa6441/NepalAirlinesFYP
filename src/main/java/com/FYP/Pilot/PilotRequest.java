package com.FYP.Pilot;

import lombok.Data;

@Data
public class PilotRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String email;
    private String ICAONumber;
    private String CAANNumber;
    private String status;
}
