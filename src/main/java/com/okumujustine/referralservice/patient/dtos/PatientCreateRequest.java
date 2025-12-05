package com.okumujustine.referralservice.patient.dtos;
import com.okumujustine.referralservice.common.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PatientCreateRequest {

    /**
     * Patient ID in the calling facility's system.
     * This is how we link back to them.
     */
    @NotBlank
    private String externalPatientId;

    @NotBlank
    private String fullName;

    @NotNull
    private Gender gender;

    /**
     * ISO-8601 date string, e.g. "1990-04-02".
     * We'll parse this into LocalDate.
     */
    @NotBlank
    private String dateOfBirth;

    private String phone;
}
