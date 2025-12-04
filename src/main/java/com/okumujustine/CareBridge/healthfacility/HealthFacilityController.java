package com.okumujustine.CareBridge.healthfacility;
import com.okumujustine.CareBridge.healthfacility.dtos.FacilityWithApiKeyResponse;
import com.okumujustine.CareBridge.healthfacility.dtos.FacilityCreateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/facilities")
@RequiredArgsConstructor
@Tag(name = "Health Facilities", description = "Manage health facilities and their API keys")
public class HealthFacilityController {

    private final HealthFacilityService healthFacilityService;

    @PostMapping
    @Operation(
            summary = "Create a new health facility and API key",
            description = """
                    Creates a health facility in the CareBridge network and generates 
                    an API key that the facility will use in the X-API-Key header.
                    """
    )
    public FacilityWithApiKeyResponse createFacility(
            @Valid @RequestBody FacilityCreateRequest request
    ) {
        return healthFacilityService.createFacility(request);
    }
}
