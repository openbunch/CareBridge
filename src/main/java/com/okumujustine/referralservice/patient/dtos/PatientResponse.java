package com.okumujustine.referralservice.patient.dtos;

import com.okumujustine.referralservice.common.enums.Gender;
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
