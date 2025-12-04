package com.okumujustine.CareBridge.healthfacility.dtos;


import com.okumujustine.CareBridge.healthfacility.HealthFacilityType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FacilityWithApiKeyResponse {

    private String id;
    private String name;
    private HealthFacilityType type;
    private String country;
    private String region;
    private String district;
    private String city;

    /**
     * This is the API key the facility will use in X-API-Key header.
     */
    private String apiKey;
}