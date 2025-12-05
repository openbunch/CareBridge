package com.okumujustine.referralservice.healthfacility;


import com.okumujustine.referralservice.healthfacility.dtos.FacilityCreateRequest;
import com.okumujustine.referralservice.healthfacility.dtos.FacilityWithApiKeyResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HealthFacilityService {

    private final HealthFacilityRepository healthFacilityRepository;
    private final ApiKeyRepository apiKeyRepository;

    @Transactional
    public FacilityWithApiKeyResponse createFacility(FacilityCreateRequest req) {
        // Save facility
        var facility = HealthFacility.builder()
                .name(req.getName())
                .type(req.getType())
                .country(req.getCountry())
                .region(req.getRegion())
                .district(req.getDistrict())
                .city(req.getCity())
                .build();

        facility = healthFacilityRepository.save(facility);

        // Generate API key
        String keyValue = UUID.randomUUID().toString();

        var apiKey = ApiKey.builder()
                .keyValue(keyValue)
                .facility(facility)
                .build();

        apiKeyRepository.save(apiKey);

        // Return facility info + API key
        return FacilityWithApiKeyResponse.builder()
                .id(facility.getId())
                .name(facility.getName())
                .type(facility.getType())
                .country(facility.getCountry())
                .region(facility.getRegion())
                .district(facility.getDistrict())
                .city(facility.getCity())
                .apiKey(keyValue)
                .build();
    }
}
