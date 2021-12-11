package com.FYP.Pilot;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@Data
public class PilotRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String email;
    private String ICAONumber;
    private String CIAANumber;
    private String status;
}
