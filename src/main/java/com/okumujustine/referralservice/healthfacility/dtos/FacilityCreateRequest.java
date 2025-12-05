package com.okumujustine.referralservice.healthfacility.dtos;

import com.okumujustine.referralservice.healthfacility.HealthFacilityType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FacilityCreateRequest {

    @NotBlank
    private String name;

    @NotNull
    private HealthFacilityType type;

    private String country;

    private String region;
    private String district;
    private String city;
}