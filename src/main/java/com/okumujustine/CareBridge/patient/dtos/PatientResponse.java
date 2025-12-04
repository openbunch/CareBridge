package com.okumujustine.CareBridge.patient.dtos;

import com.okumujustine.CareBridge.common.enums.Gender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientResponse {
    private String id;            // platform patient ID
    private String fullName;
    private Gender gender;
    private String dateOfBirth;   // ISO string
    private String phone;
}
