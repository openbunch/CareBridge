package com.okumujustine.referralservice.referral.dtos;


import com.okumujustine.referralservice.referral.enums.ReferralPriority;
import com.okumujustine.referralservice.referral.enums.ReferralType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReferralCreateRequest {

    @NotBlank
    private String patientId;

    @NotBlank
    private String toFacilityId;

    @NotBlank
    private ReferralType referralType;

    @NotBlank
    private String serviceLine;

    @NotBlank
    private String reason;

    private ReferralPriority priority = ReferralPriority.ROUTINE;

    private String notes;
}